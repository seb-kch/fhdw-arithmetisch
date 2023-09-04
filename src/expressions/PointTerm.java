package expressions;

import operator.MultiplicationOperator;
import operator.Operator;

/**
 * A term of type F*S
 */
// TODO Complete this class
public class PointTerm extends BinaryExpression implements Summand {

    public PointTerm(Factor f, Summand s, Operator op) {
        super(op, f, s);
    }

    public Integer evaluate() {
        return this.getOp().calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
    }

    public boolean equals(Object obj) {
        if (obj instanceof PointTerm p) {
            return p.getArg1().equals(this.getArg1()) && p.getArg2().equals(this.getArg2());
        }
        return false;
    }
}
