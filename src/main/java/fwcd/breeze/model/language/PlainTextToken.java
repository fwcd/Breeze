package fwcd.breeze.model.language;

import java.util.Collections;
import java.util.List;

public class PlainTextToken implements Token {
	private final int startIndex;
	private final int endIndex;
	
	public PlainTextToken(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public int getStartIndex() { return startIndex; }
	
	@Override
	public int getEndIndex() { return endIndex; }
	
	@Override
	public List<String> getScopes() { return Collections.singletonList("plaintext"); }
}
