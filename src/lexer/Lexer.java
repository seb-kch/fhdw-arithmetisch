package lexer;

import java.util.List;

import tokens.Token;
/**
 * The main entry point for lexical analysis of string expressions
 */
public interface Lexer {
/**
 * EFFECTS: Transformation of input string expr into sequence of symbols 
 */
	public List<Token> toTokenSequence(String expr);
/**	
 * Enables state pattern
 */
	void setState(LexerState newState);
}