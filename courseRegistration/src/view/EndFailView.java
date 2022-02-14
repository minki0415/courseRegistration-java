package view;

//서비스로직 실패 시 메시지 출력하는 기능
public class EndFailView {
	
	public static void failView(String message) {
		if(message != null) {
			System.out.println(message);
		}else {
			System.out.println("**** 발생된 문제 ****");			
		}
	}

}
