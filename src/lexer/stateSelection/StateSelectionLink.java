package lexer.stateSelection;

import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;

abstract class StateSelectionLink implements StateSelector{
	private StateSelector successor;
	public StateSelectionLink(StateSelector successor){
		this.successor = successor;
	}
	public abstract boolean myCondition(Character c);
	public abstract LexerState myState(Lexer scanner);

/**	
 * Chain delegation template
 */
	public LexerState selectStateFor(Character c, Lexer scanner) {
		if(myCondition(c)) 	return myState(scanner);
		else				return this.getSuccessor().selectStateFor(c, scanner); 
	}
	public StateSelector getSuccessor() {
		return this.successor;
	}
}
