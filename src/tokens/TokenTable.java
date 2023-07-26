package tokens;

import java.util.HashMap;
import java.util.Map;
/**
 * Singleton for maintaining valid tokens
 */
public class TokenTable {
	private static TokenTable theInstance;
	private Map<Character, Token> tokenPerCharacter;
	private TokenTable() {
		this.tokenPerCharacter = new HashMap<>();
		this.fillTable();
	}
	public static TokenTable getTheInstance() {
		if(theInstance==null) theInstance = new TokenTable();
		return theInstance;
	}
	private void fillTable() {
		this.tokenPerCharacter.put('+', new AdditionSymbol());
//		this.tokenPerCharacter.put('*', new MultiplicationSymbol());
//		this.tokenPerCharacter.put('(',  new BracketOpen());
		// MultiplicationSymbol, Brackets, ...
	}
	public boolean isValid(Character c) {
		return this.tokenPerCharacter.containsKey(c);
	}
	public Token getTokenFor(Character c) {
		return this.tokenPerCharacter.get(c);
	}
}
