package parser;

import java.util.List;

import expressions.Expression;
import tokens.EndToken;
import tokens.Token;
/**
 * Proxy object for parsing procedure
 */
public class ExpressionParserProxy {
	public Expression toExpression(List<Token> tokenList) {
		tokenList.add(new EndToken());
		return new ExpressionParser().toExpression(tokenList);
	}
}
