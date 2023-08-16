package lexer.stateSelection;
import lexer.Lexer;
import lexer.LexerImpl;
import lexer.LexerState;

public class StateSelectionGateway implements StateSelector{
	private StateSelectionLink first;
	public StateSelectionGateway() {
/**
 * Creation of chain - can be varied here!		
 */
		this.first = new WhiteSpaceTester(new DigitTester(new BracketTester(new OperatorTester(new StateSelectionEnding()))));
	}
	public LexerState selectStateFor(Character c, Lexer lexer) {
		return this.first.selectStateFor(c, lexer);
	}
}
