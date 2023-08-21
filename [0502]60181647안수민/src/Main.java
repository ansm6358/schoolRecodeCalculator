

import java.io.IOException;
// 2018.04.04에 이어서
public class Main {
	
	public static void main(String[] args) throws IOException { 
		//개설된 강좌를 수강하는 학생들의 성적을 처리
		Gwamok gwamok = new Gwamok();
		Gangjwa gangjwa = new Gangjwa(gwamok);
		//강좌는 과목으로부터 생성
		//학생은 강좌를 수강
		gangjwa.sincheong();
		gangjwa.computeAverage();
	}
}