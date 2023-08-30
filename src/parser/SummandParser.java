package parser;

import java.util.List;

import expressions.Factor;
import expressions.Product;
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
        if (tokenList.get(0) instanceof MultiplicationSymbol multiplicationSymbol) {
            tokenList.remove(0);
            return new Product(f, new SummandParser().toExpression(tokenList));
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
}
