package lexer.stateSelection;

import basic.TextConstants;
import lexer.BracketState;
import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;

class BracketTester extends StateSelectionLink {
	public BracketTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return TextConstants.isBracket(c);}
	public LexerState myState(Lexer scanner) {return new BracketState(scanner);}
}

