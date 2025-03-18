package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class Gammq2Test {

    public Gammq2Test() {
    }
    @Test
    public void gammq1() {
        Gammq2.exe(2.5, 7.5);
        Assert.assertEquals(0.010362337793514904, Gammq2.result, 1e-16);
    }
    @Test
    public void gammq2() {
        Gammq2.exe(2.5, 7.5);
        Assert.assertEquals(0.0, Gammq2.gamser, 1e-16);
    }
    @Test
    public void gammq3() {
        Gammq2.exe(2.5, 7.5);
        Assert.assertEquals(0.010362337793514904, Gammq2.gammcf, 1e-16);
    }
    @Test
    public void gammq4() {
        Gammq2.exe(2.5, 7.5);
        Assert.assertEquals(0.2846828704729183, Gammq2.gln, 1e-16);
    }

    @Test
    public void gammq5() {
        Gammq2.exe(10, 5);
        Assert.assertEquals(0.9681719435010642, Gammq2.result, 1e-16);
    }
    @Test
    public void gammq6() {
        Gammq2.exe(10, 5);
        Assert.assertEquals(0.03182805649893585, Gammq2.gamser, 1e-16);
    }
    @Test
    public void gammq7() {
        Gammq2.exe(10, 5);
        Assert.assertEquals(0.0, Gammq2.gammcf, 1e-16);
    }
    @Test
    public void gammq8() {
        Gammq2.exe(10, 5);
        Assert.assertEquals(12.801827480081961, Gammq2.gln, 1e-16);
    }

    @Test
    public void gammq9() {
        Gammq2.exe(15, 2);
        Assert.assertEquals(0.9999999961287697, Gammq2.result, 1e-16);
    }
    @Test
    public void gammq10() {
        Gammq2.exe(15, 2);
        Assert.assertEquals(3.871230356694576e-09, Gammq2.gamser, 1e-16);
    }
    @Test
    public void gammq11() {
        Gammq2.exe(15, 2);
        Assert.assertEquals(0.0, Gammq2.gammcf, 1e-16);
    }
    @Test
    public void gammq12() {
        Gammq2.exe(15, 2);
        Assert.assertEquals(25.191221182742492, Gammq2.gln, 1e-16);
    }

    @Test
    public void gammq13() {
        Gammq2.exe(3, 20);
        Assert.assertEquals(4.55514950558922e-07, Gammq2.result, 1e-16);
    }
    @Test
    public void gammq14() {
        Gammq2.exe(3, 20);
        Assert.assertEquals(0.0, Gammq2.gamser, 1e-16);
    }
    @Test
    public void gammq15() {
        Gammq2.exe(3, 20);
        Assert.assertEquals(4.55514950558922e-07, Gammq2.gammcf, 1e-16);
    }
    @Test
    public void gammq16() {
        Gammq2.exe(3, 20);
        Assert.assertEquals(0.6931471805599443, Gammq2.gln, 1e-16);
    }

    @Test
    public void gammq17() {
        Gammq2.exe(5, 5);
        Assert.assertEquals(0.4404933032717462, Gammq2.result, 1e-16);
    }
    @Test
    public void gammq18() {
        Gammq2.exe(5, 5);
        Assert.assertEquals(0.5595066967282538, Gammq2.gamser, 1e-16);
    }
    @Test
    public void gammq19() {
        Gammq2.exe(5, 5);
        Assert.assertEquals(0.0, Gammq2.gammcf, 1e-16);
    }
    @Test
    public void gammq20() {
        Gammq2.exe(5, 5);
        Assert.assertEquals(3.1780538303479453, Gammq2.gln, 1e-16);
    }
}