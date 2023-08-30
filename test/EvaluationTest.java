import expressions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class EvaluationTest {

    @Test // 3+3 = 6
    void test1() {
        Sum sum = new Sum(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.three));
        Integer expected = 6;
        assertEquals(expected, sum.evaluate());
    }
    @Test // 1+0 = 1
    void test2() {
        Sum sum = new Sum(new NaturalNumber(TestConstants.one), new NaturalNumber(TestConstants.zero));
        Integer expected = 1;
        assertEquals(expected, sum.evaluate());
    }
    @Test // (3+4) = 7
    void test3() {
        BracketExpression bracketExpression= new BracketExpression(new Sum(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four)));
        Integer expected = 7;
        assertEquals(expected, bracketExpression.evaluate());
    }
    @Test // (3+4)*3 = 21
    void test4() {
        Product product= new Product(new NaturalNumber(TestConstants.three), new BracketExpression(new Sum(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four))));
        Integer expected = 21;
        assertEquals(expected, product.evaluate());
    }
    @Test // 3*4+3 = 15
    void test5() {
        Sum sum= new Sum(new NaturalNumber(TestConstants.three), new Product(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four)));
        Integer expected = 15;
        assertEquals(expected, sum.evaluate());
    }
}
