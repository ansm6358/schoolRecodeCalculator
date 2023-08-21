

import java.io.IOException;
// 2018.04.04에 이어서
public class Main {
	
	public static void main(String[] args) throws IOException { 
		//개설된 강좌를 수강하는 학생들의 성적을 처리
		//0.학생 등록
		HaksaengList haksaengList = new HaksaengList();
		haksaengList.readFromFile();
		haksaengList.writeToFile();
		//1.강좌 개설-과목, 담당 교수, 강의실, 학기, ...
		GangjwaList gangjwaList = new GangjwaList();
		gangjwaList.readFromFile();
		gangjwaList.writeToFile();
		//2.수강신청-학번
		//3.성적처리-학번,성적
	}
}