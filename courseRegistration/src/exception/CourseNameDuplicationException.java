package exception;

public class CourseNameDuplicationException extends Exception {
	public CourseNameDuplicationException() {}
	public CourseNameDuplicationException(String msg) {
		super(msg);
	}

}
