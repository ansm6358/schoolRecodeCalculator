

import java.io.IOException;
// 2018.04.04�� �̾
public class Main {
	
	public static void main(String[] args) throws IOException { 
		//������ ���¸� �����ϴ� �л����� ������ ó��
		//0.�л� ���
		HaksaengList haksaengList = new HaksaengList();
		haksaengList.readFromFile();
		haksaengList.writeToFile();
		//1.���� ����-����, ��� ����, ���ǽ�, �б�, ...
		GangjwaList gangjwaList = new GangjwaList();
		gangjwaList.readFromFile();
		gangjwaList.writeToFile();
		//2.������û-�й�
		//3.����ó��-�й�,����
	}
}