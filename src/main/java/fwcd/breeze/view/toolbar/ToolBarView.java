package fwcd.breeze.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import fwcd.breeze.model.BreezeModel;
import fwcd.fructose.Observable;
import fwcd.fructose.swing.Viewable;
import fwcd.palm.view.theme.Theme;

public class ToolBarView implements Viewable {
	private final JToolBar component;
	private final JFileChooser fc = new JFileChooser();
	private final int padding = 2;

	public ToolBarView(BreezeModel model, Observable<Theme> theme) {
		component = new JToolBar();
		component.setBorder(new EmptyBorder(0, 0, 0, 0));
		component.setMargin(new Insets(padding, padding, padding, padding));
		component.setFloatable(false);
		component.setOpaque(true);
		component.setBorderPainted(false);
		component.setLayout(new BorderLayout());
		
		theme.listenAndFire(it -> {
			component.setBackground(it.bgColor());
		});
		
		JPanel left = new JPanel();
		left.setOpaque(false);
		left.add(new SaveButton("/icons/saveIcon.png", fc, model.getEditor()).get());
		left.add(new OpenButton("/icons/openIcon.png", fc, model.getEditor()).get());
		component.add(left, BorderLayout.WEST);
		
		JPanel right = new JPanel();
		right.setOpaque(false);
		right.add(new LanguagePickerView(model).getComponent());
		component.add(right, BorderLayout.EAST);
	}

	public void addButton(String title, Runnable onClick) {
		JButton button = new JButton(title);
		button.addActionListener(l -> onClick.run());
		component.add(button);
	}

	public void addButton(JButton button) {
		component.add(button);
	}

	@Override
	public JComponent getComponent() {
		return component;
	}
}
