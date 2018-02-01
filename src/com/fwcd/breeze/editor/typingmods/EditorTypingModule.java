package com.fwcd.breeze.editor.typingmods;

import com.fwcd.breeze.editor.BEditor;

public interface EditorTypingModule {
	/**
	 * Called when something is inserted into the editor.
	 * 
	 * @param delta - The String typed
	 * @param offset - The offset at the beginning of the change
	 * @param editor - The editor
	 */
	void onInsert(String delta, int offset, BEditor editor);
	
	/**
	 * Called when something is removed from the editor.
	 * 
	 * @param length - The length of the change
	 * @param offset - The offset at the beginning of the change
	 * @param editor - The editor
	 */
	void onRemove(int length, int offset, BEditor editor);
}
