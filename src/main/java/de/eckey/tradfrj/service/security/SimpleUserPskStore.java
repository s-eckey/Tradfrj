package de.eckey.tradfrj.service.security;

import java.net.InetSocketAddress;

import org.eclipse.californium.scandium.dtls.pskstore.PskStore;
import org.eclipse.californium.scandium.util.ServerNames;

public class SimpleUserPskStore implements PskStore {
	private final String username;
	private final String usercode;

	public SimpleUserPskStore(final String userName, final String userCode) {
		this.username = userName;
		this.usercode = userCode;
	}

	@Override
	public byte[] getKey(String identity) {
		return usercode.getBytes();
	}

	@Override
	public byte[] getKey(ServerNames serverName, String identity) {
		return usercode.getBytes();
	}

	@Override
	public String getIdentity(InetSocketAddress inetAddress) {
		return username;
	}

	@Override
	public String getIdentity(InetSocketAddress peerAddress, ServerNames virtualHost) {
		return username;
	}
}
