

public class FooAltered {
    public static double calc(double length, String type) {
        double result = -1;
        if(type.equals("square")) {
            double area = length + length;
            double perimeter = 4 * length;
            result = area;
        }else if(type.equals("cube")) {
            double volume = length * length * length;
            result = volume;
        }
        return result;
    }
}