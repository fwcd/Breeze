package com.fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.fwcd.breeze.model.BreezeModel;
import com.fwcd.breeze.view.theme.VSCDarkTheme;
import com.fwcd.breeze.view.toolbar.ToolBarView;
import com.fwcd.fructose.swing.View;
import com.fwcd.palm.controller.editor.PalmEditorController;
import com.fwcd.palm.model.editor.PalmEditorModel;
import com.fwcd.palm.view.editor.PalmEditorView;

public class BreezeView implements View {
	private final JPanel component;

	private final ToolBarView toolBar;
	private final PalmEditorView editor;

	public BreezeView(BreezeModel model) {
		component = new JPanel();
		component.setOpaque(false);
		component.setLayout(new BorderLayout());
		
		PalmEditorModel editorModel = model.getEditor();
		editor = new PalmEditorView(editorModel);
		editor.setFontSize(13);
		new PalmEditorController(editor, editorModel);
		
		editor.getTheme().set(new VSCDarkTheme());
		component.add(editor.getComponent(), BorderLayout.CENTER);
		
		toolBar = new ToolBarView(model, editor.getTheme());
		component.add(toolBar.getComponent(), BorderLayout.NORTH);
		SwingUtilities.invokeLater(editor.getComponent()::requestFocus);
	}

	public void addToolbarButton(JButton button) {
		toolBar.addButton(button);
	}
	
	@Override
	public JComponent getComponent() { return component; }
}
