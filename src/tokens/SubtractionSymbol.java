package tokens;

import basic.TextConstants;

public class SubtractionSymbol implements Token {

    private static SubtractionSymbol theInstance = new SubtractionSymbol();

    private SubtractionSymbol() {}

    public static SubtractionSymbol getTheInstance() {
    return SubtractionSymbol.theInstance;
    }
    public String toString() {
        return TextConstants.SUB.toString();
    }
}
