package lexer.stateSelection;

import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;
import lexer.WhitespaceState;

class WhiteSpaceTester extends StateSelectionLink {
	public WhiteSpaceTester(StateSelector successor) {
		super(successor);
	}
	public boolean myCondition(Character c) {return Character.isWhitespace(c);}
	public LexerState myState(Lexer scanner) {return new WhitespaceState(scanner);}
}
