package ErrorException;

public class errorException extends Exception{
 
	private static final long serialVersionUID = 2825025674045985437L;

	
	public errorException()
       {}
	
	public errorException(String message)
	   { super(message); }

		 
	public errorException(Throwable cause)
	   { super(cause); }
	
	 
	
    public errorException(String message, Throwable cause)
		{ super(message, cause); }
	
		 
	
	public errorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
		{ super(message, cause, enableSuppression, writableStackTrace); }
}
