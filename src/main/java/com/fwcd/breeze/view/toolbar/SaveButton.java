package com.fwcd.breeze.view.toolbar;

import java.io.File;

import javax.swing.JFileChooser;

import com.fwcd.palm.model.editor.PalmEditorModel;

public class SaveButton extends IconButton {
	private final JFileChooser fileChooser;
	private final PalmEditorModel editor;

	public SaveButton(String resourceURL, JFileChooser fileChooser, PalmEditorModel editor) {
		super(resourceURL);
		this.fileChooser = fileChooser;
		this.editor = editor;

		addClickListener(this::save);
	}

	private void save() {
		int option = fileChooser.showSaveDialog(null);
		File file = fileChooser.getSelectedFile();

		if (option == JFileChooser.APPROVE_OPTION && file != null) {
			editor.save(file.toPath());
		}
	}
}
