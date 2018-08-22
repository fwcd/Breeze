package com.fwcd.breeze.view.toolbar;

import javax.swing.Icon;
import javax.swing.JButton;

import com.fwcd.fructose.swing.ResourceImage;
import com.fwcd.fructose.swing.TransparentButton;

public class IconButton {
	private final JButton view;
	
	public IconButton(String resourceURL, Runnable onClick) {
		this(resourceURL);
		addClickListener(onClick);
	}
	
	public IconButton(String resourceURL) {
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
