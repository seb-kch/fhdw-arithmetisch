package tokens;
public class NaturalNumberToken implements Token {
/**
 * A token carrying a natural number value
 */
	private Integer value;
	public NaturalNumberToken(Integer value) {
		super();
		this.value = value;
	}
	public Integer getValue() {
		return this.value;
	}
	public String toString() {
		return this.value+"";
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof NaturalNumberToken)) return false;
		return ((NaturalNumberToken)obj).value.equals(this.value);
	}
	
}
