package com.fwcd.breeze.core;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.fwcd.breeze.toolbar.BTitleBar;
import com.fwcd.fructose.swing.ResourceImage;
import com.fwcd.palm.languages.Java;
import com.fwcd.palm.theme.DarkTheme;

public class BreezeApp {
	private final JFrame view;
	private final BreezeComponent component;

	public BreezeApp(String title, int width, int height, boolean nativeLook) {
		view = new JFrame(title);
		view.setSize(width, height);
		view.setLayout(new BorderLayout());
		view.setIconImage(new ResourceImage("/icons/iconLQ.png").get());
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