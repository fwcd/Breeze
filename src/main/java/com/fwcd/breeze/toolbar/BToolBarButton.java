package com.fwcd.breeze.toolbar;

import javax.swing.Icon;
import javax.swing.JButton;

import com.fwcd.fructose.swing.ResourceImage;
import com.fwcd.fructose.swing.TransparentButton;

public class BToolBarButton {
	private final JButton view;
	
	public BToolBarButton(String resourceURL, Runnable onClick) {
		this(resourceURL);
		addClickListener(onClick);
	}
	
	public BToolBarButton(String resourceURL) {
		Icon icon = new ResourceImage(resourceURL).getAsIcon();
		view = new TransparentButton(icon);
	}
	
	public void addClickListener(Runnable onClick) {
		view.addActionListener(l -> onClick.run());
	}
	
	public JButton get() {
		return view;
	}
}
