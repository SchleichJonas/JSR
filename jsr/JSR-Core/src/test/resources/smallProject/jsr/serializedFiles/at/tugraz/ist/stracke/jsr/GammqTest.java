package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class GammqTest {

    public GammqTest() {
    }
    @Test
    public void gammq1() {
        Gammq.exe(2.5, 7.5);
        Assert.assertEquals(true, Math.abs(Gammq.result - (0.010362337793514904)) < 1e-14);
    }
    @Test
    public void gammq2() {
        Gammq.exe(2.5, 7.5);
        Assert.assertEquals(true, Math.abs(Gammq.gamser - (0.0)) < 1e-14);
    }
    @Test
    public void gammq3() {
        Gammq.exe(2.5, 7.5);
        Assert.assertEquals(true, Math.abs(Gammq.gammcf - (0.010362337793514904)) < 1e-14);
    }
    @Test
    public void gammq4() {
        Gammq.exe(2.5, 7.5);
        Assert.assertEquals(true, Math.abs(Gammq.gln - (0.2846828704729183)) < 1e-14);
    }

    @Test
    public void gammq5() {
        Gammq.exe(10, 5);
        Assert.assertEquals(true, Math.abs(Gammq.result - (0.9681719435010642)) < 1e-14);
    }
    @Test
    public void gammq6() {
        Gammq.exe(10, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gamser - (0.03182805649893585)) < 1e-14);
    }
    @Test
    public void gammq7() {
        Gammq.exe(10, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gammcf - (0.010362337793514904)) < 1e-14);
    }
    @Test
    public void gammq8() {
        Gammq.exe(10, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gln - (12.801827480081961)) < 1e-14);
    }

    @Test
    public void gammq9() {
        Gammq.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Gammq.result - (0.9999999961287697)) < 1e-14);
    }
    @Test
    public void gammq10() {
        Gammq.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Gammq.gamser - (3.871230356694576E-9)) < 1e-14);
    }
    @Test
    public void gammq11() {
        Gammq.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Gammq.gammcf - (0.010362337793514904)) < 1e-14);
    }
    @Test
    public void gammq12() {
        Gammq.exe(15, 2);
        Assert.assertEquals(true, Math.abs(Gammq.gln - (25.191221182742492)) < 1e-14);
    }

    @Test
    public void gammq13() {
        Gammq.exe(3, 20);
        Assert.assertEquals(true, Math.abs(Gammq.result - (4.55514950558922E-7)) < 1e-14);
    }
    @Test
    public void gammq14() {
        Gammq.exe(3, 20);
        Assert.assertEquals(true, Math.abs(Gammq.gamser - (3.871230356694576E-9)) < 0.000001);
    }
    @Test
    public void gammq15() {
        Gammq.exe(3, 20);
        Assert.assertEquals(true, Math.abs(Gammq.gammcf - (4.55514950558922E-7)) < 1e-14);
    }
    @Test
    public void gammq16() {
        Gammq.exe(3, 20);
        Assert.assertEquals(true, Math.abs(Gammq.gln - (0.6931471805599443)) < 1e-14);
    }

    @Test
    public void gammq17() {
        Gammq.exe(5, 5);
        Assert.assertEquals(true, Math.abs(Gammq.result - (0.4404933032717462)) < 1e-14);
    }
    @Test
    public void gammq18() {
        Gammq.exe(5, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gamser - (0.5595066967282538)) < 1e-14);
    }
    @Test
    public void gammq19() {
        Gammq.exe(5, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gammcf - (4.55514950558922E-7)) < 1e-14);
    }
    @Test
    public void gammq20() {
        Gammq.exe(5, 5);
        Assert.assertEquals(true, Math.abs(Gammq.gln - (3.1780538303479453)) < 1e-14);
    }
}