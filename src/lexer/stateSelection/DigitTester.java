package lexer.stateSelection;

import lexer.DigitState;
import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;

class DigitTester extends StateSelectionLink {
	public DigitTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return Character.isDigit(c);}
	public LexerState myState(Lexer scanner) {return new DigitState(scanner);}
}
