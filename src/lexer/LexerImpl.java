package lexer;
import java.util.ArrayList;
import java.util.List;

import basic.TextConstants;
import tokens.Token;
public class LexerImpl implements Lexer {
	private LexerState state;			// State Pattern
	private String currentExpression;	// Input 	(reduced during scanning)
	private List<Token> currentResult;	// Output 	(grows during scanning) 
	public LexerImpl() {
		super();
		this.currentExpression = TextConstants.EMPTYWORD;	
		this.currentResult = new ArrayList<Token>();
		this.state = new SelectionState(this); // Start State
	}
	public List<Token> toTokenSequence(String expr){ 
		this.currentResult.clear();
		this.currentExpression = expr;				

// Main Loop with delegation of work to state objects:
		while(this.currentExpression.length()>0) 
			this.state.scan(this.currentExpression.charAt(0));
		
		this.state.onTermination();
		
		return this.currentResult; 
	}
/**	
 * REQUIRES !this.currentExpression.isEmpty()
 * Removes the first character of this.currentExpression
 */
	public void skip(){
		this.currentExpression = this.currentExpression.substring(1);
	}
	public void addSymbol(Token s){
		this.currentResult.add(s);
	}
	public void setState(LexerState newState){
		this.state = newState;
	}
}
