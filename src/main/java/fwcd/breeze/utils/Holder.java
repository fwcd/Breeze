package fwcd.breeze.utils;

import java.util.Objects;
import java.util.Optional;

/**
 * A basic (optional) value holder that may be
 * used to "reassign" local variables from a lambda.
 */
public class Holder<T> {
	private T value = null;
	
	public boolean isEmpty() { return value == null; }
	
	public boolean isPresent() { return value != null; }
	
	public void set(T value) { this.value = value; }
	
	public Optional<T> get() { return Optional.ofNullable(value); }
	
	public T expect() { return Objects.requireNonNull(value, "Expected holder value was null"); }
}
