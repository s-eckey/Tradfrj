package de.eckey.tradfrj.service.lookup;

public class LookupFailedException extends Exception {
	private static final long serialVersionUID = -3801041718442740942L;

	public LookupFailedException(Throwable e) {
		super(e);
	}

	public LookupFailedException(String message) {
		super(message);
	}

	public LookupFailedException(String message, Throwable e) {
		super(message, e);
	}

	public LookupFailedException() {
		super();
	}

}
