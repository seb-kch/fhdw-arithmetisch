package expressions;

import operator.AdditionOperator;
import operator.Operator;

/**
 * A term of type S+E
 */
// TODO Complete this class
public class Sum extends BinaryExpression implements Expression {
    // TODO: Add attributes
    public Sum(Summand s, Expression e) {
        super(AdditionOperator.getInstance(), s, e);
    }

    public Integer evaluate() {
        // TODO Implement this method
        return this.getOp().calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
    }

    public boolean equals(Object obj) {
        if(obj instanceof Sum s) {
           return s.getArg1().equals(this.getArg1()) && s.getArg2().equals(this.getArg2());
        }
        return false;
    }
}
