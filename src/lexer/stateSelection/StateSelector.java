package lexer.stateSelection;
import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;
/**
 * Encapsulation of state selection in a chain of responsibilities
 */
public interface StateSelector {
/**
 * Depending on <c> return a new state for <lexer> 	
 */
	public LexerState selectStateFor(Character c, Lexer lexer);
}
