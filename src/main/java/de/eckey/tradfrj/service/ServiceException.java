package de.eckey.tradfrj.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 3548259613334277399L;

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceException() {
		super();
	}
}
