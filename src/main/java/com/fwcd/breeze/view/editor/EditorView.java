package com.fwcd.breeze.view.editor;

import javax.swing.JComponent;

import com.fwcd.breeze.model.EditorModel;
import com.fwcd.fructose.swing.View;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class EditorView implements View {
	private final RSyntaxTextArea component;
	private final EditorModel model;

	public EditorView() {
		component = new RSyntaxTextArea();
		model = new EditorModel();
	}
	
	public EditorModel getModel() { return model; }
	
	@Override
	public JComponent getComponent() { return component; }
}
