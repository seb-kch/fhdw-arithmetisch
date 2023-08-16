package lexer.stateSelection;

import lexer.ErrorState;
import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;
/**
 * Chain Ending!
 */
class StateSelectionEnding implements StateSelector {
	public LexerState selectStateFor(Character c, Lexer scanner) {
		return new ErrorState(scanner);
	}
}
