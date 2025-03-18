package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class Tcas2Test {

    public Tcas2Test() {
    }

    @Test
    public void tcas1() {
        Tcas2.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas2.return_value);
    }
    @Test
    public void tcas2() {
        Tcas2.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas2.alim);
    }
    @Test
    public void tcas3() {
        Tcas2.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(500, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas4() {
        Tcas2.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas5() {
        Tcas2.testMe(700, 1, 1, 800, 200, 1000, 0, 500, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas6() {
        Tcas2.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(1, Tcas2.return_value);
    }
    @Test
    public void tcas7() {
        Tcas2.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(640, Tcas2.alim);
    }
    @Test
    public void tcas8() {
        Tcas2.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(840, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas9() {
        Tcas2.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas10() {
        Tcas2.testMe(800, 1, 1, 1200, 300, 1600, 2, 740, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas11() {
        Tcas2.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas2.return_value);
    }
    @Test
    public void tcas12() {
        Tcas2.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas2.alim);
    }
    @Test
    public void tcas13() {
        Tcas2.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(0, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas14() {
        Tcas2.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas15() {
        Tcas2.testMe(600, 1, 1, 1000, 200, 1100, 3, 600, 600, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas16() {
        Tcas2.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas2.return_value);
    }
    @Test
    public void tcas17() {
        Tcas2.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas2.alim);
    }
    @Test
    public void tcas18() {
        Tcas2.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(0, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas19() {
        Tcas2.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas20() {
        Tcas2.testMe(300, 1, 1, 500, 100, 600, 1, 400, 300, 0, 1, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas21() {
        Tcas2.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(1, Tcas2.return_value);
    }
    @Test
    public void tcas22() {
        Tcas2.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(640, Tcas2.alim);
    }
    @Test
    public void tcas23() {
        Tcas2.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(500, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas24() {
        Tcas2.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas25() {
        Tcas2.testMe(800, 1, 1, 600, 100, 1100, 2, 500, 400, 0, 1, 0);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas26() {
        Tcas2.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas2.return_value);
    }
    @Test
    public void tcas27() {
        Tcas2.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas2.alim);
    }
    @Test
    public void tcas28() {
        Tcas2.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(0, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas29() {
        Tcas2.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas30() {
        Tcas2.testMe(500, 1, 1, 1000, 200, 1500, 2, 600, 500, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas31() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(0, Tcas2.return_value);
    }
    @Test
    public void tcas32() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(0, Tcas2.alim);
    }
    @Test
    public void tcas33() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(1100, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas34() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas35() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1001, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }

    @Test
    public void tcas36() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(2, Tcas2.return_value);
    }
    @Test
    public void tcas37() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(400, Tcas2.alim);
    }
    @Test
    public void tcas38() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(1100, Tcas2.inhibit_biased_climb);
    }
    @Test
    public void tcas39() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_climb);
    }
    @Test
    public void tcas40() {
        Tcas2.testMe(601, 1, 1, 998, 200, 997, 0, 1000, 1101, 0, 2, 1);
        Assert.assertEquals(false, Tcas2.non_crossing_biased_descend);
    }
}
