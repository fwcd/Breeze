package com.fwcd.breeze.toolbar;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.fwcd.breeze.core.BreezeComponent;
import com.fwcd.breeze.editor.BEditor;
import com.fwcd.breeze.theme.Theme;
import com.fwcd.breeze.theme.ThemedElement;
import com.fwcd.fructose.swing.Viewable;

public class BToolBar implements Viewable {
	private final JToolBar view;
	private final JFileChooser fc = new JFileChooser(); // TODO: Use NativeFileChooser instead?
	private final int padding = 2;

	public BToolBar(BreezeComponent parent) {
		view = new JToolBar();
		view.setBorder(new EmptyBorder(0, 0, 0, 0));
		view.setMargin(new Insets(padding, padding, padding, padding));
		view.setFloatable(false);
		view.setOpaque(true);
		view.setBorderPainted(false);
		
		Theme theme = parent.getTheme();
		view.setBackground(theme.colorOf(ThemedElement.TOOLBAR).orElse(theme.bgColor()));
		
		BEditor editor = parent.getEditor();
		
		view.add(new SaveButton("/resources/icons/saveIcon.png", fc, editor).get());
		view.add(new OpenButton("/resources/icons/openIcon.png", fc, editor).get());
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
