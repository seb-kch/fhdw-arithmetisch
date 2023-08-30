package parser;

import java.util.List;

import exceptions.ParserException;
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
    Factor toExpression(List<Token> tokenList)throws ParserException { // TODO: Exception Handling
        Token nextToken = tokenList.get(0);
        if (nextToken instanceof NaturalNumberToken nextTokenAsNaturalNumberToken) {
            tokenList.remove(0);
            return new NaturalNumber(nextTokenAsNaturalNumberToken);
        }
        if (nextToken instanceof BracketOpen) {
            tokenList.remove(0);
            Expression e = new ExpressionParser().toExpression(tokenList);
            if (tokenList.get(0) instanceof BracketClose) {
                tokenList.remove(0);
                return new BracketExpression(e);
            } else throw new ParserException("No closed Bracket was found");
        }
        throw new ParserException("Invalid Token: " + nextToken.toString()); // Replace with Exception!
    }
}
