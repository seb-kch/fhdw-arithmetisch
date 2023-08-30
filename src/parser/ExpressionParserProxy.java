package parser;

import exceptions.ParserException;
import expressions.Expression;
import tokens.EndToken;
import tokens.Token;

import java.util.List;

/**
 * Proxy Object for parsing procedure
 */
public class ExpressionParserProxy {
    public Expression toExpression(List<Token> tokenList) throws ParserException {
        tokenList.add(new EndToken());
        return new ExpressionParser().toExpression(tokenList);
    }
}
