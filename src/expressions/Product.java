package expressions;

import exceptions.CalculationException;
import operators.BinaryOperator;
/**
 * A term of type F*S or F/S
 */
public abstract class Product implements Summand, BinaryTerm {
	private BinaryOperator op;
	public Product(BinaryOperator op) {
		super();
		this.op = op;
	}
	public Integer evaluate() throws CalculationException{
		return this.op.calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
	}
	public <T> T accept(ExpressionVisitor<T> ev) {
		return ev.handle(this);
	}	
	public abstract Summand getArg1();
	public abstract Summand getArg2();
	
	public BinaryOperator getOp() {
		return op;
	}
}
