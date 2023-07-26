package lexer;

import tokens.TokenTable;

public class OperatorState implements LexerState {
	public void scan(Character c, Lexer lexer) {
		if(TokenTable.getTheInstance().isValid(c)); // ... 
	}
}
