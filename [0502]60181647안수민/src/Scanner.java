

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*1.Hasnext(25) ���� -�ذ�
delimeter (25)
   -delimeter ���� ����(10)
Integer(25)
Float(25)
*/
public class Scanner {
	// instance variables
	private FileReader fileReader;
	private char[] delimeters = {0x0A, 0x0D, 0x20, 'x'}; 
	private int EOF = -1;
	private char minus = 0x2D; //����
	private char dot = 0x2E; //�Ҽ���
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
			if(i==delimeters.length){ //�������� �ƴϸ� ���� ����
			first_word =first_word + (char)input;
			being = true;
			del = false;}
		else if(input == delimeters[i]) { //�������͸� �н�
			being = false;
			del = false;
			}
		else if(!(input == delimeters[i])) {
				i++;
			}	
		}	
		if(input==EOF) { //EOF�� close
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
		if(i==delimeters.length){  //�������� �ƴϸ� word�� ����
				word = hex;	
			del = true;}
		else if(hex == delimeters[i]) { //�������͸� delimeter�� ����
			delemeter = hex;
			int hex2=this.fileReader.read(); //�������� �ƴ� ������ �б�
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
			if(lastChar==delimeters[i]) { //�������� ������ true
				Delimeter = true;
			}
		}
		if(lastChar==EOF) {  //EOF������ true
			Delimeter = true;
		}
		return Delimeter;
	}

	public String next() throws IOException {
		String result = new String();
		int lastChar = skipDelemeter(); //�������͸� �н�
		while(!isDelimeter(lastChar)) { 
			if(being){		//�������� �ƴ� ���ڸ� result�� ����
				result = result + first_word;
					being = false;	}
		result = result + (char)lastChar; //result�� �������� ������ ����
		first_word = ""; 
		lastChar = this.fileReader.read(); //�������� ������ �б�		
	}
		return result;
	}

	private int stringToInt(String string) {
		int currenVal = 0;
		boolean change = false;
		for(int i =0; i<string.length(); i++) {
			if(string.charAt(i)==minus) { //������ ���
				change = true;
				i++;
			}
			else if(string.charAt(i)>=first && string.charAt(i)<=last) //������ ���
			currenVal = currenVal*10 + (string.charAt(i) & 0x0F); //00001111 and ���Ѽ� �ƽ�Űĳ���ͷ� ���������� ��ȯ			
		
			else { //���ڰ� �ƴѰ��
				System.out.print("������ �ƴմϴ�. ���� ���ڸ� �־��ּ���.");
			}

		}
		while(change) {  //������ ��� ó��
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
			if(string.charAt(i)==minus) { //������ ���
				change = true;
			}
			else if(string.charAt(i) ==dot) { //�Ҽ����� �������� ���
				infront = false;
			}
			else if(string.charAt(i)<first && string.charAt(i)>last) { //�Ǽ��� �ʿ��� ���� �ƴ� ���
				System.out.print("�Ǽ��� �ƴմϴ�. ���� ���� �־��ּ���."); 
			}
			else if (infront) { //�Ҽ��� ��
				currenVal = currenVal*10 + (string.charAt(i) & 0x0F); //00001111 and ���Ѽ� �ƽ�Űĳ���ͷ� ���������� ��ȯ
			}
			else if(!infront){  //�Ҽ��� ��
			decimal = (decimal + (string.charAt(i) & 0x0F))/10;
		}
			}
			currenVal = currenVal + decimal;	//�Ҽ��� �հ� �� ���ϱ�
		while(change) { //���� ó��
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
