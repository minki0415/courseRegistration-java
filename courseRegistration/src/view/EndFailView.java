package view;

//���񽺷��� ���� �� �޽��� ����ϴ� ���
public class EndFailView {
	
	public static void failView(String message) {
		if(message != null) {
			System.out.println(message);
		}else {
			System.out.println("**** �߻��� ���� ****");			
		}
	}

}
