package com.fwcd.breeze.model.language;

import java.util.Collections;
import java.util.List;

public class PlainTextGrammar implements Grammar {
	@Override
	public List<Token> tokenize(String text) {
		return Collections.singletonList(new PlainTextToken(0, text.length()));
	}
}
