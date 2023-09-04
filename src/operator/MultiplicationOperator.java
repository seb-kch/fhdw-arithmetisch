package operator;

public class MultiplicationOperator implements Operator {
    private static MultiplicationOperator instance = new MultiplicationOperator();

    private MultiplicationOperator() {}

    public static MultiplicationOperator getInstance() {
        return MultiplicationOperator.instance;
    }

    @Override
    public Integer calculate(Integer op1, Integer op2) {
        return op1 * op2;
    }
}
