import java.io.IOException;

public class Gangjwa {
	HaksaengList haksaengList = new HaksaengList();
	public Gangjwa(Gwamok gwamok) {
	}
	public void sincheong() {		
	}
	public void computeAverage() throws IOException {
	haksaengList.haksaeng();
	char grades[] = new char[10];
	float sum = 0;
	float avg = 0;
	
	for(int i=0; i<haksaengList.count; i++ ) {
		if(haksaengList.scores[i]>90) {
			grades[i]='A';
		}else if(haksaengList.scores[i]>80) {
			grades[i]='B';
		}else if(haksaengList.scores[i]>70) {
			grades[i]='C';
		}else if(haksaengList.scores[i]>60) {
			grades[i]='D';
		}else{
			grades[i]='F';
		}
		sum = haksaengList.scores[i]+sum;
	}
	avg = sum/haksaengList.count;
	for(int i=0; i<haksaengList.count;i++) {//count°¹¼ö¸¸Å­ µ¼
		System.out.print(haksaengList.names[i]);
		System.out.print(haksaengList.scores[i]);//Carriage Return + Line Feed = ln = "\n"
		System.out.println(grades[i]);
	}
		System.out.println("ÃÑÇÕ:" +sum );
		System.out.println("Æò±Õ:" +avg);
	}

}
