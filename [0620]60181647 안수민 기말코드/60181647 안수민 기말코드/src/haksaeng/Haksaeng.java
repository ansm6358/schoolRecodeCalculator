package haksaeng;

import java.util.Scanner;
import java.util.Vector;

import exception.GwamokNameNotFoundException;
import gangjwa.GangjwaList;
import gwamok.GwamokList;
import valueObject.Seongjeok;

public class Haksaeng {
	
	private int id;
	private String name;
	private Vector<Seongjeok> seongjeokList;
	private GangjwaList gangjwaList;
	private GwamokList gwamokList;
	private Seongjeok seongjeok;
	
	//private Vector<Seongjeok> seongjeokList; 
	
	public int getId() {return id;}

	//public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	//public void setName(String name) {this.name = name;}
 
	public void readFromFile(Scanner scanner, GangjwaList gangjwaList2) {
		this.gangjwaList = gangjwaList2;
		this.id = scanner.nextInt();
		 this.name = scanner.next();
		 
		seongjeokList = this.gangjwaList.getSeongjeok(this.id);
		//�ٷ� sorting ����
	}

	public void printInfo(GwamokList gwamokList2) {
		this.gwamokList = gwamokList2;
		System.out.println(this.name);
		for(int i=0; i<this.seongjeokList.size(); i++ ) {
			 try {
				String gangjwaName = this.gwamokList.getGwamokName(this.seongjeokList.get(i).getGwamokId());
		
			System.out.println(gangjwaName+" "+this.seongjeokList.get(i).getGwamokName()+" "+
					this.seongjeokList.get(i).getYear()+"�� "+this.seongjeokList.get(i).getSemester()+"�б�");
			System.out.println("����: "+ this.seongjeokList.get(i).getSeongjeok() +" ���: "+ this.seongjeokList.get(i).getGrade());
			} catch (GwamokNameNotFoundException e) {
				e.printStackTrace();
			}			}
	}

	public void associate(GangjwaList gangjwaList, Seongjeok seongjeok, GwamokList gwamokList) {
		this.gangjwaList = gangjwaList;
		this.seongjeok = seongjeok;
		
	}

	public void sort() {
		boolean big;
		Seongjeok seongjeok2;
		Seongjeok seongjeok1;
		int i = 0;
		for(int ii = 0; ii<this.seongjeokList.size(); ii++) {	//������ ��ġ�� ���� ������
			big=true;
			i = ii-1;
			if(i<0) {
				big=false;
			} 
			while(big) {
				seongjeok1 = seongjeokList.get(i);
				seongjeok2 = seongjeokList.get(ii);
				if(seongjeok1.getSeongjeok()<=seongjeok2.getSeongjeok()) {
					big=false; 
				}
				
				else if(seongjeok1.getSeongjeok()>seongjeok2.getSeongjeok()) {
					seongjeokList.add(i, seongjeok2);	
					seongjeokList.remove(ii+1);
					i--;
					ii--;
					
					if(i<0) {
						big=false;
					}
				}
			}

		}		
	}
		
		
	}

