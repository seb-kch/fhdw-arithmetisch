import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import expressions.Expression;
import expressions.NaturalNumber;
import expressions.Sum;
import parser.ExpressionParser;
import tokens.AdditionSymbol;
import tokens.NaturalNumberToken;
import tokens.Token;
class ParserTest {
	private List<Token> input;
	@BeforeEach
	public void setUp() {
		this.input = new ArrayList<>();
	}
	@Test  // "0"
	void test1() {
		NaturalNumberToken nnToken = new NaturalNumberToken(0);
		this.input.add(nnToken);
		Expression expectedExpression = new NaturalNumber(nnToken);
		assertEquals(expectedExpression, new ExpressionParser().toExpression(this.input));
	}
	@Test //"0+0"
	void test2() {
		NaturalNumberToken nnToken = new NaturalNumberToken(0);
		this.input.add(nnToken);
		this.input.add(AdditionSymbol.getTheInstance());
		this.input.add(nnToken);
		Expression expectedExpression = new Sum(new NaturalNumber(nnToken), new NaturalNumber(nnToken));
		assertEquals(expectedExpression, new ExpressionParser().toExpression(this.input));
	}

}
