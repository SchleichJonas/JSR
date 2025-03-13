package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class TcasTest {

    public TcasTest() {
    }

    @Test
    public void tcas1() {
        Tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas.return_value);
    }
    @Test
    public void tcas2() {
        Tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas.alim);
    }
    @Test
    public void tcas3() {
        Tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(500, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas4() {
        Tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas5() {
        Tcas.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas6() {
        Tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(1, Tcas.return_value);
    }
    @Test
    public void tcas7() {
        Tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(640, Tcas.alim);
    }
    @Test
    public void tcas8() {
        Tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(840, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas9() {
        Tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas10() {
        Tcas.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas11() {
        Tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas.return_value);
    }
    @Test
    public void tcas12() {
        Tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas.alim);
    }
    @Test
    public void tcas13() {
        Tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas14() {
        Tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas15() {
        Tcas.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas16() {
        Tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas.return_value);
    }
    @Test
    public void tcas17() {
        Tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas.alim);
    }
    @Test
    public void tcas18() {
        Tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas19() {
        Tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas20() {
        Tcas.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas21() {
        Tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(1, Tcas.return_value);
    }
    @Test
    public void tcas22() {
        Tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(640, Tcas.alim);
    }
    @Test
    public void tcas23() {
        Tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(500, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas24() {
        Tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas25() {
        Tcas.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas26() {
        Tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas.return_value);
    }
    @Test
    public void tcas27() {
        Tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas.alim);
    }
    @Test
    public void tcas28() {
        Tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas29() {
        Tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas30() {
        Tcas.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas31() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(0, Tcas.return_value);
    }
    @Test
    public void tcas32() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(0, Tcas.alim);
    }
    @Test
    public void tcas33() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(1100, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas34() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas35() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }

    @Test
    public void tcas36() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(2, Tcas.return_value);
    }
    @Test
    public void tcas37() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(400, Tcas.alim);
    }
    @Test
    public void tcas38() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(1100, Tcas.inhibit_biased_climb);
    }
    @Test
    public void tcas39() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_climb);
    }
    @Test
    public void tcas40() {
        Tcas.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(false, Tcas.non_crossing_biased_descend);
    }
}
