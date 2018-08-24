package com.fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.fwcd.breeze.view.toolbar.BreezeTitleBar;
import com.fwcd.fructose.swing.ResourceImage;
import com.fwcd.palm.languages.Java;
import com.fwcd.palm.theme.DarkTheme;

public class BreezeFrame {
	private final JFrame view;
	private final BreezeComponent component;

	public BreezeFrame(String title, int width, int height, boolean nativeLook) {
		view = new JFrame(title);
		view.setSize(width, height);
		view.setLayout(new BorderLayout());
		view.setIconImage(new ResourceImage("/icons/iconLQ.png").get());
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		component = new BreezeComponent(new DarkTheme(), new Java());
		view.add(component.getComponent(), BorderLayout.CENTER);

		if (!nativeLook) {
			view.setUndecorated(true);
			view.add(new BreezeTitleBar(view).getComponent(), BorderLayout.NORTH);
		}

		view.setVisible(true);
	}
}
