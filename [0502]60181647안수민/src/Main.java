

import java.io.IOException;
// 2018.04.04�� �̾
public class Main {
	
	public static void main(String[] args) throws IOException { 
		//������ ���¸� �����ϴ� �л����� ������ ó��
		Gwamok gwamok = new Gwamok();
		Gangjwa gangjwa = new Gangjwa(gwamok);
		//���´� �������κ��� ����
		//�л��� ���¸� ����
		gangjwa.sincheong();
		gangjwa.computeAverage();
	}
}