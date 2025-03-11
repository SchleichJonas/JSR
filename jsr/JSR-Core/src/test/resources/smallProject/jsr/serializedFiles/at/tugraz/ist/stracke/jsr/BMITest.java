package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class BMITest {

    public BMITest() {
    }
    @Test
    public void BMIUnderweightResult() {
        BMI.calculateBMICategory(1.70,30);
        Assert.assertEquals("underweight", BMI.result);
    }
    @Test
    public void BMIUnderweightScore() {
        BMI.calculateBMICategory(1.70,30);
        Assert.assertEquals(10.38062283f, BMI.bmi_score, 0.0001f);
    }

    @Test
    public void BMIHealthyResult() {
        BMI.calculateBMICategory(1.70,60);
        Assert.assertEquals("healthy", BMI.result);
    }
    @Test
    public void BMIHealthyScore() {
        BMI.calculateBMICategory(1.70,60);
        Assert.assertEquals(20.76124567f, BMI.bmi_score, 0.0001f);
    }

    @Test
    public void BMIOverweightResult() {
        BMI.calculateBMICategory(1.70,80);
        Assert.assertEquals("overweight", BMI.result);
    }
    @Test
    public void BMIOverweightScore() {
        BMI.calculateBMICategory(1.70,80);
        Assert.assertEquals(27.6816608f, BMI.bmi_score, 0.0001f);
    }

    @Test
    public void BMIObeseResult() {
        BMI.calculateBMICategory(1.70,100);
        Assert.assertEquals("Obese", BMI.result);
    }
    @Test
    public void BMIObeseScore() {
        BMI.calculateBMICategory(1.70,100);
        Assert.assertEquals(34.6020761f, BMI.bmi_score, 0.0001f);
    }

    @Test
    public void BMIVeryObeseResult() {
        BMI.calculateBMICategory(1.70,150);
        Assert.assertEquals("very obese", BMI.result);
    }
    @Test
    public void BMIVeryObeseScore() {
        BMI.calculateBMICategory(1.70,150);
        Assert.assertEquals(51.903114f, BMI.bmi_score, 0.0001f);
    }

}
