package com.fwcd.breeze;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fwcd.fructose.exception.Rethrow;

public class BreezeMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			throw new Rethrow(e);
		}
		
		new BreezeFrame("Breeze", 480, 640, /* nativeLook */ true);
	}
}
