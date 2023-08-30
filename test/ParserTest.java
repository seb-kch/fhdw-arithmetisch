

import static org.junit.Assert.*;

import org.junit.Test;
import exceptions.CalculationException;
import exceptions.ParserException;
import expressions.Expression;
import expressions.NaturalNumber;
import expressions.ProductLTR;
import expressions.SumLTR;
import facade.ApplicationFacade;
import facade.ApplicationFacadeProductive;
import operators.Multiplication;
import operators.Subtraction;
import parser.AbstractParserFactory;

public class ParserTest {
	private ApplicationFacade facade;
	public ParserTest() {
		this.facade = new ApplicationFacadeProductive();
	}
	@Test
	public void test1() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1+2");
		assertEquals(Integer.valueOf(3), e.evaluate());
	}
	@Test
	public void test1a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1-2");
		assertEquals(Integer.valueOf(-1), e.evaluate());
	}

	@Test
	public void test2() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("0");
		assertEquals(Integer.valueOf(0), e.evaluate());
	}
	@Test
	public void test3() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("9*2");
		assertEquals(Integer.valueOf(18), e.evaluate());
	}
	@Test
	public void test3a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("9/2");
		assertEquals(Integer.valueOf(4), e.evaluate());
	}
	@Test
	public void test4() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("2*(3+4)");
		assertEquals(Integer.valueOf(14), e.evaluate());
	}
	@Test
	public void test4a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("2*(3-4)");
		assertEquals(Integer.valueOf(-2), e.evaluate());
	}
	@Test
	public void test5() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1*(66+99)");
		assertEquals(Integer.valueOf(165), e.evaluate());
	}
	@Test
	public void test5a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1/(66+99)");
		assertEquals(Integer.valueOf(0), e.evaluate());
	}
	@Test
	public void test6() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1+2+3");
		assertEquals(Integer.valueOf(6), e.evaluate());
	}
	@Test
	public void test6a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("1-2-3"); 
		if(AbstractParserFactory.getTheFactory().isLTR())
			assertEquals(Integer.valueOf(-4), e.evaluate());
		else 
			assertEquals(Integer.valueOf(2), e.evaluate());
	}
	@Test
	public void test6b() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("10-7+3"); 
		if(AbstractParserFactory.getTheFactory().isLTR())
			assertEquals(Integer.valueOf(6), e.evaluate());
		else
			assertEquals(Integer.valueOf(0), e.evaluate());
	}
	@Test
	public void test7() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("2*83");
		assertEquals(Integer.valueOf(166), e.evaluate());
	}
	@Test
	public void test8() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("10-7-3");
		if(AbstractParserFactory.getTheFactory().isLTR())
			assertEquals(Integer.valueOf(0), e.evaluate());
		else	
			assertEquals(Integer.valueOf(6), e.evaluate());
	}
	@Test
	public void test9() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("100/10/2");
		if(AbstractParserFactory.getTheFactory().isLTR())
			assertEquals(Integer.valueOf(5), e.evaluate());
		else	
			assertEquals(Integer.valueOf(20), e.evaluate());
	}
	@Test
	public void test9a() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("100/10*2");
		if(AbstractParserFactory.getTheFactory().isLTR())
			assertEquals(Integer.valueOf(20), e.evaluate());
		else	
			assertEquals(Integer.valueOf(5), e.evaluate());
	}
// Special LTR Tests
	@Test
	public void test9b() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("100-10-2");
		if(AbstractParserFactory.getTheFactory().isLTR()) {
			assertTrue(e instanceof SumLTR);
			SumLTR p = (SumLTR)e;
			// Test auf (100-10)-2-Struktur
			assertTrue(p.getOp() instanceof Subtraction);
			assertTrue(p.getArg1() instanceof SumLTR);
			assertTrue(p.getArg2() instanceof NaturalNumber);
			assertEquals(Integer.valueOf(88), e.evaluate());
		}else	
			assertEquals(Integer.valueOf(92), e.evaluate());
	}
	@Test
	public void test9c() throws ParserException, CalculationException {
		Expression e = facade.checkSyntax("100/10*2");
		if(AbstractParserFactory.getTheFactory().isLTR()) {
			assertTrue(e instanceof ProductLTR);
			ProductLTR p = (ProductLTR)e;
			// Test auf (100/10)*2-Struktur
			assertTrue(p.getOp() instanceof Multiplication);
			assertTrue(p.getArg1() instanceof ProductLTR);
			assertTrue(p.getArg2() instanceof NaturalNumber);
			assertEquals(Integer.valueOf(20), e.evaluate());
		}else	
			assertEquals(Integer.valueOf(5), e.evaluate());
	}
	@Test
	public void test10(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax(""));
	}
	@Test
	public void test11(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax("1+"));
	}
	@Test
	public void test12(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax("x"));
	}
	@Test
	public void test13(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax("+1"));
	}
	@Test
	public void test14() {
		assertThrows(ParserException.class, ()-> facade.checkSyntax("1*2*"));
	}
	@Test
	public void test15() {
		assertThrows(ParserException.class, ()-> facade.checkSyntax("1*(3+8"));
	}
	@Test
	public void test16(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax("2*7)"));
	}
	@Test
	public void test17(){
		assertThrows(ParserException.class, ()-> facade.checkSyntax("-"));
	}
	@Test
	public void test18() throws ParserException{
		assertNotNull(facade.checkSyntax("1/0"));
	}
	@Test
	public void test19(){
		assertThrows(CalculationException.class, ()->facade.evaluate("1/0"));
	}
}
