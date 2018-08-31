package com.fwcd.breeze.model.palm;

import java.util.List;

import com.fwcd.breeze.model.language.Grammar;
import com.fwcd.breeze.model.language.Token;
import com.fwcd.palm.model.TextRange;
import com.fwcd.palm.model.editor.mods.highlighting.SyntaxHighlighter;
import com.fwcd.palm.model.editor.mods.highlighting.TextStyler;
import com.fwcd.palm.view.theme.SyntaxElement;

public class GrammarSyntaxHighlighter implements SyntaxHighlighter {
	private final Grammar grammar;
	
	public GrammarSyntaxHighlighter(Grammar grammar) {
		this.grammar = grammar;
	}
	
	@Override
	public void performHighlighting(String text, TextStyler styler) {
		for (Token token : grammar.tokenize(text)) {
			SyntaxElement element = toSyntaxElement(token.getScopes());
			styler.colorize(new TextRange(token.getStartIndex(), token.getEndIndex() - token.getStartIndex()), element);
		}
	}
	
	private SyntaxElement toSyntaxElement(List<String> scopes) {
		if (scopes.size() < 1) return SyntaxElement.OTHER;
		String rawElement = scopes.get(scopes.size() - 1).split("\\.", 2)[0];
		
		switch (rawElement) {
			case "keyword": return SyntaxElement.KEYWORD;
			case "entity": return SyntaxElement.TYPE;
			case "storage": return SyntaxElement.TYPE;
			case "variable": return SyntaxElement.VARIABLE;
			case "comment": return SyntaxElement.COMMENT;
			default: return SyntaxElement.OTHER;
		}
	}
}
