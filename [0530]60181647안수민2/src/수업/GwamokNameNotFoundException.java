package ����;

public class GwamokNameNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public GwamokNameNotFoundException(int gwamokID) {
		super("���¹�ȣ�� �������� �ʽ��ϴ�."+gwamokID);
		//extends�� exception�� �������� ��
		//���۴� �θ� �ؾ��� ���� �ض�
	}


}
