package facade;

import exceptions.CalculationException;
import exceptions.ParserException;
import expressions.Expression;
/**
 * Atrappe, um die Kommunikation von GUI zu Applikationslogik zu demonstrieren   
 */
public class ApplicationFacadeMock implements ApplicationFacade{
	private static final String infoText = "Communication to Application has to be implemented";
	public Expression checkSyntax(String input) throws ParserException {
		throw new ParserException(infoText);
	}
	public Integer evaluate(String input) throws CalculationException, ParserException {
		throw new ParserException(infoText);
	}
}
