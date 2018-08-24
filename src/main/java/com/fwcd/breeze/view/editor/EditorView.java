package com.fwcd.breeze.view.editor;

import javax.swing.JComponent;

import com.fwcd.breeze.model.EditorModel;
import com.fwcd.fructose.swing.View;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class EditorView implements View {
	private final RTextScrollPane component;
	private final RSyntaxTextArea textArea;
	private final EditorModel model;

	public EditorView() {
		model = new EditorModel();
		
		textArea = new RSyntaxTextArea();
		
		component = new RTextScrollPane(textArea);
	}
	
	public EditorModel getModel() { return model; }
	
	@Override
	public JComponent getComponent() { return component; }
}
