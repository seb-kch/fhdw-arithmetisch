package parser;

import java.util.List;

import exceptions.ParserException;
import expressions.Expression;
import expressions.DashTerm;
import expressions.Summand;
import operator.Operator;
import operator.OperatorTable;
import tokens.AdditionSymbol;
import tokens.SubtractionSymbol;
import tokens.Token;

/**
 * Responsible for parsing expressions of type 
 * S+E or S
 * 
 * REQUIRES: !tokenList.isEmpty()  
 */
public class ExpressionParser extends Parser {
	public Expression toExpression(List<Token> tokenList) throws ParserException {
		Summand s = new SummandParser().toExpression(tokenList);
		Token nextToken = tokenList.get(0);  
		if(nextToken instanceof AdditionSymbol | nextToken instanceof SubtractionSymbol) {
			tokenList.remove(0);
//			return new DashTerm(s, new ExpressionParser().toExpression(tokenList));
			return createDashTerm(s, this.getOperator(nextToken), new ExpressionParser().toExpression(tokenList));
		}else {
			return s;
		}
	}
	private DashTerm createDashTerm(Summand s, Operator op, Expression e) {
		return new DashTerm(s,e,op);
	}
}
