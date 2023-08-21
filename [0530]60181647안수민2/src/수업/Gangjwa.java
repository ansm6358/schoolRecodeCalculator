package ����;

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
	private Vector<Score> scoreVector;		//Ű
	
	GwamokList gangjwaList;
	HaksaengList haksaengList; 					//�ֳ״� ������ �� ��
	
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
		Score score2;
		Score score1;
		int i = 0;
		for(int ii = 0; ii<this.scoreVector.size(); ii++) {	//������ ��ġ�� ���� ������
			big=true;
			i = ii-1;
			if(i<0) {
				big=false;
			} 
			while(big) {
				score1 = scoreVector.get(i);
				score2 = scoreVector.get(ii);
				if(score1.kimal>=score2.kimal) {
					big=false; 
				}
				else if(score1.kimal<score2.kimal) {
					scoreVector.add(i, score2);	
					scoreVector.remove(ii+1);
					i--;
					ii--;
					
					if(i<0) {
						big=false;
					}
				}
			}

		}		
	}

}
