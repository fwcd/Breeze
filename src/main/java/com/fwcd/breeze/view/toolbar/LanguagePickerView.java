package com.fwcd.breeze.view.toolbar;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.fwcd.breeze.model.BreezeModel;
import com.fwcd.fructose.swing.View;

public class LanguagePickerView implements View {
	private final JComboBox<String> component;
	private final LanguagePickerModel model;
	
	public LanguagePickerView(BreezeModel breezeModel) {
		model = new LanguagePickerModel(breezeModel.getLanguageManager());
		component = new JComboBox<>(model);
		
		breezeModel.getLanguage().listenAndFire(it -> model.setSelectedItem(it.getName()));
		
		component.setMaximumSize(component.getPreferredSize());
		component.addActionListener(l -> model.getSelectedLanguage().ifPresent(breezeModel.getLanguage()::set));
	}
	
	@Override
	public JComponent getComponent() { return component; }
}
