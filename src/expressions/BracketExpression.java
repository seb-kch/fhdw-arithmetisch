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
		return null;
	}	
}
