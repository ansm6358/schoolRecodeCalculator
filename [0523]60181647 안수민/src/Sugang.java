

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Sugang {
//attribute	
	private int gangjwaID; 
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
			String first = scanner.nextLine();
			this.gangjwaID = Integer.parseInt(first);
			
			while (scanner.hasNext()) {
			String Line = scanner.nextLine();
			Scanner read = new Scanner(Line);
			Score score = new Score();
			score.readFromFile(read);
			this.scoreVector.add(score);
			
			}
		scanner.close();
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
	}		
		
	public void writeToFile() throws Exception {
		String ganjwaName = this.gangjwaList.getGangjwaName(this.gangjwaID);
		if(ganjwaName != null){
		System.out.println(ganjwaName);
		
		for(Score score: this.scoreVector){
			score.writeToFile();
			}
		}else {
			throw new GangjwaNameNotFoundException("강좌 번호가 존재하지 않습니다-"+this.gangjwaID);
		}
		}

	private class Score{
		private int haksaengID;
		private int kimal;
		
/*		public int getHaksaengID() {return haksaengID;}
		public void setHaksaengID(int haksaengID) {this.haksaengID = haksaengID;}
		public int getScore() {return score;}
		public void setScore(int score) {this.score = score;}*/
		
		public void readFromFile(Scanner read) {
			this.haksaengID = read.nextInt();
			this.kimal = read.nextInt();
		}	
		public void writeToFile(){
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			if(haksaengName != null){
		 System.out.println(haksaengName + " "+ this.kimal);
			}else {
				System.out.println("학생 번호가 존재하지 않습니다-"+ this.haksaengID);
				}
}
}
}
