

import java.io.IOException;
// 2018.04.04�� �̾
public class Main {
	
	public static void main(String[] args) throws IOException { 
		//������ ���¸� �����ϴ� �л����� ������ ó��
		//0.�л� ���
		GangjwaList gangjwaList = new GangjwaList();
		gangjwaList.readFromFile();
		gangjwaList.writeToFile();	
		//1.���� ����-����, ��� ����, ���ǽ�, �б�, ...
		HaksaengList haksaengList = new HaksaengList();
		haksaengList.readFromFile();
		haksaengList.writeToFile();
		//2.������û-�й�
		Sugang sugang = new Sugang();
		sugang.associate(gangjwaList,haksaengList);
		sugang.readFromFile();
		sugang.writeToFile();
		//3.����ó��-�й�,����
	}
}