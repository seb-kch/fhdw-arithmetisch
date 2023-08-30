package expressions;
public class NaturalNumber implements Factor {
	private tokens.NaturalNumberToken theToken;
	public NaturalNumber(tokens.NaturalNumberToken theToken) {
		super();
		this.theToken = theToken;
	}
	public Integer getValue() {
		return this.theToken.getValue();
	}
	public boolean equals(Object o){
		if(!(o instanceof NaturalNumber)) return false; 
		return this.theToken.equals(((NaturalNumber)o).theToken); 
	}
	public Integer evaluate() {
		return this.theToken.getValue();
	}
	public String toString(){
		return this.theToken.toString();
	}
	public <T> T accept(ExpressionVisitor<T> ev) {
		return ev.handle(this);
	}	
}
