package com.fwcd.breeze.view.editor;

import javax.swing.JComponent;

import com.fwcd.breeze.model.EditorModel;
import com.fwcd.breeze.view.theme.BreezeTheme;
import com.fwcd.fructose.Observable;
import com.fwcd.fructose.swing.View;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class EditorView implements View {
	private final RTextScrollPane component;
	private final RSyntaxTextArea textArea;
	private final EditorModel model;

	public EditorView(EditorModel model, Observable<BreezeTheme> theme) {
		this.model = model;
		
		textArea = new RSyntaxTextArea();
		component = new RTextScrollPane(textArea);
		
		theme.listenAndFire(t -> t.toRSyntaxTextAreaTheme(textArea).apply(textArea));
	}
	
	public EditorModel getModel() { return model; }
	
	@Override
	public JComponent getComponent() { return component; }
}
