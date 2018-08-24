package com.fwcd.breeze.view.toolbar;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.fwcd.breeze.model.EditorModel;
import com.fwcd.breeze.view.BreezeView;
import com.fwcd.fructose.swing.View;

public class ToolBarView implements View {
	private final JToolBar component;
	private final JFileChooser fc = new JFileChooser();
	private final int padding = 2;

	public ToolBarView(BreezeView parent) {
		component = new JToolBar();
		component.setBorder(new EmptyBorder(0, 0, 0, 0));
		component.setMargin(new Insets(padding, padding, padding, padding));
		component.setFloatable(false);
		component.setOpaque(true);
		component.setBorderPainted(false);
		
		parent.getTheme().listenAndFire(theme -> {
			component.setBackground(theme.getToolBarBackground());
		});

		EditorModel editor = parent.getEditor().getModel();
		
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
