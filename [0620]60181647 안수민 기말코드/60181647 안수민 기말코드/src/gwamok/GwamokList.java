package gwamok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import exception.GwamokNameNotFoundException;

public class GwamokList {
	//components
	private Vector<Gwamok> gwamokVector;  
	
	public GwamokList() {
		this.gwamokVector = new Vector<Gwamok>();
	}
	
	public String getGwamokName(int gwamokID) throws GwamokNameNotFoundException {
		for (Gwamok gwamok: this.gwamokVector) {
			if(gwamok.getId()==gwamokID) { 
				return gwamok.getName();
			}
		}	
		throw new GwamokNameNotFoundException(gwamokID);
	}

	public void readFromFile() throws FileNotFoundException {
		File file = new File("data/gwamok.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Gwamok gwamok = new Gwamok();
			gwamok.readFromFile(scanner);
			this.gwamokVector.add(gwamok);
		}
		scanner.close();		
	}


	public void printInfo() {
		for(Gwamok gwamok: this.gwamokVector) {
			gwamok.printInfo();
		}
	}
}
