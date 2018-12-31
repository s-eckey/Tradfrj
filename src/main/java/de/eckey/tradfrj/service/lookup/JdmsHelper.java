package de.eckey.tradfrj.service.lookup;

import javax.jmdns.ServiceEvent;

import org.apache.commons.lang3.StringUtils;

class JdmsHelper {

	public static String getMacAddress(ServiceEvent event) {
		if (event == null) {
			return StringUtils.EMPTY;
		}
		if (StringUtils.isBlank(event.getName())) {
			return StringUtils.EMPTY;
		}
		if (!event.getName().startsWith("gw-")) {
			return StringUtils.EMPTY;
		}
		return event.getName().substring(3);
	}
}
