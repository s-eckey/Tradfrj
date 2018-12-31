package de.eckey.tradfrj.service.security;

import java.net.InetSocketAddress;

import org.eclipse.californium.scandium.dtls.pskstore.PskStore;
import org.eclipse.californium.scandium.util.ServerNames;

public class HandshakePskStore implements PskStore {

	private String securityCode;

	public HandshakePskStore(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public byte[] getKey(String identity) {
		return securityCode.getBytes();
	}

	@Override
	public byte[] getKey(ServerNames serverName, String identity) {
		return securityCode.getBytes();
	}

	@Override
	public String getIdentity(InetSocketAddress inetAddress) {
		return "Client_identity";
	}

	@Override
	public String getIdentity(InetSocketAddress peerAddress, ServerNames virtualHost) {
		return "Client_identity";
	}

}
