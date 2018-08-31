package com.fwcd.breeze.view.theme;

import java.awt.Color;

import com.fwcd.palm.view.theme.SyntaxElement;
import com.fwcd.palm.view.theme.TemplateTheme;
import com.fwcd.palm.view.theme.ThemedElement;

/**
 * A theme inspired by Visual Studio Code's dark theme.
 */
public class VSCDarkTheme extends TemplateTheme {
	public VSCDarkTheme() {
		setBgColor(Color.DARK_GRAY);
		setFgColor(Color.WHITE);
		setMildBgColor(Color.GRAY);
		setMildFgColor(Color.WHITE.darker());
		setPopupBgColor(Color.DARK_GRAY.brighter());
		set(ThemedElement.EDITOR_BG, new Color(0x252525));
		set(ThemedElement.TOOLBAR, new Color(0x333333));
		set(ThemedElement.LINE_HIGHLIGHT, new Color(0x333333));
		set(SyntaxElement.KEYWORD, Color.MAGENTA);
		set(SyntaxElement.TYPE, Color.GREEN);
		set(SyntaxElement.VARIABLE, Color.CYAN);
		set(SyntaxElement.STRING, Color.ORANGE);
		set(SyntaxElement.COMMENT, Color.GREEN);
		set(SyntaxElement.OTHER, Color.WHITE);
		
		// TODO: Functions, method invocations
	}
}
