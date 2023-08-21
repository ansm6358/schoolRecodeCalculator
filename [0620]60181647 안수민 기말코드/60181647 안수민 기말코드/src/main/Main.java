package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import gangjwa.GangjwaList;
import gwamok.GwamokList;
import haksaeng.HaksaengList;
// 2018.04.04에 이어서
public class Main {
	
	public static void main(String[] args){ 
		try {

		GwamokList gwamokList = new GwamokList();
		gwamokList.readFromFile();
		
		GangjwaList gangjwaList = new GangjwaList();
		gangjwaList.readFromFile();
				
		HaksaengList haksaengList = new HaksaengList();
		haksaengList.readFromFile(gangjwaList);
		

		//1.print gwamok info
		gwamokList.printInfo();
		
		//2.print gangjwa info: descending order
		gangjwaList.asscoiate(gwamokList, haksaengList);
		gangjwaList.printInfo();
		
		//3. print haksaeng info: ascending order
		haksaengList.asscoiate(gangjwaList, gwamokList);
		haksaengList.printInfo(gwamokList); //강좌 알아야한다

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}