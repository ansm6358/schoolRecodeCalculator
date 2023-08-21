

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*1.Hasnext(25) 문제 -해결
delimeter (25)
   -delimeter 지정 가능(10)
Integer(25)
Float(25)
*/
public class Scanner {
	// instance variables
	private FileReader fileReader;
	private char[] delimeters = {0x0A, 0x0D, 0x20, 'x'}; 
	private int EOF = -1;
	private char minus = 0x2D; //음수
	private char dot = 0x2E; //소수점
	private char first =0x30; //0
	private char last = 0x39; //9
	private String first_word="";
	private boolean being;
	public Scanner(File file) throws FileNotFoundException {
		this.fileReader = new FileReader(file);
	}
	
	public boolean hasNext() throws IOException {
		boolean eof = true;
		boolean del = true;
		int i = 0;
		int input = this.fileReader.read();
		while(del) {
			if(i==delimeters.length){ //딜리미터 아니면 숫자 저장
			first_word =first_word + (char)input;
			being = true;
			del = false;}
		else if(input == delimeters[i]) { //딜리미터면 패스
			being = false;
			del = false;
			}
		else if(!(input == delimeters[i])) {
				i++;
			}	
		}	
		if(input==EOF) { //EOF면 close
			this.fileReader.close();
			eof = false;
		}
		return eof;
	}
	
	private int skipDelemeter() throws IOException {
			int i = 0;	
		int delemeter =0;
		int word = 0;
		boolean del = false;
		int hex = this.fileReader.read();
		while(!del) {
		if(i==delimeters.length){  //딜리미터 아니면 word에 저장
				word = hex;	
			del = true;}
		else if(hex == delimeters[i]) { //딜리미터면 delimeter에 저장
			delemeter = hex;
			int hex2=this.fileReader.read(); //딜리미터 아닐 때가지 읽기
			hex = hex2;
			i=0;
			}
		else if(!(hex == delimeters[i])) {
				i++;
			}	
		}	
		return word;
	}
	
	private boolean isDelimeter(int lastChar) {
		boolean Delimeter;
		Delimeter = false;
		
		for(int i=0; i<delimeters.length;i++) {
			if(lastChar==delimeters[i]) { //딜리미터 나오면 true
				Delimeter = true;
			}
		}
		if(lastChar==EOF) {  //EOF나오면 true
			Delimeter = true;
		}
		return Delimeter;
	}

	public String next() throws IOException {
		String result = new String();
		int lastChar = skipDelemeter(); //딜리미터만 패스
		while(!isDelimeter(lastChar)) { 
			if(being){		//딜리미터 아닌 숫자면 result에 저장
				result = result + first_word;
					being = false;	}
		result = result + (char)lastChar; //result에 딜리미터 전까지 저장
		first_word = ""; 
		lastChar = this.fileReader.read(); //딜리미터 전까지 읽기		
	}
		return result;
	}

	private int stringToInt(String string) {
		int currenVal = 0;
		boolean change = false;
		for(int i =0; i<string.length(); i++) {
			if(string.charAt(i)==minus) { //음수인 경우
				change = true;
				i++;
			}
			else if(string.charAt(i)>=first && string.charAt(i)<=last) //숫자인 경우
			currenVal = currenVal*10 + (string.charAt(i) & 0x0F); //00001111 and 시켜서 아스키캐릭터로 이진법으로 변환			
		
			else { //숫자가 아닌경우
				System.out.print("정수가 아닙니다. 옳은 숫자를 넣어주세요.");
			}

		}
		while(change) {  //음수인 경우 처리
			currenVal = 0 - currenVal;
			change = false;
		}
		return currenVal;
	}

	public float nextInt() throws IOException {
		String string = this.next();
		int result = stringToInt(string);
		return result;
	}
	
	private float stringToFloat(String string) {
		float currenVal = 0;
		float  decimal = 0;
		boolean change = false;
		boolean infront = true;
		for(int i =0; i<string.length(); i++) { 
			if(string.charAt(i)==minus) { //음수인 경우
				change = true;
			}
			else if(string.charAt(i) ==dot) { //소수점을 기준으로 계산
				infront = false;
			}
			else if(string.charAt(i)<first && string.charAt(i)>last) { //실수에 필요한 값이 아닌 경우
				System.out.print("실수가 아닙니다. 옳은 값을 넣어주세요."); 
			}
			else if (infront) { //소수점 앞
				currenVal = currenVal*10 + (string.charAt(i) & 0x0F); //00001111 and 시켜서 아스키캐릭터로 이진법으로 변환
			}
			else if(!infront){  //소수점 뒤
			decimal = (decimal + (string.charAt(i) & 0x0F))/10;
		}
			}
			currenVal = currenVal + decimal;	//소수점 앞과 뒤 더하기
		while(change) { //음수 처리
			currenVal = 0 - currenVal;
			change = false;
		}
		return currenVal;
}

	public float nextFloat() throws IOException {
		String string = this.next();
		float result = stringToFloat(string);
		return result;
	}
	

	public void close() throws IOException {
	}

}
