package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class GCDTest {

  public GCDTest() {
  }

  @Test
  public void test1() {
    GCD gcd = new GCD();
    Assert.assertEquals(6, gcd.main(48, 18));
  }

  @Test
  public void test2() {
    GCD gcd = new GCD();
    Assert.assertEquals(1, gcd.main(101, 103));
  }

  @Test
  public void test3() {
    GCD gcd = new GCD();
    Assert.assertEquals(0, gcd.main(0, 7));
  }

  @Test
  public void test4() {
    GCD gcd = new GCD();
    Assert.assertEquals(14, gcd.main(56, 98));
  }

  @Test
  public void test5() {
    GCD gcd = new GCD();
    Assert.assertEquals(25, gcd.main(100, 25));
  }

  @Test
  public void test6() {
    GCD gcd = new GCD();
    Assert.assertEquals(6, gcd.main(270, 192));
  }

  @Test
  public void test7() {
    GCD gcd = new GCD();
    Assert.assertEquals(17, gcd.main(17, 34));
  }
}
