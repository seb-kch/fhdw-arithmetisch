package expressions;

/**
 * A term of type S+E
 */
// TODO Complete this class
public class Sum implements Expression {
    // TODO: Add attributes
    private Summand summand;
    private Expression expression;

    public Sum(Summand s, Expression e) {
        // TODO: Possibly add operator
        this.summand = s;
        this.expression = e;
    }

    public Integer evaluate() {
        // TODO Implement this method
        return summand.evaluate() + expression.evaluate();
    }

    public boolean equals(Object obj) {
        return obj instanceof Sum;
    }
}
