package exceptions;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = 1L;
	public ValidatorException(){
		
	}
	
 public ValidatorException(String message){
	 super(message);
 }
 
 public ValidatorException(Throwable cause){
	 super(cause);
 }
 
 public ValidatorException(String message, Throwable cause){
	 super(message,cause);
 }
 
 public String getMessage(){
	 return super.getMessage();
 }
 
}
