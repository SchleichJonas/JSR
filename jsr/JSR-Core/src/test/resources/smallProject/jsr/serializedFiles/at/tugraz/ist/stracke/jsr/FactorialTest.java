package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class FactorialTest {

  public FactorialTest() {
  }

  @Test
  public void test1() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(1, factorial.main(0));
  }

  @Test
  public void test2() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(1, factorial.main(1));
  }

  @Test
  public void test3() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(120, factorial.main(5));
  }

  @Test
  public void test4() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(5040, factorial.main(7));
  }

  @Test
  public void test5() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(3628800, factorial.main(10));
  }

  @Test
  public void test6() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(6, factorial.main(3));
  }

  @Test
  public void test7() {
    Factorial factorial = new Factorial();
    Assert.assertEquals(40320, factorial.main(8));
  }
}
