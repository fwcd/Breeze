package com.fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.fwcd.breeze.model.BreezeModel;
import com.fwcd.breeze.view.editor.EditorView;
import com.fwcd.breeze.view.theme.BreezeTheme;
import com.fwcd.breeze.view.toolbar.ToolBarView;
import com.fwcd.fructose.Observable;
import com.fwcd.fructose.swing.View;

public class BreezeView implements View {
	private final JPanel component;
	private final Observable<BreezeTheme> theme = new Observable<>(new BreezeTheme());

	private final ToolBarView toolBar;
	private final EditorView editor;

	public BreezeView(BreezeModel model) {
		component = new JPanel();
		component.setOpaque(false);
		component.setLayout(new BorderLayout());

		editor = new EditorView(model.getEditor(), theme);
		component.add(editor.getComponent(), BorderLayout.CENTER);

		toolBar = new ToolBarView(this);
		component.add(toolBar.getComponent(), BorderLayout.NORTH);
		SwingUtilities.invokeLater(editor.getComponent()::requestFocus);
	}

	public void addToolbarButton(JButton button) {
		toolBar.addButton(button);
	}
	
	public EditorView getEditor() { return editor; }
	
	@Override
	public JComponent getComponent() { return component; }
}
