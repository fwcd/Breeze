package com.fwcd.breeze.view.toolbar;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.fwcd.breeze.view.BreezeComponent;
import com.fwcd.fructose.swing.View;
import com.fwcd.palm.editor.PalmEditor;
import com.fwcd.palm.theme.Theme;
import com.fwcd.palm.theme.ThemedElement;

public class BreezeToolBar implements View {
	private final JToolBar component;
	private final JFileChooser fc = new JFileChooser(); // TODO: Use NativeFileChooser instead?
	private final int padding = 2;

	public BreezeToolBar(BreezeComponent parent) {
		component = new JToolBar();
		component.setBorder(new EmptyBorder(0, 0, 0, 0));
		component.setMargin(new Insets(padding, padding, padding, padding));
		component.setFloatable(false);
		component.setOpaque(true);
		component.setBorderPainted(false);

		Theme theme = parent.getTheme();
		component.setBackground(theme.colorOf(ThemedElement.TOOLBAR).orElse(theme.bgColor()));

		PalmEditor editor = parent.getEditor();

		component.add(new SaveButton("/icons/saveIcon.png", fc, editor).get());
		component.add(new OpenButton("/icons/openIcon.png", fc, editor).get());
	}

	public void addButton(String title, Runnable onClick) {
		JButton button = new JButton(title);
		button.addActionListener(l -> onClick.run());
		component.add(button);
	}

	public void addButton(JButton button) {
		component.add(button);
	}

	@Override
	public JComponent getComponent() {
		return component;
	}
}
