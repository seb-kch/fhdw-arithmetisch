package parser;

import java.util.List;

import exceptions.ParserException;
import expressions.Expression;
import expressions.Sum;
import expressions.Summand;
import tokens.AdditionSymbol;
import tokens.Token;

/**
 * Responsible for parsing expressions of type 
 * S+E or S
 * 
 * REQUIRES: !tokenList.isEmpty()  
 */
public class ExpressionParser {
	public Expression toExpression(List<Token> tokenList) throws ParserException {
		Summand s = new SummandParser().toExpression(tokenList);
		Token nextToken = tokenList.get(0);  
		if(nextToken instanceof AdditionSymbol) {
			tokenList.remove(0);
			return new Sum(s, new ExpressionParser().toExpression(tokenList));
		}else {
			return s;
		}
	}
}
