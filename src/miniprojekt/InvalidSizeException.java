package miniprojekt;

public class InvalidSizeException extends RuntimeException {
	/**
     * Constructs a InvalidSizeException with no detail message.
     */
	public InvalidSizeException() {
		
	} 
	
	/*
     * Constructs a InvalidSizeException with a detail message.
     * @param msg the detail message pertaining to this exception.
     */
	public InvalidSizeException(String msg) {
		super(msg);
	}
	
}
