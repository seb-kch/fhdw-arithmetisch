package lexer;
/** 
 * Lexer state pattern
 * Each state knows the lexer, whose state it is, by an attribute, i.e. a permanent reference
 * --> scan Operation does not carry formal parameter of type Lexer(Impl)
 */
public abstract class LexerState {
	private Lexer myLexer;
	public LexerState(Lexer myLexer) {
		super();
		this.myLexer = myLexer;
	}

/**
 * May add symbol to current Scanner result depending on <c>, 
 * May erase <c> in input string 
 * May change state    
 */
	public abstract void scan(Character c);
	
// =================================================================
// ================ Auxiliary operations for subclasses ============
// =================================================================	
	protected void endOfProcessing(){
		this.getMyLexer().setState(new SelectionState(this.getMyLexer()));
	}
	protected Lexer getMyLexer(){
		return this.myLexer;
	}
}
