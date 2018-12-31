# Tradfrj
Java Lib to connect to Ikea Tradfri via Coap Protocoll.
You need the Tradfri Gateway in order to use this Lib

# Usage

Looks up a coap service running inside the local network with the given mac address 

```
TradfrjService service = new TradfrjService(ServiceLookup.lookup("<gateway mac address>"));
```

Authenticate a new user and get a user code. You have to pass the security code of the gateway and a user name. Handshake can only be done once.

```
final String userCode = service.authenticateUser("<gateway security code>", "<user name>");
```

Set the authenticated user name and the retrieved user code

```
service.setPskStore(new SimpleUserPskStore("<user name>", userCode));

```

Start the service and create an executor

```
service.start();
TradfrjRequestExecutor executor = new TradfrjRequestExecutor(service);
```

Have fun

```
Light light = executor.executeRequest(TradfrjRequests.lookupLight(<ID>)).get();
executor.executeRequest(TradfrjRequests.modifyLight(light).withLightOn(true).withDimmer(245).withColor...);
```

Stop the service

```
service.stop();
```
