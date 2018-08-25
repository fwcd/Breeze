package com.fwcd.breeze.model.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fwcd.breeze.model.language.Language;
import com.fwcd.breeze.model.language.LanguageManager;
import com.fwcd.breeze.model.language.PlainTextGrammar;
import com.fwcd.breeze.utils.TwoWay;
import com.fwcd.fructose.Observable;

public class EditorModel {
	private final TwoWay<Observable<String>> text = new TwoWay<>(() -> new Observable<>(""));
	private final Observable<Language> language;
	private final LanguageManager languageManager = new LanguageManager();
	
	{
		languageManager.register(new Language("text/plain", "Text", new PlainTextGrammar()));
		language = new Observable<>(languageManager.get("text/plain"));
	}
	
	public TwoWay<Observable<String>> getText() { return text; }
	
	public void open(Path file) {
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			StringBuilder buffer = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				line = reader.readLine();
			}
			text.getRequested().set(buffer.toString());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public void save(Path file) {
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write(text.getActual().get());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public LanguageManager getLanguageManager() { return languageManager; }
	
	public void setLanguage(String languageKey) { language.set(languageManager.get(languageKey)); }
	
	public Observable<Language> getLanguage() { return language; }
}
