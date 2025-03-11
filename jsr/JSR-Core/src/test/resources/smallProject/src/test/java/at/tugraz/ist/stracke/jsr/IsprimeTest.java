package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class IsprimeTest {

  public IsprimeTest() {
  }

  @Test
  public void test1() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(0));
  }

  @Test
  public void test2() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(1));
  }

  @Test
  public void test3() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(2));
  }

  @Test
  public void test4() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(17));
  }

  @Test
  public void test5() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(18));
  }

  @Test
  public void test6() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(97));
  }

  @Test
  public void test7() {
    Isprime isprime = new Isprime();
    Assert.assertTrue(isprime.main(100));
  }
}
