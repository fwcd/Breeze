package com.fwcd.breeze.model.language;

import java.util.List;

public interface Token {
	int getStartIndex();
	
	int getEndIndex();
	
	List<String> getScopes();
}
