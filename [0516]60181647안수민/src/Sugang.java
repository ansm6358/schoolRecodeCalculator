

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Sugang {
	private Vector<Score> scoreVector;
	static int n[] = new int[20];
	static int s[] = new int[20];
	
	public Sugang() {
		this.scoreVector = new Vector<Score>();
		
	}
		public int readgangjwa(Scanner scanner) {
		// TODO Auto-generated method stub
		Score score = new Score();
		int gangjwaID = scanner.nextInt();
		return gangjwaID;
				}
	public void readFromFile(Scanner scanner) {		
		int i = 0;

		while (scanner.hasNext()) {
			Score score = new Score();
			int haksaengID = scanner.nextInt();
			score.setHaksaengID(haksaengID);
			n[i] = haksaengID;
			int haksaengScore = scanner.nextInt();
			score.setScore(haksaengScore);
			s[i] = haksaengScore;
			this.scoreVector.add(score);
			i++;
			}	
		}
					
	public int writeGangjwa() {
		for(Score score: this.scoreVector) {
			return score.getGangjwaID();
		}
		return 0;
	}

	private class Score{
		private int haksaengID;
		private int score;
		private int gangjwaID;
		
		public int getHaksaengID() {
			return haksaengID;
		}
		public void setHaksaengID(int haksaengID) {
			this.haksaengID = haksaengID;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getGangjwaID() {
			return gangjwaID;
		}
		public void setGangjwaID(int gangjwaID) {
			this.gangjwaID = gangjwaID;
		}
	}

	public int num(int a) {
		int n1 = n[a];
		return n1;
	}
	public int test(int a) {
		int s1 = s[a];
		return s1;
	}

}
