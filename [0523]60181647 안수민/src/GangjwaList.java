

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
	
	public String getGangjwaName(int gangjwaID) {
		for (Gangjwa gangjwa: this.gangjwaVector) {
			if(gangjwa.getId()==gangjwaID) {
				return gangjwa.getName();
			}
		}	
		return null;
	}

	public void readFromFile() {
	try {
		File file = new File("gangjwa.txt");
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNext()) {
			String Line = scanner.nextLine();
			Scanner read = new Scanner(Line);
			Gangjwa gangjwa = new Gangjwa();
			gangjwa.readFromFile(read);
			this.gangjwaVector.add(gangjwa);
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void writeToFile() {
		for(Gangjwa gangjwa: this.gangjwaVector) {
			gangjwa.writeToFile();
		}
	}
}
