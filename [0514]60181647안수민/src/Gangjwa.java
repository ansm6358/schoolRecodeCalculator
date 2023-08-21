

import java.util.Scanner;

public class Gangjwa {
	
	private int id;
	private String name;
	
	public void readFromFile(Scanner scanner) {
		 this.id = scanner.nextInt();
		 this.name = scanner.next();		
	}

	public void writeToFile() {
		System.out.println(this.id+ " "+this.name);
		
	}
}