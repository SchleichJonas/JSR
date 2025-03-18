package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class BMI2Test {

    public BMI2Test() {
    }
    @Test
    public void BMIUnderweightResult() {
        BMI2.calculateBMICategory(1.70,30);
        Assert.assertEquals("underweight", BMI2.result);
    }
    @Test
    public void BMIUnderweightScore() {
        BMI2.calculateBMICategory(1.70,30);
        Assert.assertEquals(10.38062283f, BMI2.bmi_score, 0.0001f);
    }

    @Test
    public void BMIHealthyResult() {
        BMI2.calculateBMICategory(1.70,60);
        Assert.assertEquals("healthy", BMI2.result);
    }
    @Test
    public void BMIHealthyScore() {
        BMI2.calculateBMICategory(1.70,60);
        Assert.assertEquals(20.76124567f, BMI2.bmi_score, 0.0001f);
    }

    @Test
    public void BMIOverweightResult() {
        BMI2.calculateBMICategory(1.70,80);
        Assert.assertEquals("overweight", BMI2.result);
    }
    @Test
    public void BMIOverweightScore() {
        BMI2.calculateBMICategory(1.70,80);
        Assert.assertEquals(27.6816608f, BMI2.bmi_score, 0.0001f);
    }

    @Test
    public void BMIObeseResult() {
        BMI2.calculateBMICategory(1.70,100);
        Assert.assertEquals("Obese", BMI2.result);
    }
    @Test
    public void BMIObeseScore() {
        BMI2.calculateBMICategory(1.70,100);
        Assert.assertEquals(34.6020761f, BMI2.bmi_score, 0.0001f);
    }

    @Test
    public void BMIVeryObeseResult() {
        BMI2.calculateBMICategory(1.70,150);
        Assert.assertEquals("very obese", BMI2.result);
    }
    @Test
    public void BMIVeryObeseScore() {
        BMI2.calculateBMICategory(1.70,150);
        Assert.assertEquals(51.903114f, BMI2.bmi_score, 0.0001f);
    }

}
