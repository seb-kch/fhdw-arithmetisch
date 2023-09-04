package operator;

import basic.TextConstants;
import exceptions.ParserException;
import tokens.AdditionSymbol;
import tokens.MultiplicationSymbol;
import tokens.SubtractionSymbol;
import tokens.Token;

import java.util.HashMap;
import java.util.Map;

public class OperatorTable {
    private static OperatorTable instance = new OperatorTable();
    private Map<Token, Operator> map;

    private OperatorTable() {
        this.map = new HashMap<>();
        this.createMap();
    }

    public static OperatorTable getInstance() {
        return OperatorTable.instance;
    }

    private void createMap() {
        this.map.put(AdditionSymbol.getTheInstance(), AdditionOperator.getInstance());
        this.map.put(MultiplicationSymbol.getTheInstance(), MultiplicationOperator.getInstance());
        this.map.put(SubtractionSymbol.getTheInstance(), SubtractionOperator.getInstance());
    }

    public boolean isInMap(Token t) {
        return this.map.containsKey(t);
    }

    public Operator getOperatorFromToken(Token t) throws ParserException {
        if (isInMap(t)) {
            return this.map.get(t);
        }
        throw new ParserException(TextConstants.NOTAVALIDTOKEN);
    }
}
