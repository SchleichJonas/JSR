package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class LCMTest {

  public LCMTest() {
  }

  @Test
  public void test1() {
    LCM lcm = new LCM();
    Assert.assertEquals(144, lcm.main(48, 18));
  }

  @Test
  public void test2() {
    LCM lcm = new LCM();
    Assert.assertEquals(10403, lcm.main(101, 103));
  }

  @Test
  public void test3() {
    LCM lcm = new LCM();
    Assert.assertEquals(0, lcm.main(0, 7));
  }

  @Test
  public void test4() {
    LCM lcm = new LCM();
    Assert.assertEquals(392, lcm.main(56, 98));
  }

  @Test
  public void test5() {
    LCM lcm = new LCM();
    Assert.assertEquals(100, lcm.main(100, 25));
  }

  @Test
  public void test6() {
    LCM lcm = new LCM();
    Assert.assertEquals(8640, lcm.main(270, 192));
  }

  @Test
  public void test7() {
    LCM lcm = new LCM();
    Assert.assertEquals(34, lcm.main(17, 34));
  }
}
