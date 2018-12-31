package de.eckey.tradfrj.service.lookup;

import java.io.IOException;
import java.net.InetAddress;
import java.util.function.Supplier;

import javax.jmdns.JmDNS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLookup {
	private final static Logger log = LoggerFactory.getLogger(ServiceLookup.class);

	public static Supplier<String> lookup(final String macAddress) throws LookupFailedException {
		try {
			final JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			final MacAddressServiceListener listener = new MacAddressServiceListener(macAddress);
			jmdns.addServiceListener("_coap._udp.local.", listener);

			return waitForService(listener);
		} catch (IOException e) {
			throw new LookupFailedException("error occured while service lookup", e);
		}
	}

	private static Supplier<String> waitForService(MacAddressServiceListener listener) throws LookupFailedException {
		try {
			log.debug("looking for service..");
			Thread.sleep(500);
			if (listener.isServicePresent()) {
				log.debug("service resolved");
				return new AuthoritySupplier(listener.getInet4Address(), listener.getPort());
			} else {
				return waitForService(listener);
			}
		} catch (InterruptedException e) {
			throw new LookupFailedException(e);
		}

	}
}
