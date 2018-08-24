package com.fwcd.breeze.model;

public class TextPosition implements Comparable<TextPosition> {
	private final int line;
	private final int column;
	
	public TextPosition(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public int getColumn() { return column; }
	
	public int getLine() { return line; }
	
	@Override
	public int compareTo(TextPosition o) {
		int linesCompared = Integer.compare(line, o.line);
		if (linesCompared == 0) {
			return Integer.compare(column, o.column);
		} else return linesCompared;
	}
	
	@Override
	public int hashCode() { return line * column * 9; }
	
	@Override
	public boolean equals(Object obj) { return compareTo((TextPosition) obj) == 0; }
	
	@Override
	public String toString() { return "(" + line + ", " + column + ")"; }
}
