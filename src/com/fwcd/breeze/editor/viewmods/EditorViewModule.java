package com.fwcd.breeze.editor.viewmods;

import java.awt.Dimension;
import java.awt.Graphics2D;

import com.fwcd.breeze.editor.BEditor;

public interface EditorViewModule {
	// TODO: Stuff like line highlights and syntax highlighters belong here
	
	default void format(String text, BEditor editor) {}

	default void renderBG(Graphics2D g2d, Dimension canvasSize, BEditor editor) {}

	default void renderFG(Graphics2D g2d, Dimension canvasSize, BEditor editor) {}
}
