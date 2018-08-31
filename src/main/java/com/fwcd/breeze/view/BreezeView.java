package com.fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.fwcd.breeze.model.BreezeModel;
import com.fwcd.breeze.view.toolbar.ToolBarView;
import com.fwcd.fructose.swing.View;
import com.fwcd.palm.PalmEditor;
import com.fwcd.palm.view.editor.PalmEditorView;
import com.fwcd.palm.view.theme.DarkTheme;

public class BreezeView implements View {
	private final JPanel component;

	private final ToolBarView toolBar;
	private final PalmEditor editor;

	public BreezeView(BreezeModel model) {
		component = new JPanel();
		component.setOpaque(false);
		component.setLayout(new BorderLayout());
		
		editor = new PalmEditor();
		PalmEditorView editorView = editor.getView();
		editorView.getTheme().set(new DarkTheme());
		component.add(editorView.getComponent(), BorderLayout.CENTER);

		toolBar = new ToolBarView(editor);
		component.add(toolBar.getComponent(), BorderLayout.NORTH);
		SwingUtilities.invokeLater(editorView.getComponent()::requestFocus);
	}

	public void addToolbarButton(JButton button) {
		toolBar.addButton(button);
	}
	
	@Override
	public JComponent getComponent() { return component; }
}
