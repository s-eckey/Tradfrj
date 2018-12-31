package de.eckey.tradfrj.service.lookup;

import java.util.function.Supplier;

public class AuthoritySupplier implements Supplier<String> {

	private String inet4Address;
	private int port;

	public AuthoritySupplier(final String inet4Address, final int port) {
		this.inet4Address = inet4Address;
		this.port = port;
	}

	@Override
	public String get() {
		return inet4Address + ":" + port;
	}
}
