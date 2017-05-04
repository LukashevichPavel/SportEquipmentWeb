package by.htp.equipment.service;

public class ServiceNoSuchUserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1628538063980489111L;

	public ServiceNoSuchUserException() {
		super();
	}

	public ServiceNoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceNoSuchUserException(String message) {
		super(message);
	}

	public ServiceNoSuchUserException(Throwable cause) {
		super(cause);
	}
}