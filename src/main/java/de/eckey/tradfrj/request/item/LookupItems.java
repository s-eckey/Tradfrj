package de.eckey.tradfrj.request.item;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

import de.eckey.tradfrj.request.TradfrjRequest;
import de.eckey.tradfrj.request.TradfrjRequestIterator;

public class LookupItems<T> implements TradfrjRequestIterator<T> {

	private Function<Double, TradfrjRequest<Optional<T>>> function;
	private Iterator<Double> iterator;

	public LookupItems(Collection<Double> ids, Function<Double, TradfrjRequest<Optional<T>>> function) {
		this.function = function;
		iterator = ids.iterator();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public TradfrjRequest<Optional<T>> next() {
		return function.apply(iterator.next());
	}
}
