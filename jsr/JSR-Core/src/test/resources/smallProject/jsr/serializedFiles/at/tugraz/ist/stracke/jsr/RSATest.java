package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class RSATest {

  public RSATest() {
  }

  @Test
  public void test1() {
    RSA rsa = new RSA();
    Assert.assertEquals(1, rsa.main(1, 61, 53));
  }

  @Test
  public void test2() {
    RSA rsa = new RSA();
    Assert.assertEquals(12, rsa.main(12, 7919,1009));
  }

  @Test
  public void test3() {
    RSA rsa = new RSA();
    Assert.assertEquals(101, rsa.main(101, 17, 19));
  }

  @Test
  public void test4() {
    RSA rsa = new RSA();
    Assert.assertEquals(77, rsa.main(77, 23,41));
  }

  @Test
  public void test5() {
    RSA rsa = new RSA();
    Assert.assertEquals(5, rsa.main(5, 31,37));
  }

  @Test
  public void test6() {
    RSA rsa = new RSA();
    Assert.assertEquals(52, rsa.main(52, 67,71));
  }

  @Test
  public void test7() {
    RSA rsa = new RSA();
    Assert.assertEquals(99, rsa.main(99, 11,13));
  }
}
