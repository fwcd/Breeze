package com.fwcd.breeze.model;

import com.fwcd.breeze.model.editor.EditorModel;
import com.fwcd.breeze.model.language.Language;
import com.fwcd.breeze.model.language.LanguageManager;
import com.fwcd.breeze.model.language.textmate.TextMateGrammar;
import com.fwcd.fructose.exception.Rethrow;
import com.fwcd.fructose.io.ResourceFile;

import org.eclipse.tm4e.core.registry.Registry;

public class BreezeModel {
	private final EditorModel editor = new EditorModel();
	
	{
		registerLanguages();
	}
	
	public EditorModel getEditor() { return editor; }
	
	private void registerLanguages() {
		Registry tmRegistry = new Registry();
		Language java = loadTextMateLanguage("text/java", "Java", "/languages/Java.tmLanguage.json", tmRegistry);
		
		LanguageManager languageManager = editor.getLanguageManager();
		languageManager.register(java);
		
		// DEBUG:
		editor.setLanguage("text/java");
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
}
