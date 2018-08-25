package com.fwcd.breeze.model.language;

import com.fwcd.fructose.structs.ObservableMap;
import com.fwcd.fructose.structs.ReadOnlyObservableMap;

public class LanguageManager {
	private final ObservableMap<String, Language> languages = new ObservableMap<>();
	
	public void register(Language language) {
		languages.put(language.getKey(), language);
	}
	
	public Language get(String languageKey) {
		return languages.get(languageKey);
	}
	
	public ReadOnlyObservableMap<String, Language> getLanguages() { return languages; }
}
