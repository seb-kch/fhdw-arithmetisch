import expressions.*;
import operator.AdditionOperator;
import operator.MultiplicationOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class EvaluationTest {

    @Test // 3+3 = 6
    void test1() {
        DashTerm dashTerm = new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.three), AdditionOperator.getInstance());
        Integer expected = 6;
        assertEquals(expected, dashTerm.evaluate());
    }
    @Test // 1+0 = 1
    void test2() {
        DashTerm dashTerm = new DashTerm(new NaturalNumber(TestConstants.one), new NaturalNumber(TestConstants.zero),AdditionOperator.getInstance());
        Integer expected = 1;
        assertEquals(expected, dashTerm.evaluate());
    }
    @Test // (3+4) = 7
    void test3() {
        BracketExpression bracketExpression= new BracketExpression(new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance()));
        Integer expected = 7;
        assertEquals(expected, bracketExpression.evaluate());
    }
    @Test // (3+4)*3 = 21
    void test4() {
        PointTerm pointTerm = new PointTerm(new NaturalNumber(TestConstants.three), new BracketExpression(new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance())), MultiplicationOperator.getInstance());
        Integer expected = 21;
        assertEquals(expected, pointTerm.evaluate());
    }
    @Test // 3*4+3 = 15
    void test5() {
        DashTerm dashTerm = new DashTerm(new NaturalNumber(TestConstants.three), new PointTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), MultiplicationOperator.getInstance()), AdditionOperator.getInstance());
        Integer expected = 15;
        assertEquals(expected, dashTerm.evaluate());
    }
}
