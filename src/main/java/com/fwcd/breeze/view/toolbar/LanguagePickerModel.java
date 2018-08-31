package com.fwcd.breeze.view.toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import com.fwcd.breeze.model.language.Language;
import com.fwcd.breeze.model.language.LanguageManager;

public class LanguagePickerModel implements ComboBoxModel<String> {
	private final LanguageManager languageManager;
	private final List<ListDataListener> listeners = new ArrayList<>();
	private final Map<String, String> languageNameToKeyMap = new HashMap<>();
	private final List<String> languages = new ArrayList<>();
	private Object selected = null;
	
	public LanguagePickerModel(LanguageManager languageManager) {
		this.languageManager = languageManager;
		
		languageManager.getLanguages().listenAndFire(languages -> {
			clearLanguages();
			languages.values()
				.stream()
				.sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName()))
				.forEach(this::addLanguage);
		});
	}
	
	private void clearLanguages() {
		int index = languages.size() - 1;
		if (index >= 0) {
			languageNameToKeyMap.clear();
			languages.clear();
			
			ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, index);
			
			for (ListDataListener listener : listeners) {
				listener.intervalRemoved(e);
			}
		}
	}
	
	private void addLanguage(Language language) {
		addLanguage(language.getName(), language.getKey());
	}
	
	private void addLanguage(String name, String key) {
		languageNameToKeyMap.put(name, key);
		languages.add(name);
		
		int index = languages.size() - 1;
		ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, index, index);
		
		for (ListDataListener listener : listeners) {
			listener.intervalAdded(e);
		}
	}
	
	public Optional<Language> getSelectedLanguage() {
		return Optional.ofNullable(languageNameToKeyMap.get(selected)).map(languageManager::get);
	}
	
	@Override
	public void addListDataListener(ListDataListener l) {
		listeners.add(l);
	}
	
	@Override
	public String getElementAt(int index) {
		return languages.get(index);
	}
	
	@Override
	public Object getSelectedItem() {
		return selected;
	}
	
	@Override
	public int getSize() {
		return languages.size();
	}
	
	@Override
	public void removeListDataListener(ListDataListener l) {
		listeners.remove(l);
	}
	
	@Override
	public void setSelectedItem(Object anItem) {
		selected = anItem;
	}
}
