package fwcd.breeze.model.language.textmate;

import java.util.ArrayList;
import java.util.List;

import fwcd.breeze.model.language.Grammar;
import fwcd.breeze.model.language.Token;

import org.eclipse.tm4e.core.grammar.IGrammar;
import org.eclipse.tm4e.core.grammar.IToken;
import org.eclipse.tm4e.core.grammar.ITokenizeLineResult;
import org.eclipse.tm4e.core.grammar.StackElement;

public class TextMateGrammar implements Grammar {
	private final IGrammar tmGrammar;
	
	public TextMateGrammar(IGrammar tmGrammar) {
		this.tmGrammar = tmGrammar;
	}
	
	@Override
	public List<Token> tokenize(String text) {
		String[] lines = text.split(System.lineSeparator());
		StackElement ruleStack = null;
		List<Token> tokens = new ArrayList<>();
		
		for (String line : lines) {
			ITokenizeLineResult tokenization = tmGrammar.tokenizeLine(line, ruleStack);
			for (IToken token : tokenization.getTokens()) {
				tokens.add(new TextMateToken(token));
			}
			ruleStack = tokenization.getRuleStack();
		}
		
		return tokens;
	}
}
