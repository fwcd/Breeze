package com.fwcd.breeze.model;

import java.util.List;

public interface TextBufferModel {
	/** A read-only view of the current lines. */
	List<String> getLines();
	
	void clear();
	
	void delete(TextRange range);
	
	void insert(String text, TextPosition position);
	
	void append(String text);
	
	void appendLine();
	
	/**
	 * Undoes the last action.
	 * 
	 * @return Whether the operation was successful or not
	 */
	boolean undo();
	
	/**
	 * Redoes the last action.
	 * 
	 * @return Whether the operation was successful or not
	 */
	boolean redo();
}
