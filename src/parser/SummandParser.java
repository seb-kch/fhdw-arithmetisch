package parser;

import java.util.List;

import exceptions.ParserException;
import expressions.Factor;
import expressions.PointTerm;
import expressions.Summand;
import operator.Operator;
import tokens.MultiplicationSymbol;
import tokens.Token;

/**
 * Responsible for parsing of expressions of type
 * F*S or F
 */
public class SummandParser extends Parser {
    Summand toExpression(List<Token> tokenList) throws ParserException {
        Factor f = new FactorParser().toExpression(tokenList);
        Token nextToken = tokenList.get(0);
        if (nextToken instanceof MultiplicationSymbol) {
            tokenList.remove(0);
//            return new PointTerm(f, new SummandParser().toExpression(tokenList));
            return createPointTerm(f, this.getOperator(nextToken), new SummandParser().toExpression(tokenList));
        } else {
            return f;
        }
        // TODO: Implement me!
        // Similar to ExpressionParser:
        // 1. Delegate to FactorParser, result f
        // 2. If '*' detected, recursive call with result s and
        //		return new Product(f,s)
        //    else
        //      return f.
    }
    private PointTerm createPointTerm(Factor f, Operator op, Summand s) {
        return new PointTerm(f, s, op);
    }
}
