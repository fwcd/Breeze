package com.fwcd.breeze.model;

import com.fwcd.breeze.model.language.Language;
import com.fwcd.breeze.model.language.LanguageManager;
import com.fwcd.breeze.model.language.PlainTextGrammar;
import com.fwcd.breeze.model.language.textmate.TextMateGrammar;
import com.fwcd.breeze.model.palm.GrammarSyntaxHighlighter;
import com.fwcd.fructose.Observable;
import com.fwcd.fructose.exception.Rethrow;
import com.fwcd.fructose.io.ResourceFile;
import com.fwcd.palm.model.editor.PalmEditorModel;

import org.eclipse.tm4e.core.registry.Registry;

public class BreezeModel {
	private final PalmEditorModel editor = new PalmEditorModel();
	private final Observable<Language> language;
	private final LanguageManager languageManager = new LanguageManager();
	
	{
		languageManager.register(new Language("text/plain", "Text", new PlainTextGrammar()));
		language = new Observable<>(languageManager.get("text/plain"));
		registerDefaultLanguages();
		
		language.listenAndFire(l -> editor.getSyntaxHighlighter().set(new GrammarSyntaxHighlighter(l.getGrammar())));
	}
	
	public PalmEditorModel getEditor() { return editor; }
	
	private void registerDefaultLanguages() {
		Registry tmRegistry = new Registry();
		Language java = loadTextMateLanguage("text/java", "Java", "/languages/Java.tmLanguage.json", tmRegistry);
		
		languageManager.register(java);
		
		// DEBUG:
		setLanguage("text/java");
	}
	
	private Language loadTextMateLanguage(String key, String name, String resourcePath, Registry tmRegistry) {
		return new ResourceFile(resourcePath)
			.mapStream(in -> {
				try {
					return new Language(key, name, new TextMateGrammar(tmRegistry.loadGrammarFromPathSync(resourcePath, in)));
				} catch (Exception e) {
					throw new Rethrow(e);
				}
			});
	}
	
	public LanguageManager getLanguageManager() { return languageManager; }
	
	public void setLanguage(String languageKey) { language.set(languageManager.get(languageKey)); }
	
	public Observable<Language> getLanguage() { return language; }
}
