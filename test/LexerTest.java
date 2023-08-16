
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lexer.Lexer;
import lexer.LexerImpl;
import tokens.AdditionSymbol;
import tokens.BracketClose;
import tokens.BracketOpen;
import tokens.ErrorToken;
import tokens.MultiplicationSymbol;
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
		List<Token> result = lexer.toTokenSequence("1");
		List<Token> expected = new ArrayList<>(); 
		expected.add(new NaturalNumberToken(1));
		assertEquals(expected, result);
	}
	@Test
	void test2() {
		List<Token> result = lexer.toTokenSequence("1 + 2");
		List<Token> expected = new ArrayList<>(); 
		expected.add(new NaturalNumberToken(1));
		expected.add(AdditionSymbol.getTheInstance());
		expected.add(new NaturalNumberToken(2));
		assertEquals(expected, result);
	}
	@Test
	void test3() {
		List<Token> result = lexer.toTokenSequence("1 * 2");
		List<Token> expected = new ArrayList<>(); 
		expected.add(new NaturalNumberToken(1));
		expected.add(MultiplicationSymbol.getTheInstance());
		expected.add(new NaturalNumberToken(2));
		assertEquals(expected, result);
	}
	@Test
	void test4() {
		List<Token> result = lexer.toTokenSequence("X");
		List<Token> expected = new ArrayList<>(); 
		expected.add(new ErrorToken("X"));
		assertEquals(expected, result);
	}
	@Test
	void test5() {
		List<Token> result = lexer.toTokenSequence("X + 1 Y");
		List<Token> expected = new ArrayList<>(); 
		expected.add(new ErrorToken("X"));
		expected.add(AdditionSymbol.getTheInstance());
		expected.add(new NaturalNumberToken(1));
		expected.add(new ErrorToken("Y"));
		assertEquals(expected, result);
	}
	@Test
	void test6() {
		List<Token> result = lexer.toTokenSequence("(1 + 2)*3");
		List<Token> expected = new ArrayList<>();
		expected.add(BracketOpen.getTheInstance());
		expected.add(new NaturalNumberToken(1));
		expected.add(AdditionSymbol.getTheInstance());
		expected.add(new NaturalNumberToken(2));
		expected.add(BracketClose.getTheInstance());
		expected.add(MultiplicationSymbol.getTheInstance());
		expected.add(new NaturalNumberToken(3));
		assertEquals(expected, result);
	}
	@Test
	void test7() {
		List<Token> result = lexer.toTokenSequence("1001");
		List<Token> expected = new ArrayList<>();
		expected.add(new NaturalNumberToken(1001));
		assertEquals(expected, result);
	}
	@Test
	void test8() {
		List<Token> result = lexer.toTokenSequence("007");
		List<Token> expected = new ArrayList<>();
		expected.add(new NaturalNumberToken(7));
		assertEquals(expected, result);
	}
	@Test
	void test9() {
		List<Token> result = lexer.toTokenSequence("701     89");
		List<Token> expected = new ArrayList<>();
		expected.add(new NaturalNumberToken(701));
		expected.add(new NaturalNumberToken(89));
		assertEquals(expected, result);
	}
	@Test
	void test10() {
		List<Token> result = lexer.toTokenSequence("())");
		List<Token> expected = new ArrayList<>();
		expected.add(BracketOpen.getTheInstance());
		expected.add(BracketClose.getTheInstance());
		expected.add(BracketClose.getTheInstance());
		assertEquals(expected, result);
	}
}
