import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParserException;
import expressions.*;
import facade.ApplicationFacade;
import facade.ApplicationFacadeMock;
import operator.AdditionOperator;
import operator.MultiplicationOperator;
import operator.SubtractionOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parser.ExpressionParserProxy;
import tokens.*;

class ParserTest {
    private List<Token> input;

    private ApplicationFacade facade;

    @BeforeEach
    public void setUp() {
        this.facade = new ApplicationFacadeMock();
        this.input = new ArrayList<>();
    }

    @Test
        // "0"
    void naturalNumberTest() throws ParserException {
        NaturalNumberToken nnToken = new NaturalNumberToken(0);
        this.input.add(nnToken);
        Expression expectedExpression = new NaturalNumber(nnToken);
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"0+0"
    void additionTest1() throws ParserException {
        NaturalNumberToken nnToken = new NaturalNumberToken(0);
        this.input.add(nnToken);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(nnToken);
        Expression expectedExpression = new DashTerm(new NaturalNumber(nnToken), new NaturalNumber(nnToken), AdditionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"3+4"
    void additionTest2() throws ParserException {
        this.input.add(TestConstants.three);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        Expression expectedExpression = new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"3+4+3"
    void additionTest3() throws ParserException {
        this.input.add(TestConstants.three);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.three);
        Expression expectedExpression = new DashTerm(new NaturalNumber(TestConstants.three), new DashTerm(new NaturalNumber(TestConstants.four), new NaturalNumber(TestConstants.three), AdditionOperator.getInstance()), AdditionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"3*4"
    void multiplicationTest1() throws ParserException {
        this.input.add(TestConstants.three);
        this.input.add(MultiplicationSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        Expression expectedExpression = new PointTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), MultiplicationOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"3*4+4"
    void multiplicationTest2() throws ParserException {
        this.input.add(TestConstants.three);
        this.input.add(MultiplicationSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        Expression expectedExpression = new DashTerm(new PointTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), MultiplicationOperator.getInstance()), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"1+2*3"
    void multiplicationTest3() throws ParserException {
        this.input.add(TestConstants.one);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.two);
        this.input.add(MultiplicationSymbol.getTheInstance());
        this.input.add(TestConstants.three);
        Expression expectedExpression = new DashTerm(new NaturalNumber(TestConstants.one), new PointTerm(new NaturalNumber(TestConstants.two), new NaturalNumber(TestConstants.three), MultiplicationOperator.getInstance()), AdditionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"(3+4)"
    void bracketTest1() throws ParserException {
        this.input.add(BracketOpen.getTheInstance());
        this.input.add(TestConstants.three);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        this.input.add(BracketClose.getTheInstance());
        Expression expectedExpression = new BracketExpression(new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance()));
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
        //"(3+4)*3"
    void bracketTest2() throws ParserException {
        this.input.add(BracketOpen.getTheInstance());
        this.input.add(TestConstants.three);
        this.input.add(AdditionSymbol.getTheInstance());
        this.input.add(TestConstants.four);
        this.input.add(BracketClose.getTheInstance());
        this.input.add(MultiplicationSymbol.getTheInstance());
        this.input.add(TestConstants.three);
        Expression expectedExpression = new PointTerm((new BracketExpression(new DashTerm(new NaturalNumber(TestConstants.three), new NaturalNumber(TestConstants.four), AdditionOperator.getInstance()))), new NaturalNumber(TestConstants.three), MultiplicationOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    @Test
    void subtractionTest1() throws ParserException {
        this.input.add(TestConstants.one);
        this.input.add(SubtractionSymbol.getTheInstance());
        this.input.add(TestConstants.one);
        Expression expectedExpression = new DashTerm(TestConstants.nnOne, TestConstants.nnOne, SubtractionOperator.getInstance());
        assertEquals(expectedExpression, new ExpressionParserProxy().toExpression(this.input));
    }

    // Exception Tests
//    @Test
//    void
// TODO Viele mehr Tests
}
