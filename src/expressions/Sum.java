package expressions;

import exceptions.CalculationException;
import operators.BinaryOperator;

public abstract class Sum  implements BinaryTerm, Expression{
	public abstract Expression getArg1();
	public abstract Expression getArg2();
	private BinaryOperator op;
	public Sum(BinaryOperator op) {
		super();
		this.op = op;
	}	
	public BinaryOperator getOp() {
		return op;
	}
	public Integer evaluate() throws CalculationException{
		return this.op.calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
	}
	public <T> T accept(ExpressionVisitor<T> ev) {
		return ev.handle(this);
	}	
}
