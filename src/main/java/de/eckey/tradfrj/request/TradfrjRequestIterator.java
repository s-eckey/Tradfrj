package de.eckey.tradfrj.request;

import java.util.Iterator;
import java.util.Optional;

public interface TradfrjRequestIterator<T> extends Iterator<TradfrjRequest<Optional<T>>> {

}
