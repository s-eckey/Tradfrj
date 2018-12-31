package de.eckey.tradfrj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.eckey.tradfrj.request.TradfrjRequestExecutor;
import de.eckey.tradfrj.service.TradfrjService;
import de.eckey.tradfrj.service.lookup.ServiceLookup;
import de.eckey.tradfrj.service.security.SimpleUserPskStore;

public class Tradfrj {
	private final static Logger log = LoggerFactory.getLogger(Tradfrj.class);

	public static void main(String[] args) throws Exception {
		TradfrjService service = new TradfrjService(ServiceLookup.lookup("a0cc2b6f91f5"));
//		final String userCode = service.authenticateUser("ggYuAVCV7WKnAvZg", "tradfrjUser");
//		log.debug("userCode: " + userCode);
		service.setPskStore(new SimpleUserPskStore("tradfrjUser", "WMsVwTAKCISYXQyz"));
		service.start();

		TradfrjRequestExecutor executor = new TradfrjRequestExecutor(service);

		service.stop();
		System.exit(0);
	}

}
