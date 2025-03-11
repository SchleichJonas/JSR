package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class SqrtTest {

  public SqrtTest() {
  }

  @Test
  public void test1() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(2, sqrt.main(4));
  }

  @Test
  public void test2() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(3, sqrt.main(10));
  }

  @Test
  public void test3() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(4, sqrt.main(16));
  }

  @Test
  public void test4() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(5, sqrt.main(25));
  }

  @Test
  public void test5() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(-50, sqrt.main(0));
  }

  @Test
  public void test6() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(1, sqrt.main(1));
  }

  @Test
  public void test7() {
    Sqrt sqrt = new Sqrt();
    Assert.assertEquals(0, sqrt.main(0));
  }
}
