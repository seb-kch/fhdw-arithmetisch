package expressions;
/**
 * A term of type F*S
 */
// TODO Complete this class
public class Product implements Summand {

	private Factor factor;
	private Summand summand;
	public Product(Factor f, Summand s) {
		this.factor = f;
		this.summand = s;
	}

	public Integer evaluate(){
		return factor.evaluate() * summand.evaluate();
	}
	public boolean equals(Object obj) {
		return obj instanceof Product;
	}
}
