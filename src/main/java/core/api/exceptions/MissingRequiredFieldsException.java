package core.api.exceptions;

public class MissingRequiredFieldsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3541340534318379322L;

    public MissingRequiredFieldsException(String message) {
        super(message);
    }
}
