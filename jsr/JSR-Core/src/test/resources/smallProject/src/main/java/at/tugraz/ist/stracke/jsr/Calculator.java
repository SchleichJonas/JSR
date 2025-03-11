package at.tugraz.ist.stracke.jsr;

public class Calculator {

    private String name;

    public Calculator(String name) {
        this.name = name;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return b != 0 ? a / b : -1;
    }

    public int multiplication(int a, int b)
    {
        int test1 = 1;
        int test2 = 2;
        int test3 = test1 * test2;
        int result = a + b;
        return result;
    }
}
