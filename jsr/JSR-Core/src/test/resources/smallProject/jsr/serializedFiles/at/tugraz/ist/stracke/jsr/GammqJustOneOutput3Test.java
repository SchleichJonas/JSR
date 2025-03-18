package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class GammqJustOneOutput3Test {
    public GammqJustOneOutput3Test() {
    }
    @Test
    public void gammq1() {
        GammqJustOneOutput3 gammq = new GammqJustOneOutput3();
        Assert.assertEquals(true, Math.abs(gammq.exe(2.5, 7.5) - (0.010362337793514904)) < 1e-9);
    }
    @Test
    public void gammq2() {
        GammqJustOneOutput3 gammq = new GammqJustOneOutput3();
        Assert.assertEquals(true, Math.abs(gammq.exe(10, 5) - (0.9681719435010642)) < 1e-9);
    }
    @Test
    public void gammq3() {
        GammqJustOneOutput3 gammq = new GammqJustOneOutput3();
        Assert.assertEquals(true, Math.abs(gammq.exe(15, 2) - (0.9999999961287697)) < 1e-9);
    }
    @Test
    public void gammq4() {
        GammqJustOneOutput3 gammq = new GammqJustOneOutput3();
        Assert.assertEquals(true, Math.abs(gammq.exe(3, 20) - (4.55514950558922e-7)) < 1e-9);
    }
    @Test
    public void gammq5() {
        GammqJustOneOutput3 gammq = new GammqJustOneOutput3();
        Assert.assertEquals(true, Math.abs(gammq.exe(5, 5) - (0.4404933032717462)) < 1e-9);
    }

}