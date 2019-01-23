package fwcd.breeze.utils;

import java.util.function.Supplier;

import fwcd.fructose.Listenable;

/**
 * A two-way listenable that prevents infinite
 * listener cycles.
 */
public class TwoWay<L extends Listenable<?>> {
	private final L requested;
	private final L actual;
	
	public TwoWay(Supplier<L> initialValueFactory) {
		requested = initialValueFactory.get();
		actual = initialValueFactory.get();
	}
	
	public L getRequested() { return requested; }
	
	public L getActual() { return actual; }
}
