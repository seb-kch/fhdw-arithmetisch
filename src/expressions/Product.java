package expressions;

import operator.MultiplicationOperator;

/**
 * A term of type F*S
 */
// TODO Complete this class
public class Product extends BinaryExpression implements Summand {

    public Product(Factor f, Summand s) {
        super(MultiplicationOperator.getInstance(), f, s);
    }

    public Integer evaluate() {
        return this.getOp().calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Product p) {
            return p.getArg1().equals(this.getArg1()) && p.getArg2().equals(this.getArg2());
        }
        return false;
    }
}
