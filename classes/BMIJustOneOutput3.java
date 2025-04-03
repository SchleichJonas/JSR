

public class BMIJustOneOutput3 {

    public static double calculateBMI(double height, double weight) {

        return weight / (height * height);
    }

    public static String calculateBMICategory(double height, double weight) {

        double bmi = calculateBMI(height, weight);
        if (bmi < 18.5)
            return "underweight";
        else if (bmi < 25)
            return "healthy";
        else if (bmi < 30)
            return "overweight";
        else if (bmi < 40)
            return "obese";
        else
            return "very obese";
    }
}