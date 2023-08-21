

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class HaksaengList {
	//components
	private Vector<Haksaeng> haksaengVector;
	
	public HaksaengList() {
		this.haksaengVector = new Vector<Haksaeng>();
	}
	
	public void readFromFile() {

	try {
		File file = new File("haksaeng.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String Line = scanner.nextLine();
			Scanner read = new Scanner(Line);
			Haksaeng haksaeng = new Haksaeng();
			haksaeng.readFromFile(read);
			this.haksaengVector.add(haksaeng);
		}
		scanner.close();
	} catch (FileNotFoundException e) { //오류 원인
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void writeToFile() {
		for(Haksaeng haksaeng: this.haksaengVector) {
			haksaeng.writeToFile();
		}
	}

	public String getHaksaengName(int haksaengID) {
		for (Haksaeng haksaeng: this.haksaengVector) {
			if(haksaeng.getId()==haksaengID) {
				return haksaeng.getName();
			}
		}	
		return null;
	}

}
