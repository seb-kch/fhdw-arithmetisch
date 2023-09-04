package operator;

public class SubtractionOperator implements Operator {
    private static SubtractionOperator instance = new SubtractionOperator();

    private SubtractionOperator() {}

    public static SubtractionOperator getInstance() {
        return SubtractionOperator.instance;
    }

    @Override
    public Integer calculate(Integer op1, Integer op2) {
        return op1 - op2;
    }
}
