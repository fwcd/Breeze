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
		
		registerLanguage("text/c", "C", "c.tmLanguage.json", tmRegistry);
		registerLanguage("text/cpp", "C++", "cpp.tmLanguage.json", tmRegistry);
		registerLanguage("text/c-sharp", "C#", "cSharp.tmLanguage.json", tmRegistry);
		registerLanguage("text/css", "CSS", "css.tmLanguage.json", tmRegistry);
		registerLanguage("text/go", "Go", "go.tmLanguage.json", tmRegistry);
		registerLanguage("text/groovy", "Groovy", "groovy.tmLanguage.json", tmRegistry);
		registerLanguage("text/html", "HTML", "html.tmLanguage.json", tmRegistry);
		registerLanguage("text/java", "Java", "java.tmLanguage.json", tmRegistry);
		registerLanguage("text/javascript", "JavaScript", "javaScript.tmLanguage.json", tmRegistry);
		registerLanguage("text/json", "JSON", "json.tmLanguage.json", tmRegistry);
		registerLanguage("text/lua", "Lua", "lua.tmLanguage.json", tmRegistry);
		registerLanguage("text/markdown", "Markdown", "markdown.tmLanguage.json", tmRegistry);
		registerLanguage("text/objective-c", "Objective-C", "objectiveC.tmLanguage.json", tmRegistry);
		registerLanguage("text/python", "Python", "python.tmLanguage.json", tmRegistry);
		registerLanguage("text/ruby", "Ruby", "ruby.tmLanguage.json", tmRegistry);
		registerLanguage("text/swift", "Swift", "swift.tmLanguage.json", tmRegistry);
		registerLanguage("text/xml", "XML", "xml.tmLanguage.json", tmRegistry);
	}
	
	private void registerLanguage(String key, String name, String grammarFileName, Registry tmRegistry) {
		languageManager.register(loadTextMateLanguage(key, name, "/languages/" + grammarFileName, tmRegistry));
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
