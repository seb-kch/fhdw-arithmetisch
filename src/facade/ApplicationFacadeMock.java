package facade;

import exceptions.CalculationException;
import exceptions.ParserException;
import expressions.Expression;
import lexer.Lexer;
import lexer.LexerImpl;
import parser.ExpressionParserProxy;

public class ApplicationFacadeMock implements ApplicationFacade {
	public Expression checkSyntax(String input) throws ParserException {
		Lexer lexer = new LexerImpl();
		ExpressionParserProxy expressionParserProxy = new ExpressionParserProxy();
		return expressionParserProxy.toExpression(lexer.toTokenSequence(input));
	}
	public Integer evaluate(String input) throws CalculationException, ParserException {
		return this.checkSyntax(input).evaluate();
	}
}
