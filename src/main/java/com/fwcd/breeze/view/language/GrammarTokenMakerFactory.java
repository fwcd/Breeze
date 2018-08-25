package com.fwcd.breeze.view.language;

import java.util.Set;

import com.fwcd.breeze.model.language.Language;
import com.fwcd.fructose.structs.ReadOnlyObservableMap;

import org.fife.ui.rsyntaxtextarea.TokenMaker;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;

public class GrammarTokenMakerFactory extends TokenMakerFactory {
	private final ReadOnlyObservableMap<String, Language> languages;
	
	public GrammarTokenMakerFactory(ReadOnlyObservableMap<String, Language> languages) {
		this.languages = languages;
	}
	
	@Override
	protected TokenMaker getTokenMakerImpl(String key) {
		return new GrammarTokenMaker(languages.get(key).getGrammar());
	}

	@Override
	public Set<String> keySet() {
		return languages.keySet();
	}
}
