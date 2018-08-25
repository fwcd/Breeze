package com.fwcd.breeze.model.language;

import java.util.HashSet;
import java.util.Set;

public class Language {
	private final String key;
	private final String name;
	private final Set<String> fileExtensions;
	private final Grammar grammar;
	
	public Language(String key, String name, Grammar grammar) {
		this.key = key;
		this.name = name;
		this.grammar = grammar;
		fileExtensions = new HashSet<>();
	}
	
	public Language(String key, String name, Grammar grammar, Set<String> fileExtensions) {
		this.key = key;
		this.name = name;
		this.grammar = grammar;
		this.fileExtensions = fileExtensions;
	}
	
	public Set<String> getFileExtensions() { return fileExtensions; }
	
	public Grammar getGrammar() { return grammar; }
	
	public String getName() { return name; }
	
	public String getKey() { return key; }
}
