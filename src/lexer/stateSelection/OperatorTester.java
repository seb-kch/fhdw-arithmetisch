package lexer.stateSelection;

import lexer.Lexer;
import lexer.LexerImpl;
import lexer.OperatorState;
import lexer.LexerState;
import tokens.TokenTable;

class OperatorTester extends StateSelectionLink {
	public OperatorTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return TokenTable.getInstance().exists(c);}
	public LexerState myState(Lexer lexer) 	{return new OperatorState(lexer);}
}
