package ����;

import java.io.FileNotFoundException;
import java.io.IOException;
// 2018.04.04�� �̾
public class Main {
	
	public static void main(String[] args){ 
		try {
		//������ ���¸� �����ϴ� �л����� ������ ó��
		//0.�л� ���
		GwamokList gwamokList = new GwamokList();
		gwamokList.readFromFile();
		gwamokList.writeToFile();	
		//1.���� ����-����, ��� ����, ���ǽ�, �б�, ...
		HaksaengList haksaengList = new HaksaengList();
		haksaengList.readFromFile();
		haksaengList.writeToFile();
		//2.������û-�й�
		Gangjwa sugang = new Gangjwa();
		sugang.associate(gwamokList,haksaengList);
		sugang.readFromFile();
		sugang.sort();
		sugang.writeToFile();
	
		//3.����ó��-�й�,����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (GwamokNameNotFoundException e) {
			e.printStackTrace();
		}
	}
}