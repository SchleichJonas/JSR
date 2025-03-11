package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class BMIJustOneOutputTest {
    public BMIJustOneOutputTest() {
    }

    @Test
    public void bmi() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        double weigth = 60;
        double height = 1.70;
        double heigth_squared = height * height;
        Assert.assertEquals(true, Math.abs(bmi.calculateBMI(height,weigth) - (weigth/heigth_squared)) < 1e-9);
    }

    @Test
    public void BMIUnderweight() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        Assert.assertEquals("underweight", bmi.calculateBMICategory(1.70,30));
    }

    @Test
    public void BMIHealthy() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        Assert.assertEquals("healthy", bmi.calculateBMICategory(1.70,60));
    }

    @Test
    public void BMIOverweight() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        Assert.assertEquals("overweight", bmi.calculateBMICategory(1.70,80));
    }

    @Test
    public void BMIObese() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        Assert.assertEquals("obese", bmi.calculateBMICategory(1.70,100));
    }

    @Test
    public void BMIVeryObese() {
        BMIJustOneOutput bmi = new BMIJustOneOutput();
        Assert.assertEquals("very obese", bmi.calculateBMICategory(1.70,150));
    }

}