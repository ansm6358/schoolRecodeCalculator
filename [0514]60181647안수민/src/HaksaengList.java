

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
			Haksaeng haksaeng = new Haksaeng();
			haksaeng.readFromFile(scanner);
			this.haksaengVector.add(haksaeng);
		}
		scanner.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void writeToFile() {
		for(Haksaeng haksaeng: this.haksaengVector) {
			haksaeng.writeToFile();
		}
	}

}
