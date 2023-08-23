package parser;

import java.util.List;

import expressions.Factor;
import expressions.Summand;
import tokens.MultiplicationSymbol;
import tokens.Token;

/**
 * Responsible for parsing of expressions of type 
 * F*S or F
 */
public class SummandParser { 
	Summand toExpression(List<Token> tokenList) {
		Factor f = new FactorParser().toExpression(tokenList);
		if(tokenList.get(0) instanceof MultiplicationSymbol) {
			// TODO  
			// recursive call with result s and return new Product(f,s)
			return null;
		}else {
			return f;
		}
	}
}
