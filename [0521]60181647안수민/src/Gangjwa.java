

import java.util.Scanner;
import java.util.Vector;

public class Gangjwa {
	
	private int id;
	private String name;
	

	public int getId() {return id;}

	//public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	//public void setName(String name) {this.name = name;}

	public void readFromFile(Scanner scanner) {
		 this.id = scanner.nextInt();
		 this.name = scanner.next();		
	}

	public void writeToFile() {
		System.out.println(this.id+ " "+this.name);
		
	}
}	
