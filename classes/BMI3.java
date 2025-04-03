

public class BMI3 {

    public static double bmi_score;
    public static String result;
    public static void calculateBMI(double height, double weight) {

        bmi_score = weight / (height * height);
    }

    public static void calculateBMICategory(double height, double weight) {

        calculateBMI(height, weight);
        double bmi = bmi_score;
        if (bmi < 18.5)
            result = "underweight";
        else if (bmi < 25)
            result = "healthy";
        else if (bmi < 30) //else if (bmi < 30)//Error
            result = "overweight";
        else if (bmi < 40)
            result = "obese";
        else
            result = "very obese";
    }
}