package gangjwa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import exception.GwamokNameNotFoundException;
import gwamok.GwamokList;
import haksaeng.HaksaengList;
import valueObject.Seongjeok;

public class GangjwaList {
	//components
		private Vector<Gangjwa> gangjwaVector;
		//associations
		private GwamokList gwamokList;
		private HaksaengList haksaengList;
		
		public GangjwaList() {
			this.gangjwaVector = new Vector<Gangjwa>();
		}

		public void readFromFile() throws FileNotFoundException {

			File file = new File("data/gangjwaList.txt");
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String name = scanner.next();
				Gangjwa gangjwa = new Gangjwa(); //�����ڸ��� association
				gangjwa.associate(this.gwamokList, this.haksaengList);
				gangjwa.readFromFile(name);
				this.gangjwaVector.add(gangjwa);
			}
			scanner.close();
	}
//�л� ����Ʈ ���� ����Ʈ �˾ƿ�����


		public void asscoiate(GwamokList gwamokList, HaksaengList haksaengList) {
			this.gwamokList = gwamokList;
			this.haksaengList = haksaengList;
		}
		
		public  Vector<Seongjeok> getSeongjeok(int haksaengId) {
			Vector<Seongjeok> seongjeokList = new Vector<Seongjeok>();
			for(Gangjwa gangjwa: this.gangjwaVector) {
				gangjwa.associate(this.gwamokList, this.haksaengList);
				Seongjeok seongjeok = gangjwa.getSeongjeok(haksaengId);
				if(seongjeok != null) {
					seongjeokList.add(seongjeok);					
				}
			}
			return seongjeokList;
	
		}
		
		public void printInfo() {
			System.out.println("==== Gangjwa Information====");
			
			for(Gangjwa gangjwa: this.gangjwaVector) {
				try {
					gangjwa.associate(this.gwamokList, this.haksaengList);
					gangjwa.sort();
					gangjwa.printInfo();
				} catch (GwamokNameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


}
