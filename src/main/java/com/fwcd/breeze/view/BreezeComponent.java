package com.fwcd.breeze.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fwcd.breeze.view.toolbar.BreezeToolBar;
import com.fwcd.fructose.exception.Rethrow;
import com.fwcd.fructose.swing.Viewable;
import com.fwcd.palm.config.PalmConfigured;
import com.fwcd.palm.editor.PalmEditor;
import com.fwcd.palm.languages.ProgrammingLang;
import com.fwcd.palm.theme.Theme;

public class BreezeComponent implements Viewable, PalmConfigured {
	private final JPanel view;
	private Theme theme;
	private ProgrammingLang language;

	private final BreezeToolBar toolBar;
	private final PalmEditor editor;

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

		editor = new PalmEditor(this);
		view.add(editor.getView(), BorderLayout.CENTER);

		toolBar = new BreezeToolBar(this);
		view.add(toolBar.getView(), BorderLayout.NORTH);
		SwingUtilities.invokeLater(editor::focus);
	}

	public void addToolbarButton(JButton button) {
		toolBar.addButton(button);
	}

	@Override
	public Theme getTheme() {
		return theme;
	}

	public PalmEditor getEditor() {
		return editor;
	}

	@Override
	public ProgrammingLang getLanguage() {
		return language;
	}

	@Override
	public JComponent getView() {
		return view;
	}
}
