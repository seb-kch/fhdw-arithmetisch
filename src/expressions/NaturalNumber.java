package expressions;

import tokens.NaturalNumberToken;

public class NaturalNumber implements Factor {
	private tokens.NaturalNumberToken theToken;
	public NaturalNumber(NaturalNumberToken theToken) {
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
		return this.getValue();
	}
	public String toString(){
		return this.theToken.toString();
	}
}
