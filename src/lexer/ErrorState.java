package lexer;
import tokens.ErrorToken;
/**
 * Produces an error token, if unknown characters are detected
 */
public class ErrorState extends LexerState {
	public ErrorState(Lexer myLexer) {
		super(myLexer);
	}
	public void scan(Character c) {
		this.getMyLexer().addSymbol(new ErrorToken(c.toString()));
		this.getMyLexer().skip();
		this.endOfProcessing();
	}
}
