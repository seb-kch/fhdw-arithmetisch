package lexer;
/**
 * Processing Whitespace
 */
public class WhitespaceState extends LexerState{
	public WhitespaceState(Lexer myLexer) {
		super(myLexer);
	}
	public void scan(Character c) {
		this.getMyLexer().skip();
		this.getMyLexer().setState(new SelectionState(this.getMyLexer()));
	}
}
