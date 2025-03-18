package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class BMI3Test {

    public BMI3Test() {
    }
    @Test
    public void BMIUnderweightResult() {
        BMI3.calculateBMICategory(1.70,30);
        Assert.assertEquals("underweight", BMI3.result);
    }
    @Test
    public void BMIUnderweightScore() {
        BMI3.calculateBMICategory(1.70,30);
        Assert.assertEquals(10.38062283f, BMI3.bmi_score, 0.0001f);
    }

    @Test
    public void BMIHealthyResult() {
        BMI3.calculateBMICategory(1.70,60);
        Assert.assertEquals("healthy", BMI3.result);
    }
    @Test
    public void BMIHealthyScore() {
        BMI3.calculateBMICategory(1.70,60);
        Assert.assertEquals(20.76124567f, BMI3.bmi_score, 0.0001f);
    }

    @Test
    public void BMIOverweightResult() {
        BMI3.calculateBMICategory(1.70,80);
        Assert.assertEquals("overweight", BMI3.result);
    }
    @Test
    public void BMIOverweightScore() {
        BMI3.calculateBMICategory(1.70,80);
        Assert.assertEquals(27.6816608f, BMI3.bmi_score, 0.0001f);
    }

    @Test
    public void BMIObeseResult() {
        BMI3.calculateBMICategory(1.70,100);
        Assert.assertEquals("Obese", BMI3.result);
    }
    @Test
    public void BMIObeseScore() {
        BMI3.calculateBMICategory(1.70,100);
        Assert.assertEquals(34.6020761f, BMI3.bmi_score, 0.0001f);
    }

    @Test
    public void BMIVeryObeseResult() {
        BMI3.calculateBMICategory(1.70,150);
        Assert.assertEquals("very obese", BMI3.result);
    }
    @Test
    public void BMIVeryObeseScore() {
        BMI3.calculateBMICategory(1.70,150);
        Assert.assertEquals(51.903114f, BMI3.bmi_score, 0.0001f);
    }

}
