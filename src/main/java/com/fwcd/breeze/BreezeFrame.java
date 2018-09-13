package com.fwcd.breeze;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.fwcd.breeze.model.BreezeModel;
import com.fwcd.breeze.view.BreezeView;
import com.fwcd.breeze.view.toolbar.TitleBarView;
import com.fwcd.fructose.swing.ResourceImage;

public class BreezeFrame {
	private final JFrame view;
	private final BreezeView breeze;

	public BreezeFrame(String title, int width, int height, boolean nativeLook) {
		view = new JFrame(title);
		view.setSize(width, height);
		view.setLayout(new BorderLayout());
		view.setIconImage(new ResourceImage("/icons/icon32.png").get());
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		breeze = new BreezeView(new BreezeModel());
		view.add(breeze.getComponent(), BorderLayout.CENTER);

		if (!nativeLook) {
			view.setUndecorated(true);
			view.add(new TitleBarView(view).getComponent(), BorderLayout.NORTH);
		}

		view.setVisible(true);
	}
}
