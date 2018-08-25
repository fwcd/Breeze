package com.fwcd.breeze.view.language;

import java.util.List;
import java.util.Objects;

import javax.swing.text.Segment;

import com.fwcd.breeze.model.language.Grammar;
import com.fwcd.breeze.model.language.Token;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.TokenImpl;
import org.fife.ui.rsyntaxtextarea.TokenMap;
import org.fife.ui.rsyntaxtextarea.TokenTypes;

public class GrammarTokenMaker extends AbstractTokenMaker {
	private final Grammar grammar;
	
	public GrammarTokenMaker(Grammar grammar) {
		this.grammar = grammar;
	}
	
	@Override
	public org.fife.ui.rsyntaxtextarea.Token getTokenList(Segment text, int initialTokenType, int startOffset) {
		TokenImpl head = null;
		TokenImpl tail = null;
		
		for (Token token : grammar.tokenize(text.toString())) {
			TokenImpl rstaToken = new TokenImpl(text, token.getStartIndex(), token.getEndIndex(), startOffset, toType(token.getScopes()), 0);
			if (head == null) {
				head = rstaToken;
				tail = rstaToken;
			} else {
				tail.setNextToken(rstaToken);
				tail = rstaToken;
			}
		}
		
		return Objects.requireNonNull(head, "Tokenization did not yield any tokens");
	}
	
	private int toType(List<String> tokenScopes) {
		switch (tokenScopes.get(0)) {
			case "storage": return TokenTypes.DATA_TYPE;
			case "keyword": return TokenTypes.RESERVED_WORD;
			case "comment": return TokenTypes.COMMENT_MARKUP;
			case "constant": return TokenTypes.VARIABLE;
			case "variable": return TokenTypes.VARIABLE;
			case "entity": {
				switch (tokenScopes.get(2)) {
					case "function": return TokenTypes.FUNCTION;
					case "type": return TokenTypes.DATA_TYPE;
					default: break;
				}
				break;
			}
			default: break;
		}
		return TokenTypes.WHITESPACE;
	}
	
	@Override
	public TokenMap getWordsToHighlight() {
		return null;
	}
}
