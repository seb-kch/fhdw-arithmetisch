package lexer;
import tokens.TokenTable;
/**
 * Processing Operators
 */
public class OperatorState extends LexerState { 
	public OperatorState(Lexer myLexer) {
		super(myLexer);
	}
	public void scan(Character c) {
		this.getMyLexer().skip();
		this.addSymbol(c);
		this.endOfProcessing();
	}
	private void addSymbol(Character c){
		this.getMyLexer().addSymbol(TokenTable.getInstance().get(c));
	}
}
