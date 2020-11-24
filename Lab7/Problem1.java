package Lab7;

public class Problem1 {
    public static void main(String[] args) {
    BinaryOperation binaryOperation = BinaryEquationParser.parseBinaryOperation("4 + 5");
    binaryOperation.printResult();
    }
}
abstract class BinaryOperation{
    public int operandOne;
    public int operandTwo;
    public char operator;
    public abstract int compute();
    public abstract void printResult();
}
class AddBinaryOperation extends BinaryOperation{
    @Override
    public int compute() {
        return this.operandOne + this.operandTwo;
    }
    @Override
    public void printResult() {
        System.out.println(compute());
    }
}
class SubBinaryOperation extends  BinaryOperation{
    @Override
    public int compute() {

        return this.operandOne - this.operandTwo;
    }

    public void printResult() {
        System.out.println(compute());
    }
}

class MulBinaryOperation extends BinaryOperation{
    @Override
    public int compute() {

        return this.operandOne * this.operandTwo;
    }


    public void printResult() {
        System.out.println(compute());
    }
}
class DivBinaryOperation extends BinaryOperation{
    @Override
    public int compute() {

        return this.operandOne / this.operandTwo;
    }
    @Override
    public void printResult() {
        System.out.println(compute());
    }
}
class BinaryEquationParser {
    public static BinaryOperation parseBinaryOperation(String binOpString){
        int one = Integer.parseInt(Character.toString(binOpString.charAt(0)));
        int two = Integer.parseInt(Character.toString(binOpString.charAt(4)));
        if(binOpString.charAt(2) == '+'){
            AddBinaryOperation addBinaryOperation = new AddBinaryOperation();
            addBinaryOperation.operandOne = one ;
            addBinaryOperation.operandTwo = two;
            addBinaryOperation.operator = binOpString.charAt(2);

            return addBinaryOperation;
        }
        if(binOpString.charAt(2) == '-'){
            SubBinaryOperation subBinaryOperation = new SubBinaryOperation();
            subBinaryOperation.operandOne = one ;
            subBinaryOperation.operandTwo = two;
            subBinaryOperation.operator = binOpString.charAt(2);

            return subBinaryOperation;
        }
        if(binOpString.charAt(2) == '*'){
            MulBinaryOperation mulBinaryOperation = new MulBinaryOperation();
            mulBinaryOperation.operandOne = one;
            mulBinaryOperation.operandTwo= two;
            mulBinaryOperation.operator = binOpString.charAt(2);
            return mulBinaryOperation;
        }
        if(binOpString.charAt(2) == '/'){
            DivBinaryOperation divBinaryOperation = new DivBinaryOperation();
            divBinaryOperation.operandOne = one ;
            divBinaryOperation.operandTwo = two;
            divBinaryOperation.operator = binOpString.charAt(2);

            return divBinaryOperation;
        }
        return null;
    }

}