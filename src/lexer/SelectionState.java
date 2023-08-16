package lexer;

import lexer.stateSelection.StateSelectionGateway;
/**
 * Responsible for determining the next state
 */
public class SelectionState extends LexerState {
	private StateSelectionGateway stateSelector;
	public SelectionState(Lexer myLexer) {
		super(myLexer);
		this.stateSelector = new StateSelectionGateway(); 
	}
	public void scan(Character c) {
		Lexer s = this.getMyLexer();
		s.setState(this.stateSelector.selectStateFor(c, s)); 
		// Instead of a straightforward selection. Not necessary to do it so complicated! 
	}
}
