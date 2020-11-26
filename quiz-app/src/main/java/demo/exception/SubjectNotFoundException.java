package demo.exception;

public class SubjectNotFoundException extends RuntimeException{
	public SubjectNotFoundException() {
		super("Subject Not Found Exception");
	}
}
