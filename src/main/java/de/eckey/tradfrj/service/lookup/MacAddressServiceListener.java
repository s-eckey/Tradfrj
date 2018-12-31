package de.eckey.tradfrj.service.lookup;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MacAddressServiceListener implements ServiceListener {
	private final transient Logger log = LoggerFactory.getLogger(this.getClass());

	private final String macAddress;
	private boolean servicePresent = false;
	private String inet4Address;
	private int port;

	public MacAddressServiceListener(final String macAddress) {
		this.macAddress = macAddress;
		log.info("looking for service with MAC address '" + macAddress + "'");
	}

	@Override
	public void serviceAdded(ServiceEvent event) {
		// nothing to do
	}

	@Override
	public void serviceRemoved(ServiceEvent event) {
		// nothing to do
	}

	@Override
	public void serviceResolved(ServiceEvent event) {
		if (!servicePresent && StringUtils.equals(macAddress, JdmsHelper.getMacAddress(event))) {
			if (event.getInfo().getInet4Addresses().length > 1) {
				log.warn("more then one Inet4Adddress found. Unsing the first one..");
			}
			inet4Address = event.getInfo().getInet4Addresses()[0].getHostAddress();
			port = event.getInfo().getPort();
			servicePresent = true;
			StringBuilder stringBuilder = new StringBuilder()//
					.append("service found with MAC address '")//
					.append(macAddress)//
					.append("' - Inet4Address: '")//
					.append(inet4Address)//
					.append(":")//
					.append(port)//
					.append("'")//
			;
			log.info(stringBuilder.toString());
		}
	}

	public boolean isServicePresent() {
		return servicePresent;
	}

	public String getInet4Address() {
		return inet4Address;
	}

	public int getPort() {
		return port;
	}

}
