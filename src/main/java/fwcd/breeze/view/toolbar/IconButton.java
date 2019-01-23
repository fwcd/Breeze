package fwcd.breeze.view.toolbar;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JButton;

import fwcd.fructose.swing.ResourceImage;
import fwcd.fructose.swing.TransparentButton;

public class IconButton {
	private final JButton component;
	
	public IconButton(String resourceURL, Runnable onClick) {
		this(resourceURL);
		addClickListener(onClick);
	}
	
	public IconButton(String resourceURL) {
		Icon icon = new ResourceImage(resourceURL).getAsIcon();
		component = new TransparentButton(icon);
		component.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	}
	
	public void addClickListener(Runnable onClick) {
		component.addActionListener(l -> onClick.run());
	}
	
	public JButton get() {
		return component;
	}
}
