

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Sugang {
//attribute	
	int gangjwaID; 
	private Vector<Score> scoreVector;
	//constructive
	GangjwaList gangjwaList;
	HaksaengList haksaengList;
	//association
	public Sugang() {
		this.scoreVector = new Vector<Score>();
	}
	//method
	public void associate(GangjwaList gangjwaList, HaksaengList haksaengList) {
		this.gangjwaList = gangjwaList;
		this.haksaengList = haksaengList;
	}	
	
	public void readFromFile() {	
		
		try {
			File file = new File("sugang1.txt");
			Scanner scanner = new Scanner(file);
			this.gangjwaID = scanner.nextInt();
			
			while (scanner.hasNext()) {
			Score score = new Score();
			score.readFromFile(scanner);
			this.scoreVector.add(score);
			
			}
		scanner.close();
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
	}		
		
	public void writeToFile() {
		String ganjwaName = this.gangjwaList.getGangjwaName(this.gangjwaID);
		if(!(ganjwaName==null)) {
		System.out.println(ganjwaName);
		
		for(Score score: this.scoreVector){
			score.writeToFile();
				}
			}
		else {
			System.out.print("강좌가 없습니다.");
		}
		}

	private class Score{
		private int haksaengID;
		private int score;
		
/*		public int getHaksaengID() {return haksaengID;}
		public void setHaksaengID(int haksaengID) {this.haksaengID = haksaengID;}
		public int getScore() {return score;}
		public void setScore(int score) {this.score = score;}*/
		
		public void readFromFile(Scanner scanner) {
			this.haksaengID = scanner.nextInt();
			this.score = scanner.nextInt();
		}	
		public void writeToFile(){
		String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
		if(!(haksaengName==null)) {
		System.out.println(haksaengName + " "+ this.score);
		}
		else {
			System.out.print("학생이 존재하지 않습니다.");
		}
	}
}
}
