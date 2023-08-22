package parser;

import java.util.List;

import expressions.BracketExpression;
import expressions.Expression;
import expressions.Factor;
import expressions.NaturalNumber;
import tokens.BracketClose;
import tokens.BracketOpen;
import tokens.NaturalNumberToken;
import tokens.Token;
/**
 * Responsible for parsing expressions of type n (a natural number) or (E)
 */
public class FactorParser {
	Factor toExpression(List<Token> tokenList) { // TODO: Exception Handling
		Token nextToken = tokenList.get(0);
		if(nextToken instanceof NaturalNumberToken) {
			NaturalNumberToken nextTokenAsNaturalNumberToken = (NaturalNumberToken)nextToken;
			return new NaturalNumber(nextTokenAsNaturalNumberToken);
		}	
		if(nextToken instanceof BracketOpen) {
			tokenList.remove(0);
			Expression e = new ExpressionParser().toExpression(tokenList);
			if(tokenList.get(0) instanceof BracketClose) return new BracketExpression(e);
			else 										 return null; // Replace with Exception	
		}
		return null; // Replace with Exception!
	}
}
