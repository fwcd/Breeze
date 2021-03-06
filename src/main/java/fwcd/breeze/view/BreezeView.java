package fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fwcd.breeze.model.BreezeModel;
import fwcd.breeze.view.theme.VSCDarkTheme;
import fwcd.breeze.view.toolbar.ToolBarView;
import fwcd.fructose.swing.Viewable;
import fwcd.palm.controller.editor.PalmEditorController;
import fwcd.palm.model.editor.PalmEditorModel;
import fwcd.palm.view.editor.PalmEditorView;

public class BreezeView implements Viewable {
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
