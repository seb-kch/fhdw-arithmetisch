package lexer;
import java.util.List;
import tokens.Token;
public class LexerImpl implements Lexer {
	private LexerState state;				// State Pattern
	private String currentExpression;	// Input 	(reduced during scanning)
	private List<Token> currentResult;	// Output 	(grows during scanning) 
	public LexerImpl() {
		super();
// TODO Initialize attributes 
//		this.currentExpression = ... 	
//		this.currentResult = ...
//		this.state = ...
	}
	public List<Token> toTokenSequence(String expr){ 
	// TODO: As long as currentExpression contains a sign, delegate scanning of next character to this.state
		return this.currentResult; 
	}
/**
 * EFFECTS: 	Deletion of first character of this.currentExpression
 * REQUIRES:	currentExpression.length>0
 */
	public void skip(){
		this.currentExpression = this.currentExpression.substring(1);
	}
	public void setState(LexerState newState){
		this.state = newState;
	}
	public void addToken(Token t) {
		this.currentResult.add(t);
	}
}
