package parser;

import exceptions.ParserException;
import operator.Operator;
import operator.OperatorTable;
import tokens.Token;

public abstract class Parser {
    public Operator getOperator(Token t) throws ParserException {
        return OperatorTable.getInstance().getOperatorFromToken(t);
    }
}
