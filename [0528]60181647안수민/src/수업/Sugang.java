package ¼ö¾÷;

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
	
	public void readFromFile() throws FileNotFoundException {	
	
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
		
	public void writeToFile() throws GangjwaNameNotFoundException {
		String ganjwaName = this.gangjwaList.getGangjwaName(this.gangjwaID);

		System.out.println(ganjwaName);
		
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
		
/*		public int getHaksaengID() {return haksaengID;}
		public void setHaksaengID(int haksaengID) {this.haksaengID = haksaengID;}
		public int getScore() {return score;}
		public void setScore(int score) {this.score = score;}*/
		
		public void readFromFile(Scanner scanner) {
			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
		}	
		
		public void writeToFile() throws HaksaengNumberNotExistException{
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);

				System.out.println(haksaengName + " "+ this.kimal);
			
		}
		}
}
