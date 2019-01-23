package fwcd.breeze.model.palm;

import java.util.List;

import fwcd.breeze.model.language.Grammar;
import fwcd.breeze.model.language.Token;
import fwcd.palm.model.TextRange;
import fwcd.palm.model.editor.mods.highlighting.SyntaxHighlighter;
import fwcd.palm.model.editor.mods.highlighting.TextStyler;
import fwcd.palm.view.theme.SyntaxElement;

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
		String scope = scopes.get(scopes.size() - 1);
		
		if (scope.startsWith("keyword")) return SyntaxElement.KEYWORD;
		if (scope.startsWith("entity.name.function")) return SyntaxElement.FUNCTION;
		if (scope.startsWith("entity.name.type")) return SyntaxElement.TYPE;
		if (scope.startsWith("storage.type")) return SyntaxElement.TYPE;
		if (scope.startsWith("storage.modifier")) return SyntaxElement.KEYWORD;
		if (scope.startsWith("variable")) return SyntaxElement.VARIABLE;
		if (scope.startsWith("comment")) return SyntaxElement.COMMENT;
		if (scope.startsWith("string")) return SyntaxElement.STRING;
		
		return SyntaxElement.OTHER;
	}
}
