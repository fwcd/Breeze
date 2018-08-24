package com.fwcd.breeze.view.theme;

import java.awt.Color;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Theme;

public class BreezeTheme {
	private Color background = Color.DARK_GRAY;
	private Color foreground = Color.WHITE;
	private Color lineHighlight = Color.LIGHT_GRAY;
	private Color toolBarBackground = Color.DARK_GRAY.brighter();
	
	public Color getForeground() { return foreground; }
	
	public Color getBackground() { return background; }
	
	public Color getLineHighlight() { return lineHighlight; }
	
	public Color getToolBarBackground() { return toolBarBackground; }
	
	public void setBackground(Color background) { this.background = background; }
	
	public void setLineHighlight(Color lineHighlight) { this.lineHighlight = lineHighlight; }
	
	public void setToolBarBackground(Color toolBarBackground) { this.toolBarBackground = toolBarBackground; }
	
	public void setForeground(Color foreground) { this.foreground = foreground; }
	
	public Theme toRSyntaxTextAreaTheme(RSyntaxTextArea textArea) {
		Theme rstaTheme = new Theme(textArea);
		rstaTheme.bgColor = background;
		rstaTheme.lineNumberColor = foreground;
		rstaTheme.caretColor = foreground;
		rstaTheme.currentLineHighlight = lineHighlight;
		return rstaTheme;
	}
}
