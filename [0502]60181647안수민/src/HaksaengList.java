import java.io.File;
import java.io.IOException;

public class HaksaengList {
    public String names[] = new String[10];
    public float scores[] = new float[10];
    public int count = 0;
	public void haksaeng() throws IOException {
	File file; 
	file = new File("Float.txt"); 
	Scanner scanner = new Scanner(file); 

	while(scanner.hasNext()) {
		names[count] = scanner.next();
		scores[count] = scanner.nextFloat();
		count++;
	}
	}
}
