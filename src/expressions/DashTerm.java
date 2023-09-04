package expressions;

import operator.AdditionOperator;
import operator.Operator;

/**
 * A term of type S+E
 */
// TODO Complete this class
public class DashTerm extends BinaryExpression implements Expression {
    // TODO: Add attributes
    public DashTerm(Summand s, Expression e, Operator op) {
        super(op, s, e);
    }

    public Integer evaluate() {
        // TODO Implement this method
        return this.getOp().calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
    }

    public boolean equals(Object obj) {
        if(obj instanceof DashTerm s) {
           return s.getArg1().equals(this.getArg1()) && s.getArg2().equals(this.getArg2());
        }
        return false;
    }
}
