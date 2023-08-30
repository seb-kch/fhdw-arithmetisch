import expressions.NaturalNumber;
import expressions.Sum;
import tokens.NaturalNumberToken;

import java.util.ArrayList;

public class TestConstants {
    // Tokens
    public static final NaturalNumberToken zero = new NaturalNumberToken(0);
    public static final NaturalNumberToken one = new NaturalNumberToken(1);
    public static final NaturalNumberToken two = new NaturalNumberToken(2);
    public static final NaturalNumberToken three = new NaturalNumberToken(3);
    public static final NaturalNumberToken four = new NaturalNumberToken(4);
    public static final NaturalNumberToken five = new NaturalNumberToken(5);
    public static final NaturalNumberToken six = new NaturalNumberToken(6);
    public static final NaturalNumberToken seven = new NaturalNumberToken(7);
    public static final NaturalNumberToken eight = new NaturalNumberToken(8);
    public static final NaturalNumberToken nine = new NaturalNumberToken(9);

    // Natural Numbers
    public static final NaturalNumber nnZero = new NaturalNumber(zero);
    public static final NaturalNumber nnOne = new NaturalNumber(one);
    public static final NaturalNumber nnTwo = new NaturalNumber(two);
    public static final NaturalNumber nnThree = new NaturalNumber(three);
    public static final NaturalNumber nnFour = new NaturalNumber(four);
    public static final NaturalNumber nnFive = new NaturalNumber(five);
    public static final NaturalNumber nnSix = new NaturalNumber(six);
    public static final NaturalNumber nnSeven = new NaturalNumber(seven);
    public static final NaturalNumber nnEight = new NaturalNumber(eight);
    public static final NaturalNumber nnNine = new NaturalNumber(nine);

    // Basic Sums
    public static final Sum onePlusTwo = new Sum(nnOne, nnTwo);
    public static final Sum threePlusFour = new Sum(nnThree, nnFour);
}
