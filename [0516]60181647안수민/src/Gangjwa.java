

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Gangjwa {
	
	private int id;
	private String name;
	private Sugang sugang;
	private HaksaengList haksaengList;
	static String name2;
	static int id2;
	static int score;
	static int id3;
	
	public Gangjwa() {

		this.haksaengList = new HaksaengList();
	}
	public void readFromFile(Scanner scanner) {
		 this.id = scanner.nextInt();
		 this.name = scanner.next();	  
	}

	
	public void readSugang() {		

		try {
		File file = new File("sugang1.txt");	
		Scanner scanner = new Scanner(file);
		this.sugang = new Sugang();
		id2=this.sugang.readgangjwa(scanner);
		this.sugang.readFromFile(scanner);
		scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToFile() {

		System.out.println(this.id+ " "+this.name);
		if(id2==id) {
			name2 = name;}
	}	
	
	public void writeSugang() {
		this.sugang = new Sugang();
		int a=0;
		boolean lastword = false;
		//1.수강 첫줄 읽어와 대입
		System.out.print(id2+" "+name2);
		while(!lastword){
		id3=this.sugang.num(a);
		score=this.sugang.test(a);
		id2=this.haksaengList.readhaksaeng(a);
		if(id2==-1) {
			lastword = true;
		}

		else if(id2==id3) {
			name2=this.haksaengList.readname(a);
		System.out.print(" "+score);
		}
		
		else {
		name2=this.haksaengList.readname(a);		
		}
		a++;

		}
	//2.학생 읽어와서 점수 대입
		}
		//학생 코드
	//학생 읽기
	//점수 조회		
}