package lexer;
import tokens.NaturalNumberToken;
/**
 * Digit Processing 
 */
public class DigitState extends LexerState {
    private Integer collectedDigits;
	public DigitState(Lexer myLexer){
		super(myLexer);
		this.collectedDigits = 0;
	}
	public void scan(Character c) {
		if(Character.isDigit(c)){
			this.collectedDigits = 	this.collectedDigits * 10 + Integer.parseInt(c.toString());
			this.getMyLexer().skip();
		}else{
			this.addSymbol();
			this.endOfProcessing();
		}
	}
	public void addSymbol(){
		this.getMyLexer().addSymbol(new NaturalNumberToken(this.collectedDigits));
	}
}
