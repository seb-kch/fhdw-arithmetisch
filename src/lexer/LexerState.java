package lexer;
/** 
 * Lexer state pattern
 * Each state knows the lexer, whose state it is, by an attribute, i.e. a permanent reference
 * This 'scan'-Operation does not carry formal parameter of type Lexer
 */
public interface LexerState {
/**
 * May add symbol to current Scanner result depending on <c>, 
 * May erase <c> in input string 
 * May change state    
 */
	public abstract void scan(Character c);
}
