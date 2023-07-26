package lexer;
/**
 * Responsible for determining the next state
 */
public class SelectionState implements LexerState {
	public void scan(Character c, Lexer lexer) {
		if(Character.isWhitespace(c)) {
			lexer.setState(new WhitespaceState());
			return;
		}
		if(Character.isDigit(c)) {
			// lexer.setState(new DigitState()); // TODO DigitState vorhanden? 
			return; 
		}
		if(c.equals('(') || c.equals(')')) {
			// lexer.setState(new BracketState()); // TODO BracketState vorhanden? 
			return; 
		}
		// In all other cases:
		// if(c is a valid token) lexer.setState(new OperatorState());
		// else lexer.setState(new ErrorState()) (Verarbeitung fehlerhafter Zeichen) 
	}
}
