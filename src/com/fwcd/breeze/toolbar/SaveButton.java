package com.fwcd.breeze.toolbar;

import java.io.File;

import javax.swing.JFileChooser;

import com.fwcd.breeze.editor.BEditor;

public class SaveButton extends BToolBarButton {
	private final JFileChooser fileChooser;
	private final BEditor editor;
	
	public SaveButton(String resourceURL, JFileChooser fileChooser, BEditor editor) {
		super(resourceURL);
		this.fileChooser = fileChooser;
		this.editor = editor;
		
		addClickListener(this::save);
	}
	
	private void save() {
		int option = fileChooser.showSaveDialog(null);
		File file = fileChooser.getSelectedFile();
		
		if (option == JFileChooser.APPROVE_OPTION && file != null) {
			editor.save(file);
		}
	}
}
