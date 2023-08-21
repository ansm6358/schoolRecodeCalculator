package 수업;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Gangjwa {
//attribute	
	private int id;
	private String name;
	private int year;
	private int semester;

	//association attribute
	private int gwamokID;
	private Vector<Score> scoreVector;		//키
	
	GwamokList gangjwaList;
	HaksaengList haksaengList; 					//애네는 끄집에 낼 것
	
	//constructive	
	public Gangjwa() {
		this.scoreVector = new Vector<Score>();
	}
	//method
	public void associate(GwamokList gangjwaList, HaksaengList haksaengList) {
		this.gangjwaList = gangjwaList;
		this.haksaengList = haksaengList;
	}	
	
	public void readFromFile() throws FileNotFoundException {	
	
			File file = new File("gangjwa.txt");
			Scanner scanner = new Scanner(file);
			
			this.id = scanner.nextInt();
			this.name = scanner.next();
			this.year = scanner.nextInt();
			this.semester = scanner.nextInt();
			
			this.gwamokID = scanner.nextInt();
			
			while (scanner.hasNext()) {
			Score score = new Score();
			score.readFromFile(scanner);
			this.scoreVector.add(score);
			
			}
		scanner.close();
		
	}		
		
	public void writeToFile() throws GwamokNameNotFoundException {
		String gwamokName = this.gangjwaList.getGwamokName(this.gwamokID);
 
		System.out.println(gwamokName+ " " +this.name+" "+ this.year+" "+this.semester);
		for(Score score: this.scoreVector) {
		try{
			score.writeToFile();
			}	catch(HaksaengNumberNotExistException e){
				e.printStackTrace();
				}
			}
		
		}

	private class Score{
		private int haksaengID;
		private int kimal;

		
		public void readFromFile(Scanner scanner) {
			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
		}	
		
		public void writeToFile() throws HaksaengNumberNotExistException{
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			System.out.println(haksaengName + " "+ this.kimal);
			}
		}

	public void sort() {
		boolean big;
		Score score1;
		Score score2;
		int ii = 0;
		for(int i = 0; i<this.scoreVector.size()-1; i++) {	//사이즈 넘치지 않을 때까지
			big=true;
		ii = i +1;
		score1 = scoreVector.get(i);
		
		while(big) {
			score2 = scoreVector.get(ii);		

		if(score1.kimal>=score2.kimal) {
			big=false;
		}
		else if(score1.kimal<score2.kimal) {
			scoreVector.add(i, score2);	
			scoreVector.remove(ii+1);
			
			ii++;
			
			if(ii>=this.scoreVector.size()) {
				
				big=false;	
			}
		}
		}
		sort2(i);
		}		
	}
	private void sort2(int i) {
	boolean a=true;
	Score a2;
	Score a1;
		int b2=i;
		int b1 = i -1;
		
	if(b1<0) {
		a=false;
	} 
	while(a) {
		a1 = scoreVector.get(b1);
		a2 = scoreVector.get(b2);
		if(a1.kimal>=a2.kimal) {
			a=false; 
		}
		else if(a1.kimal<a2.kimal) {
			scoreVector.add(b1, a2);	
			scoreVector.remove(b2+1);
			b1--;
			b2--;
			
			if(b1<0) {
				a=false;
			}
		}
	}
	}
}
