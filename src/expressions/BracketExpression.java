package expressions;
/**
 * An expression of type (E)
 */
public class BracketExpression implements Factor {
	private Expression expression;
	public BracketExpression(Expression expression) {
		super();
		this.expression = expression;
	}
	public Expression getExpression() {
		return expression;
	}
	public Integer evaluate() {
		// TODO Auto-generated method stub
		return expression.evaluate();
	}
	public boolean equals(Object obj) {
		if(obj instanceof BracketExpression be) {
			return be.expression.equals(this.expression);
		}
		return false;
	}
}
