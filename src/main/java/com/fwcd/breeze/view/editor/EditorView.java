package com.fwcd.breeze.view.editor;

import javax.swing.JComponent;
import javax.swing.event.DocumentEvent;

import com.fwcd.breeze.model.EditorModel;
import com.fwcd.breeze.utils.TwoWay;
import com.fwcd.breeze.view.theme.BreezeTheme;
import com.fwcd.fructose.Observable;
import com.fwcd.fructose.swing.DocumentAdapter;
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
		
		TwoWay<Observable<String>> text = model.getText();
		text.getRequested().listenAndFire(t -> {
			textArea.setText(t);
			text.getActual().set(t);
		});
		textArea.getDocument().addDocumentListener(new DocumentAdapter() {
			@Override
			public void insertUpdate(DocumentEvent e) { fireChange(); }
			
			@Override
			public void changedUpdate(DocumentEvent e) { fireChange(); }
			
			@Override
			public void removeUpdate(DocumentEvent e) { fireChange(); }
			
			private void fireChange() { text.getActual().set(textArea.getText()); }
		});
	}
	
	public EditorModel getModel() { return model; }
	
	@Override
	public JComponent getComponent() { return component; }
}
