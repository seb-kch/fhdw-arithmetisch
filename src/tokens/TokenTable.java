package tokens;

import java.util.HashMap;
import java.util.Map;

import basic.TextConstants;
/**
 * Singleton to define valid operator symbols
 */
public class TokenTable {
	private static TokenTable instance = new TokenTable();
	private Map<Character, Token> symbols; 
	private TokenTable(){this.fillSymbolMap();}
	
	public static TokenTable getInstance(){return instance;}
	public boolean exists(Character key){return this.symbols.containsKey(key);}
	public Token get(Character key){return this.symbols.get(key);}
	private void fillSymbolMap(){
		this.symbols = new HashMap<Character, Token>();
		this.symbols.put(TextConstants.BRACKETOPEN, BracketOpen.getTheInstance());
		this.symbols.put(TextConstants.BRACKETCLOSE, BracketClose.getTheInstance());
		this.symbols.put(TextConstants.ADD, AdditionSymbol.getTheInstance());
		this.symbols.put(TextConstants.MULTIPLY, MultiplicationSymbol.getTheInstance());
	}
}
