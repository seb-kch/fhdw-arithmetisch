package facade;

import exceptions.CalculationException;
import exceptions.ParserException;
import expressions.Expression;
import expressions.NaturalNumber;
import tokens.NaturalNumberToken;
/**
 * Attrappe, um die Kommunikation von GUI zu Applikationslogik zu demonstrieren   
 */
public class ApplicationFacadeMock implements ApplicationFacade{
	public Expression checkSyntax(String input) throws ParserException {
		return new NaturalNumber(new NaturalNumberToken(0));
	}
	public Integer evaluate(String input) throws CalculationException, ParserException {
		return 0;
	}

}
