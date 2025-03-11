package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class FisherTest {

    public FisherTest() {
    }
    @Test
    public void fisher1() {
        Fisher.exe(5, 10, 2.5);
        Assert.assertEquals(true, Math.abs(Fisher.result - (0.89799772335573)) < 1e-9);
    }
    @Test
    public void fisher2() {
        Fisher.exe(5, 10, 2.5);
        Assert.assertEquals(true, Math.abs(Fisher.p - (0.89799772335573)) < 1e-14);
    }
    @Test
    public void fisher1a() {
        Fisher.exe(5, 10, 2.5);
        Assert.assertEquals(1, Fisher.a);
    }
    @Test
    public void fisher1b() {
        Fisher.exe(5, 10, 2.5);
        Assert.assertEquals(8, Fisher.b);
    }

    @Test
    public void fisher3() {
        Fisher.exe(5, 1, 2);
        Assert.assertEquals(true, Math.abs(Fisher.result - (0.5110840804563067)) < 1e-14);
    }
    @Test
    public void fisher4() {
        Fisher.exe(5, 1, 2);
        Assert.assertEquals(true, Math.abs(Fisher.p - (0.5110840804563067)) < 1e-14);
    }
    @Test
    public void fisher2a() {
        Fisher.exe(5, 1, 2);
        Assert.assertEquals(1, Fisher.a);
    }
    @Test
    public void fisher2b() {
        Fisher.exe(5, 1, 2);
        Assert.assertEquals(-1, Fisher.b);
    }

    @Test
    public void fisher5() {
        Fisher.exe(5, 3, 1);
        Assert.assertEquals(true, Math.abs(Fisher.result - (0.4648547900173071)) < 1e-14);
    }
    @Test
    public void fisher6() {
        Fisher.exe(5, 3, 1);
        Assert.assertEquals(true, Math.abs(Fisher.p - (0.4648547900173071)) < 1e-14);
    }
    @Test
    public void fisher3a() {
        Fisher.exe(5, 3, 1);
        Assert.assertEquals(1, Fisher.a);
    }
    @Test
    public void fisher3b() {
        Fisher.exe(5, 3, 1);
        Assert.assertEquals(1, Fisher.b);
    }

    @Test
    public void fisher7() {
        Fisher.exe(20, 10, 2);
        Assert.assertEquals(true, Math.abs(Fisher.result - (0.8701603741695998)) < 1e-14);
    }
    @Test
    public void fisher8() {
        Fisher.exe(20, 10, 2);
        Assert.assertEquals(true, Math.abs(Fisher.p - (0.8701603741695998)) < 1e-14);
    }
    @Test
    public void fisher4a() {
        Fisher.exe(20, 10, 2);
        Assert.assertEquals(2, Fisher.a);
    }
    @Test
    public void fisher4b() {
        Fisher.exe(20, 10, 2);
        Assert.assertEquals(8, Fisher.b);
    }

    @Test
    public void fisher9() {
        Fisher.exe(20, 1, 15);
        Assert.assertEquals(true, Math.abs(Fisher.result - (0.798891780480029)) < 1e-14);
    }
    @Test
    public void fisher10() {
        Fisher.exe(20, 1, 15);
        Assert.assertEquals(true, Math.abs(Fisher.p - (0.798891780480029)) < 1e-14);
    }
    @Test
    public void fisher5a() {
        Fisher.exe(20, 1, 15);
        Assert.assertEquals(2, Fisher.a);
    }
    @Test
    public void fisher5b() {
        Fisher.exe(20, 1, 15);
        Assert.assertEquals(-1, Fisher.b);
    }
}
