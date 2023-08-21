package haksaeng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import exception.HaksaengNumberNotExistException;
import gangjwa.GangjwaList;
import gwamok.GwamokList;
import valueObject.Seongjeok;

public class HaksaengList {
	//components
	private Vector<Haksaeng> haksaengVector;
	
	//associations
	private GangjwaList gangjwaList;
	private GwamokList gwamokList;
	
	Seongjeok seongjeok;
	
	public HaksaengList() {
		this.haksaengVector = new Vector<Haksaeng>();
	}
	
	public void readFromFile(GangjwaList gangjwaList2) throws FileNotFoundException {

		File file = new File("data/haksaeng.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Haksaeng haksaeng = new Haksaeng();
			haksaeng.associate(this.gangjwaList, this.seongjeok, this.gwamokList);
			haksaeng.readFromFile(scanner,gangjwaList2 );
			this.haksaengVector.add(haksaeng);
		}
		scanner.close();
	
	}

	public String getHaksaengName(int haksaengID) throws HaksaengNumberNotExistException {
		for (Haksaeng haksaeng: this.haksaengVector) {
			if(haksaeng.getId()==haksaengID) {
				return haksaeng.getName();
			}
		}	
		throw new HaksaengNumberNotExistException(haksaengID);
	}
	
	public void asscoiate(GangjwaList gangjwaList, GwamokList gwamokList) {
		this.gangjwaList = gangjwaList;
		this.gwamokList = gwamokList;
	}
	
	public void printInfo(GwamokList gwamokList2) {
		System.out.println("==== Haksaeng Information====");
		for(Haksaeng haksaeng: this.haksaengVector) {
			haksaeng.associate(this.gangjwaList, this.seongjeok, this.gwamokList);
			haksaeng.sort();
			haksaeng.printInfo(gwamokList2);
		}
	}


}
