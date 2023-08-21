

import java.util.Scanner;

public class Haksaeng {
	
	private int id;
	private String name;
	static int id2[] = new int[20];
	static String name2[] = new String[20];
	static int H = 0;
	
	public void readFromFile(Scanner scanner) {
		 this.id = scanner.nextInt();
		 this.name = scanner.next();		
	}

	public void writeToFile() {
		System.out.println(this.id+ " "+this.name);
		id2[H]=id;
		name2[H]=name;
		H++;
	}

	public int ReadH(int a) {
		if(a==H) {
			int end = -1;
			return end;
		}
		else {
	System.out.print("\n"+this.id2[a]);
	int id3=id2[a];
	return id3;
		}		
	}

	public String ReadN(int a) {
		System.out.print(" "+this.name2[a]);
		String name3=name2[a];
		return name3;
	}
}
