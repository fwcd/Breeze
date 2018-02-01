package com.fwcd.breeze.core;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.fwcd.breeze.languages.Java;
import com.fwcd.breeze.theme.DarkTheme;
import com.fwcd.breeze.toolbar.BTitleBar;
import com.fwcd.fructose.swing.ResourceImage;

public class BreezeApp {
	private final JFrame view;
	private final BreezeComponent component;
	
	public BreezeApp(String title, int width, int height, boolean nativeLook) {
		view = new JFrame(title);
		view.setSize(width, height);
		view.setLayout(new BorderLayout());
		view.setIconImage(new ResourceImage("/resources/icons/iconLQ.png").get());
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		component = new BreezeComponent(new DarkTheme(), new Java());
		view.add(component.getView(), BorderLayout.CENTER);
		
		if (!nativeLook) {
			view.setUndecorated(true);
			view.add(new BTitleBar(view).getView(), BorderLayout.NORTH);
		}
		
		view.setVisible(true);
	}
}
