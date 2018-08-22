package com.fwcd.breeze.view.toolbar;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.fwcd.breeze.view.BreezeComponent;
import com.fwcd.fructose.swing.Viewable;
import com.fwcd.palm.editor.PalmEditor;
import com.fwcd.palm.theme.Theme;
import com.fwcd.palm.theme.ThemedElement;

public class BreezeToolBar implements Viewable {
	private final JToolBar view;
	private final JFileChooser fc = new JFileChooser(); // TODO: Use NativeFileChooser instead?
	private final int padding = 2;

	public BreezeToolBar(BreezeComponent parent) {
		view = new JToolBar();
		view.setBorder(new EmptyBorder(0, 0, 0, 0));
		view.setMargin(new Insets(padding, padding, padding, padding));
		view.setFloatable(false);
		view.setOpaque(true);
		view.setBorderPainted(false);

		Theme theme = parent.getTheme();
		view.setBackground(theme.colorOf(ThemedElement.TOOLBAR).orElse(theme.bgColor()));

		PalmEditor editor = parent.getEditor();

		view.add(new SaveButton("/icons/saveIcon.png", fc, editor).get());
		view.add(new OpenButton("/icons/openIcon.png", fc, editor).get());
	}

	@Override
	public JComponent getView() {
		return view;
	}

	public void addButton(String title, Runnable onClick) {
		JButton button = new JButton(title);
		button.addActionListener(l -> onClick.run());
		view.add(button);
	}

	public void addButton(JButton button) {
		view.add(button);
	}
}
