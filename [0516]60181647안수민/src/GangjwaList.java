

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class GangjwaList {
	//components
	private Vector<Gangjwa> gangjwaVector;
	
	public GangjwaList() {
		this.gangjwaVector = new Vector<Gangjwa>();
	}
	
	public void readFromFile() {

	try {
		File file = new File("gangjwa.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Gangjwa gangjwa = new Gangjwa();
			gangjwa.readFromFile(scanner);
			this.gangjwaVector.add(gangjwa);
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Gangjwa gangjwa = new Gangjwa();
		gangjwa.readSugang();			
	}

	public void writeToFile() {
		for(Gangjwa gangjwa: this.gangjwaVector) {
			gangjwa.writeToFile();
		}
	}

	public void sungjuck() {
		Gangjwa gangjwa = new Gangjwa();
		gangjwa.writeSugang();		
	}

}
