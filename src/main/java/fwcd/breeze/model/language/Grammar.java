package fwcd.breeze.model.language;

import java.util.List;

public interface Grammar {
	List<Token> tokenize(String text);
}
