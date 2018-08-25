package com.fwcd.breeze.view.toolbar;

import java.io.File;

import javax.swing.JFileChooser;

import com.fwcd.breeze.model.editor.EditorModel;

public class OpenButton extends IconButton {
	private final JFileChooser fileChooser;
	private final EditorModel editor;

	public OpenButton(String resourceURL, JFileChooser fileChooser, EditorModel editor) {
		super(resourceURL);
		this.fileChooser = fileChooser;
		this.editor = editor;

		addClickListener(this::open);
	}

	private void open() {
		int option = fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();

		if (option == JFileChooser.APPROVE_OPTION && file != null) {
			editor.open(file.toPath());
		}
	}
}
