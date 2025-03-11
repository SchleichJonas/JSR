package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class TcasDivisionBy1 {


    public TcasDivisionBy1() {
    }

    @Test
    public void tcas1() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(0, tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0));
    }
    @Test
    public void tcas2() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(1, tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1));
    }
    @Test
    public void tcas3() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(0, tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0));
    }

    @Test
    public void tcas4() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(0, tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1));
    }

    @Test
    public void tcas5() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(1, tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0));
    }

    @Test
    public void tcas6() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(0, tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1));
    }

    @Test
    public void tcasShouldFail() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(0, tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1));
    }

    @Test
    public void tcas7() {
        TcasDivisionBy1 tcas = new TcasDivisionBy1();
        Assert.assertEquals(2, tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1));
    }


}