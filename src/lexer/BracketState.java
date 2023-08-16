package lexer;

import basic.TextConstants;
import tokens.BracketClose;
import tokens.BracketOpen;
/**
 * Processing brackets: A bracket is always a single character
 */
public class BracketState extends LexerState {
	public BracketState(Lexer myLexer) {
		super(myLexer);
	}
	public void scan(Character c) {
		Lexer s = this.getMyLexer();
		if(c.equals(TextConstants.BRACKETOPEN)) 	s.addSymbol(BracketOpen.getTheInstance());
		if(c.equals(TextConstants.BRACKETCLOSE)) 	s.addSymbol(BracketClose.getTheInstance());
		s.skip();
		this.endOfProcessing();
	}
}
