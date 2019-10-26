package fr.ubordeaux.ao.domain;

public class ReferenceManagementException extends Exception {

	private static final long serialVersionUID = 1L;
	private String value;

	public ReferenceManagementException(String value, String message) {
		super(message);
		this.value = value;
	}

	public String getMessage() {
		return super.getMessage() + ':' + value;
		
	}
}
