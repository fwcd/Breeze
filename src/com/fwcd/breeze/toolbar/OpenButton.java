package com.fwcd.breeze.toolbar;

import java.io.File;

import javax.swing.JFileChooser;

import com.fwcd.breeze.editor.BEditor;

public class OpenButton extends BToolBarButton {
	private final JFileChooser fileChooser;
	private final BEditor editor;
	
	public OpenButton(String resourceURL, JFileChooser fileChooser, BEditor editor) {
		super(resourceURL);
		this.fileChooser = fileChooser;
		this.editor = editor;
		
		addClickListener(this::open);
	}
	
	private void open() {
		int option = fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		
		if (option == JFileChooser.APPROVE_OPTION && file != null) {
			editor.open(file);
		}
	}
}
