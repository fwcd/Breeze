package com.fwcd.breeze;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fwcd.breeze.core.BreezeApp;

public class BreezeMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {}
		
		new BreezeApp("Breeze", 480, 640, true);
	}
}
