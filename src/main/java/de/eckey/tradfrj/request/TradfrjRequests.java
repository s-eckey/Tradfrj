package de.eckey.tradfrj.request;

import java.util.Collection;
import java.util.Optional;

import de.eckey.tradfrj.item.device.Device;
import de.eckey.tradfrj.item.device.light.Light;
import de.eckey.tradfrj.item.group.Group;
import de.eckey.tradfrj.request.item.device.LookupDevice;
import de.eckey.tradfrj.request.item.device.LookupDeviceIDs;
import de.eckey.tradfrj.request.item.device.LookupDevices;
import de.eckey.tradfrj.request.item.device.lamp.LookupLight;
import de.eckey.tradfrj.request.item.device.lamp.LookupLights;
import de.eckey.tradfrj.request.item.device.lamp.ModifyLightRequestBuilder;
import de.eckey.tradfrj.request.item.group.LookupGroupIDs;
import de.eckey.tradfrj.request.item.group.LookupGroups;

public class TradfrjRequests {

	private TradfrjRequests() {
	}

	/**
	 * @return the {@link TradfrjRequest} to get all known Group IDs
	 */
	public static TradfrjRequest<Collection<Double>> loogupGroupIDs() {
		return new LookupGroupIDs();
	}

	/**
	 * @return the {@link TradfrjRequest} to get all known Device IDs
	 */
	public static TradfrjRequest<Collection<Double>> lookupDeviceIDs() {
		return new LookupDeviceIDs();
	}

	public static TradfrjRequestIterator<Group> lookupGroups(Collection<Double> ids) {
		return new LookupGroups(ids);
	}

	public static TradfrjRequestIterator<Device> lookupDevices(Collection<Double> ids) {
		return new LookupDevices(ids);
	}

	public static TradfrjRequestIterator<Light> lookupLights(Collection<Double> ids) {
		return new LookupLights(ids);
	}

	/**
	 * @param id of the seeked lamp
	 * @return the {@link TradfrjRequest} to get the seeked lamp
	 */
	public static TradfrjRequest<Optional<Light>> lookupLight(Double id) {
		return new LookupLight(id);
	}

	/**
	 * @param id of the seeked device
	 * @return the {@link TradfrjRequest} to get the seeked device
	 */
	public static TradfrjRequest<Optional<Device>> lookupDevice(Double id) {
		return new LookupDevice(id);
	}

	/**
	 * @param lamp the Lamp to modify
	 * @return the {@link ModifyLightRequestBuilder} to build the needed request
	 */
	public static ModifyLightRequestBuilder modifyLight(Light lamp) {
		return ModifyLightRequestBuilder.modify(lamp);
	}
}
