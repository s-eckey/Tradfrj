package de.eckey.tradfrj.service;

import java.io.IOException;
import java.util.function.Supplier;

import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.CoapEndpoint.CoapEndpointBuilder;
import org.eclipse.californium.scandium.DTLSConnector;
import org.eclipse.californium.scandium.config.DtlsConnectorConfig;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.eclipse.californium.scandium.dtls.pskstore.PskStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.eckey.tradfrj.service.security.HandshakePskStore;

public class TradfrjService {

	private final transient Logger log = LoggerFactory.getLogger(getClass());

	private CoapEndpoint dtlsEndpoint;
	private DTLSConnector dtlsConnector;
	private boolean running = false;
	private Supplier<String> authoritySupplier;
	private PskStore pskStore;

	public TradfrjService(Supplier<String> authoritySupplier) {
		this.authoritySupplier = authoritySupplier;
	}

	public void start() throws ServiceException {
		if (running) {
			throw new ServiceException("Service is already running");
		} else {
			try {
				DtlsConnectorConfig.Builder builder = new DtlsConnectorConfig.Builder()//
						.setPskStore(pskStore)//
						.setSupportedCipherSuites(new CipherSuite[] { CipherSuite.TLS_PSK_WITH_AES_128_CCM_8 })//
				;
				dtlsConnector = new DTLSConnector(builder.build());
				dtlsEndpoint = new CoapEndpointBuilder().setConnector(dtlsConnector).build();
				dtlsConnector.start();
				dtlsEndpoint.start();
				running = true;
				log.info("Service is running");
			} catch (IOException e) {
				throw new ServiceException(e);
			}
		}
	}

	public String authenticateUser(final String securityCode, final String userName) throws ServiceException {
		setPskStore(new HandshakePskStore(securityCode));
		start();
		final CoapResponse coapResponse = sendRequest(
				new CoapRequest("15011/9063", Code.POST, "{\"9090\":\"" + userName + "\"}"));
		log.debug(coapResponse.toString());
		final JsonObject jsonObject = new JsonParser().parse(coapResponse.getPayload()).getAsJsonObject();
		final String userCode = jsonObject.get("9091").getAsString();
		stop();
		setPskStore(null);
		return userCode;
	}

	public void setPskStore(PskStore pskStore) {
		this.pskStore = pskStore;
	}

	public void stop() throws ServiceException {
		if (running) {
			dtlsConnector.stop();
			dtlsEndpoint.stop();
			running = false;
			log.info("Service is stopped");
		} else {
			throw new ServiceException("Service is not running");
		}
	}

	public CoapResponse sendRequest(CoapRequest coapRequest) throws ServiceException {
		try {
			final Request request = new Request(coapRequest.getCode());
			request.setURI("coaps://" + authoritySupplier.get() + "/" + coapRequest.getPath());
			if ((request.getCode() == Code.POST || request.getCode() == Code.PUT)) {
				request.setPayload(coapRequest.getPayload());
				request.getOptions().setContentFormat(MediaTypeRegistry.APPLICATION_JSON);
			}
			log.debug(request.toString());
			dtlsEndpoint.sendRequest(request);
			final Response response = request.waitForResponse();
			log.debug(response.getPayloadString());
			if (ResponseCode.isSuccess(response.getCode())) {
				return CoapResponse.from(response);
			} else {
				throw new ServiceException("request was not successfull. response: '" + response + "'");
			}
		} catch (Exception e) {
			throw new ServiceException("exception while using the coap service", e);
		}
	}
}
