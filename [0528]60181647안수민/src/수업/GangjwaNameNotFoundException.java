package 수업;

public class GangjwaNameNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public GangjwaNameNotFoundException(String string) {
		super(string);
		//extends는 exception을 가져오는 것
		//슈퍼는 부모가 해야할 일을 해라
	}


}
