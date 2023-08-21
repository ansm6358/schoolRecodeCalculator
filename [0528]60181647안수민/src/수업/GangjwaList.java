package 수업;

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
	
	public String getGangjwaName(int gangjwaID) throws GangjwaNameNotFoundException {
		for (Gangjwa gangjwa: this.gangjwaVector) {
			if(gangjwa.getId()==gangjwaID) {
				return gangjwa.getName();
			}
		}	
		throw new GangjwaNameNotFoundException("강좌번호가 존재하지 않습니다."+gangjwaID);
	}

	public void readFromFile() throws FileNotFoundException {
		File file = new File("gangjwa.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Gangjwa gangjwa = new Gangjwa();
			gangjwa.readFromFile(scanner);
			this.gangjwaVector.add(gangjwa);
		}
		scanner.close();
		
	}

	public void writeToFile() {
		for(Gangjwa gangjwa: this.gangjwaVector) {
			gangjwa.writeToFile();
		}
	}
}
