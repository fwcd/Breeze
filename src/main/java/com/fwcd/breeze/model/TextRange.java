package com.fwcd.breeze.model;

/** An inclusive text range */
public class TextRange {
	private final TextPosition start;
	private final TextPosition end;
	
	public TextRange(TextPosition start, TextPosition end) {
		this.start = start;
		this.end = end;
	}
	
	public TextPosition getStart() { return start; }
	
	public TextPosition getEnd() { return end; }
}
