package gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import exception.GwamokNameNotFoundException;
import exception.HaksaengNumberNotExistException;
import gwamok.GwamokList;
import haksaeng.HaksaengList;
import valueObject.Seongjeok;

public class Gangjwa {
//attribute	
	private int id;
	private String name;
	private int year;
	private int semester;

	//association attribute
	private int gwamokID;
	private Vector<Score> scoreVector;		//키
	private Vector<Seongjeok> seongjeokList;
	private GwamokList gwamokList;
	private HaksaengList haksaengList;
	Seongjeok seongjeok;

	//constructive	
	public Gangjwa() {
		this.scoreVector = new Vector<Score>();
		 this.seongjeokList = new Vector<Seongjeok>();

	}
	//method
	public void associate(GwamokList gwamokList, HaksaengList haksaengList) {
		this.gwamokList = gwamokList;
		this.haksaengList = haksaengList;

	}	
	
	public void readFromFile(String name) throws FileNotFoundException {	
	
			File file = new File(name);
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
		
	public void printInfo() throws GwamokNameNotFoundException {
		String gwamokName = this.gwamokList.getGwamokName(this.gwamokID);
		System.out.println(gwamokName+ " " +this.name+" "+ this.year+"년 "+this.semester+"학기 ");
		System.out.println("이름   "+"점수  "+"등급");
		for(Score score: this.scoreVector) {
		try{
			score.printInfo();
			}	catch(HaksaengNumberNotExistException e){
				e.printStackTrace();
				}
			}
		
		}



	private class Score{
		private int haksaengID;
		private int kimal;
		private char grade;
		//점수내기
		
		public void readFromFile(Scanner scanner) {
			this.haksaengID = scanner.nextInt();
			this.kimal = scanner.nextInt();
			this.grade = grading(this.kimal);
		}	
		
		private char grading(int kimal) {
			char grade2;
			if(kimal>=85) { 
				grade2='A';
			}else if(kimal>=70) {
				grade2='B';
			}else if(kimal>=50) {
				grade2='C';
			}else if(kimal>=20) {
				grade2='D';
			}else{
				grade2='F';
			}
			return grade2;
		}

		public void printInfo() throws HaksaengNumberNotExistException{
			String haksaengName = haksaengList.getHaksaengName(this.haksaengID);
			System.out.println(haksaengName + " "+ this.kimal+" "+ this.grade);
			}
		}

	public Seongjeok getSeongjeok(int haksaengId) {
		Seongjeok seongjeok = new Seongjeok();
		
		for(Score score: this.scoreVector) {
			if(score.haksaengID==haksaengId) {
				seongjeok.setGangjwaId(id);
				seongjeok.setGwamokName(name);
				seongjeok.setYear(year);
				seongjeok.setSemester(semester);
				seongjeok.setGwamokId(gwamokID);
				seongjeok.setSeongjeok(score.kimal);
				seongjeok.setGrade(score.grade);

				}
		}return seongjeok;

	}
	public void sort() {
		boolean big;
		Score score2;
		Score score1;
		int i = 0;
		for(int ii = 0; ii<this.scoreVector.size(); ii++) {	//사이즈 넘치지 않을 때까지
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
