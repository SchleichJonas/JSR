package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class MultTest {

  public MultTest() {
  }

  @Test
  public void test1() {
    Mult mult = new Mult();
    Assert.assertEquals(12, mult.main(3, 4));
  }

  @Test
  public void test2() {
    Mult mult = new Mult();
    Assert.assertEquals(56, mult.main(7, 8));
  }

  @Test
  public void test3() {
    Mult mult = new Mult();
    Assert.assertEquals(0, mult.main(0, 5));
  }

  @Test
  public void test4() {
    Mult mult = new Mult();
    Assert.assertEquals(9, mult.main(9, 1));
  }

  @Test
  public void test5() {
    Mult mult = new Mult();
    Assert.assertEquals(-24, mult.main(-6, 4));
  }

  @Test
  public void test6() {
    Mult mult = new Mult();
    Assert.assertEquals(21, mult.main(-3, -7));
  }

  @Test
  public void test7() {
    Mult mult = new Mult();
    Assert.assertEquals(0, mult.main(15, 0));
  }
}
