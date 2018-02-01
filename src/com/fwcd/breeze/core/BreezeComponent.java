package com.fwcd.breeze.core;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fwcd.breeze.editor.BEditor;
import com.fwcd.breeze.languages.ProgrammingLang;
import com.fwcd.breeze.theme.Theme;
import com.fwcd.breeze.toolbar.BToolBar;
import com.fwcd.fructose.exception.Rethrow;
import com.fwcd.fructose.swing.Viewable;

public class BreezeComponent implements Viewable {
	private final JPanel view;
	private Theme theme;
	private ProgrammingLang language;
	
	private final BToolBar toolBar;
	private final BEditor editor;
	
	public BreezeComponent(Theme theme, ProgrammingLang language) {
		this.theme = theme;
		this.language = language;
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			throw new Rethrow(e);
		}
		
		view = new JPanel();
		view.setOpaque(false);
		view.setLayout(new BorderLayout());
		
		editor = new BEditor(this);
		view.add(editor.getView(), BorderLayout.CENTER);
		
		toolBar = new BToolBar(this);
		view.add(toolBar.getView(), BorderLayout.NORTH);
		SwingUtilities.invokeLater(editor::focus);
	}
	
	public void addToolbarButton(JButton button) {
		toolBar.addButton(button);
	}
	
	public Theme getTheme() {
		return theme;
	}

	public BEditor getEditor() {
		return editor;
	}

	public ProgrammingLang getLanguage() {
		return language;
	}

	@Override
	public JComponent getView() {
		return view;
	}
}
