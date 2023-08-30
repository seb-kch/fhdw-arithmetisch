package expressions;

import exceptions.CalculationException;

/**
 * The general interface which represents all arithmetic expressions
 */
public interface Expression {
/**	
 * Evaluates this objects
 */
	public Integer evaluate() throws CalculationException;
/**
 * Makes objects visitable
 */
	public <T> T accept(ExpressionVisitor<T> ev) ;
}
