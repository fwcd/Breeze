package com.fwcd.breeze.view.theme;

import static org.fife.ui.rsyntaxtextarea.TokenTypes.*;

import java.awt.Color;
import java.awt.Font;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.Style;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Theme;

public class BreezeTheme {
	private Color background = Color.DARK_GRAY;
	private Color foreground = Color.WHITE;
	private Color lineHighlight = Color.GRAY.darker();
	private Color toolBarBackground = Color.DARK_GRAY.brighter();
	private Color selection = Color.CYAN.darker();
	
	// Syntax highlighting
	
	private Color comment = Color.GREEN;
	private Color docComment = comment;
	private Color markupComment = comment;
	private Color keyword = Color.BLUE;
	private Color dataType = Color.GREEN;
	private Color function = Color.YELLOW;
	private Color preprocessor = Color.MAGENTA;
	private Color operator = Color.WHITE;
	private Color regex = Color.ORANGE;
	private Color variable = Color.CYAN;
	private Color literalNumber = Color.GREEN;
	private Color literalString = Color.ORANGE;
	private Color error = Color.RED;
	
	public Theme toRSyntaxTextAreaTheme(RSyntaxTextArea textArea) {
		Theme rstaTheme = new Theme(textArea);
		rstaTheme.bgColor = background;
		rstaTheme.lineNumberColor = foreground;
		rstaTheme.gutterBackgroundColor = background;
		rstaTheme.gutterBorderColor = background;
		rstaTheme.caretColor = foreground;
		rstaTheme.currentLineHighlight = lineHighlight;
		rstaTheme.selectionBG = selection;
		rstaTheme.selectionFG = foreground;
		
		SyntaxScheme scheme = new SyntaxScheme(true);
		Font font = RSyntaxTextArea.getDefaultFont();
		scheme.setStyle(COMMENT_EOL, new Style(comment, null, font));
		scheme.setStyle(COMMENT_MULTILINE, new Style(comment, null, font));
		scheme.setStyle(COMMENT_DOCUMENTATION, new Style(docComment, null, font));
		scheme.setStyle(COMMENT_KEYWORD, new Style(new Color(255,152,0), null, font));
		scheme.setStyle(COMMENT_MARKUP, new Style(Color.gray, null, font));
		scheme.setStyle(RESERVED_WORD, new Style(keyword, null, font));
		scheme.setStyle(RESERVED_WORD_2, new Style(keyword, null, font));
		scheme.setStyle(FUNCTION, new Style(function));
		scheme.setStyle(LITERAL_BOOLEAN, new Style(literalNumber));
		scheme.setStyle(LITERAL_NUMBER_DECIMAL_INT, new Style(literalNumber));
		scheme.setStyle(LITERAL_NUMBER_FLOAT, new Style(literalNumber));
		scheme.setStyle(LITERAL_NUMBER_HEXADECIMAL, new Style(literalNumber));
		scheme.setStyle(LITERAL_STRING_DOUBLE_QUOTE, new Style(literalString));
		scheme.setStyle(LITERAL_CHAR, new Style(literalString));
		scheme.setStyle(LITERAL_BACKQUOTE, new Style(literalString));
		scheme.setStyle(DATA_TYPE, new Style(dataType, null, font));
		scheme.setStyle(VARIABLE, new Style(variable));
		scheme.setStyle(REGEX, new Style(regex));
		scheme.setStyle(ANNOTATION, new Style(Color.gray));
		scheme.setStyle(IDENTIFIER, new Style(null));
		scheme.setStyle(WHITESPACE, new Style(Color.gray));
		scheme.setStyle(SEPARATOR, new Style(Color.RED));
		scheme.setStyle(OPERATOR, new Style(operator));
		scheme.setStyle(PREPROCESSOR, new Style(preprocessor));
		scheme.setStyle(MARKUP_TAG_DELIMITER, new Style(Color.RED));
		scheme.setStyle(MARKUP_TAG_NAME, new Style(Color.BLUE));
		scheme.setStyle(MARKUP_TAG_ATTRIBUTE, new Style(new Color(63,127,127)));
		scheme.setStyle(MARKUP_TAG_ATTRIBUTE_VALUE, new Style(literalString));
		scheme.setStyle(MARKUP_COMMENT, new Style(markupComment, null, font));
		scheme.setStyle(MARKUP_DTD, new Style(function));
		scheme.setStyle(MARKUP_PROCESSING_INSTRUCTION, new Style(preprocessor));
		scheme.setStyle(MARKUP_CDATA, new Style(new Color(0xcc6600)));
		scheme.setStyle(MARKUP_CDATA_DELIMITER, new Style(new Color(0x008080)));
		scheme.setStyle(MARKUP_ENTITY_REFERENCE, new Style(dataType));
		scheme.setStyle(ERROR_IDENTIFIER, new Style(error));
		scheme.setStyle(ERROR_NUMBER_FORMAT, new Style(error));
		scheme.setStyle(ERROR_STRING_DOUBLE, new Style(error));
		scheme.setStyle(ERROR_CHAR, new Style(error));
		
		rstaTheme.scheme = scheme;
		
		textArea.setForeground(foreground);
		
		return rstaTheme;
	}
	
	public Color getForeground() { return foreground; }
	
	public Color getBackground() { return background; }
	
	public Color getLineHighlight() { return lineHighlight; }
	
	public Color getToolBarBackground() { return toolBarBackground; }
	
	public Color getComment() { return comment; }
	
	public Color getDataType() { return dataType; }
	
	public Color getDocComment() { return docComment; }
	
	public Color getError() { return error; }
	
	public Color getFunction() { return function; }
	
	public Color getKeyword() { return keyword; }
	
	public Color getLiteralNumber() { return literalNumber; }
	
	public Color getLiteralString() { return literalString; }
	
	public Color getMarkupComment() { return markupComment; }
	
	public Color getOperator() { return operator; }
	
	public Color getPreprocessor() { return preprocessor; }
	
	public Color getRegex() { return regex; }
	
	public Color getVariable() { return variable; }
	
	public Color getSelection() { return selection; }
	
	public void setBackground(Color background) { this.background = background; }
	
	public void setLineHighlight(Color lineHighlight) { this.lineHighlight = lineHighlight; }
	
	public void setToolBarBackground(Color toolBarBackground) { this.toolBarBackground = toolBarBackground; }
	
	public void setForeground(Color foreground) { this.foreground = foreground; }
	
	public void setComment(Color comment) { this.comment = comment; }
	
	public void setDataType(Color dataType) { this.dataType = dataType; }
	
	public void setDocComment(Color docComment) { this.docComment = docComment; }
	
	public void setError(Color error) { this.error = error; }
	
	public void setFunction(Color function) { this.function = function; }
	
	public void setKeyword(Color keyword) { this.keyword = keyword; }
	
	public void setLiteralNumber(Color literalNumber) { this.literalNumber = literalNumber; }
	
	public void setLiteralString(Color literalString) { this.literalString = literalString; }
	
	public void setMarkupComment(Color markupComment) { this.markupComment = markupComment; }
	
	public void setOperator(Color operator) { this.operator = operator; }
	
	public void setPreprocessor(Color preprocessor) { this.preprocessor = preprocessor; }
	
	public void setRegex(Color regex) { this.regex = regex; }
	
	public void setVariable(Color variable) { this.variable = variable; }
	
	public void setSelection(Color selection) { this.selection = selection; }
}
