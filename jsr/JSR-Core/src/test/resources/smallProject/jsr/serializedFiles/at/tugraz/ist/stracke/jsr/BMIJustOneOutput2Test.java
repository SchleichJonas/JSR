package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class BMIJustOneOutput2Test {
    public BMIJustOneOutput2Test() {
    }

    @Test
    public void bmi() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        double weigth = 60;
        double height = 1.70;
        double heigth_squared = height * height;
        Assert.assertEquals(true, Math.abs(bmi.calculateBMI(height,weigth) - (weigth/heigth_squared)) < 1e-9);
    }

    @Test
    public void BMIUnderweight() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        Assert.assertEquals("underweight", bmi.calculateBMICategory(1.70,30));
    }

    @Test
    public void BMIHealthy() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        Assert.assertEquals("healthy", bmi.calculateBMICategory(1.70,60));
    }

    @Test
    public void BMIOverweight() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        Assert.assertEquals("overweight", bmi.calculateBMICategory(1.70,80));
    }

    @Test
    public void BMIObese() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        Assert.assertEquals("obese", bmi.calculateBMICategory(1.70,100));
    }

    @Test
    public void BMIVeryObese() {
        BMIJustOneOutput2 bmi = new BMIJustOneOutput2();
        Assert.assertEquals("very obese", bmi.calculateBMICategory(1.70,150));
    }

}