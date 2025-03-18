package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class FisherJustOneOutput2Test {
    public FisherJustOneOutput2Test() {
    }
    @Test
    public void fisher1() {
        FisherJustOneOutput2 fisher = new FisherJustOneOutput2();
        Assert.assertEquals(true, Math.abs(fisher.exe(5, 10, 2.5) - (0.89799772335573)) < 1e-9);
    }

    @Test
    public void fisher2() {
        FisherJustOneOutput2 fisher = new FisherJustOneOutput2();
        Assert.assertEquals(true, Math.abs(fisher.exe(5, 1, 2) - (0.5110840804563067)) < 1e-9);
    }

    @Test
    public void fisher3() {
        FisherJustOneOutput2 fisher = new FisherJustOneOutput2();
        Assert.assertEquals(true, Math.abs(fisher.exe(5, 3, 1) - (0.4648547900173071)) < 1e-9);
    }

    @Test
    public void fisher4() {
        FisherJustOneOutput2 fisher = new FisherJustOneOutput2();
        Assert.assertEquals(true, Math.abs(fisher.exe(20, 10, 2) - (0.8701603741695998)) < 1e-9);
    }

    @Test
    public void tcasShouldFail5() {
        FisherJustOneOutput2 fisher = new FisherJustOneOutput2();
        Assert.assertEquals(true, Math.abs(fisher.exe(20, 1, 15) - (0.798891780480029)) < 1e-9);
    }

}