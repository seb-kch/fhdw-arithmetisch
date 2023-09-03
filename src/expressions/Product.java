package expressions;

import operator.Operator;

/**
 * A term of type F*S
 */
// TODO Complete this class
public abstract class Product implements Summand, BinaryTerm {
	private Operator op;
	public Product(Operator op) {
		super();
		this.op = op;
	}

	public Integer evaluate(){
		return this.op.calculate(this.getArg1().evaluate(), this.getArg2().evaluate());
	}
	public boolean equals(Object obj) {
		return obj instanceof Product;
	}
}
