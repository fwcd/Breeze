package fwcd.breeze.view.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fwcd.fructose.geometry.Vector2D;
import fwcd.fructose.swing.MouseHandler;
import fwcd.fructose.swing.Viewable;

public class TitleBarView implements Viewable {
	private JComponent component;
	private JButton closeButton;
	
	public TitleBarView(JFrame frame) {
		component = new JPanel();
		component.setBackground(Color.DARK_GRAY.darker());
		component.setPreferredSize(new Dimension(20, 20));
		component.setLayout(new BorderLayout());
		
		JPanel windowButtons = new JPanel();
		windowButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		windowButtons.setOpaque(false);
		
		closeButton = new JButton();
		closeButton.setPreferredSize(new Dimension(20, 20));
		closeButton.setBorderPainted(false);
		closeButton.setOpaque(true);
		closeButton.setBackground(Color.RED);
		closeButton.addActionListener(l -> System.exit(0));
		windowButtons.add(closeButton);
		
		component.add(windowButtons, BorderLayout.EAST);
		
		MouseHandler mouseHandler = new MouseHandler() {
			private Vector2D lastPos = null;
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Vector2D delta = new Vector2D(0, 0);
				
				if (lastPos != null) {
					delta = posOf(e).sub(lastPos);
				}
				
				Point screenPos = frame.getLocationOnScreen();
				frame.setLocation(
						(int) (screenPos.getX() + delta.getX()),
						(int) (screenPos.getY() + delta.getY())
				);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lastPos = posOf(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				lastPos = null;
			}
		};
		mouseHandler.connect(component);
	}
	
	@Override
	public JComponent getComponent() {
		return component;
	}
}
