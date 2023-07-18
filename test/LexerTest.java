
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lexer.Lexer;
import lexer.LexerImpl;
import tokens.AdditionSymbol;
import tokens.NaturalNumberToken;
import tokens.Token;

class LexerTest {
	private Lexer lexer;
	@BeforeEach
	void setUp() throws Exception {
		lexer = new LexerImpl();
	}
	@Test
	void test1() {
		List<Token> result = lexer.toTokenSequence("1 + 2");
		List<Token> expected = List.of(new NaturalNumberToken(1), new AdditionSymbol(), new NaturalNumberToken(2));
		assertEquals(expected, result);
	}
}
