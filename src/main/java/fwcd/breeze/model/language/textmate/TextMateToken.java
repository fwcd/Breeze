package fwcd.breeze.model.language.textmate;

import java.util.List;

import fwcd.breeze.model.language.Token;

import org.eclipse.tm4e.core.grammar.IToken;

public class TextMateToken implements Token {
	private final IToken tmToken;
	
	public TextMateToken(IToken tmToken) {
		this.tmToken = tmToken;
	}
	
	@Override
	public int getStartIndex() { return tmToken.getStartIndex(); }
	
	@Override
	public int getEndIndex() { return tmToken.getEndIndex(); }
	
	@Override
	public List<String> getScopes() { return tmToken.getScopes(); }
}
