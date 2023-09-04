package operator;

public class AdditionOperator implements Operator {
    private static AdditionOperator instance = new AdditionOperator();

    private AdditionOperator() {}

    public static AdditionOperator getInstance() {
        return AdditionOperator.instance;
    }

    @Override
    public Integer calculate(Integer op1, Integer op2) {
        return op1 + op2;
    }
}
