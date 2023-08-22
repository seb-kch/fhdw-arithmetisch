package parser;

import java.util.List;

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
public class ExpressionParser { // TODO: Exception Handling
	public Expression toExpression(List<Token> tokenList){
		Summand s = new SummandParser().toExpression(tokenList);
		Token nextToken = tokenList.get(0); // Ok, if precondition is satisfied 
		if(nextToken instanceof AdditionSymbol) {
			tokenList.remove(0);
			return new Sum(s, new ExpressionParser().toExpression(tokenList));
		}else {
			return s;
		}
	}
}
