package parser;

import java.util.List;
import expressions.Summand;
import tokens.Token;

/**
 * Responsible for parsing of expressions of type 
 * F*S or F
 */
public class SummandParser { // TODO: ExceptionHandling
	Summand toExpression(List<Token> tokenList) {
		// TODO: Implement me!
		// Similar to ExpressionParser: 
		// 1. Delegate to FactorParser, result f  
		// 2. If '*' detected, recursive call with result s and 
		//		return new Product(f,s)
		//    else 
		//      return f.
		return null;
	}
}
