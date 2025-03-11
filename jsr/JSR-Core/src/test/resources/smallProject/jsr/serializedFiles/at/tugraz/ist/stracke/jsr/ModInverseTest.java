package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ModInverseTest {

  public ModInverseTest() {
  }

  @Test
  public void test1() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(4, modinverse.main(3, 11));
  }

  @Test
  public void test2() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(12, modinverse.main(10, 17));
  }

  @Test
  public void test3() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(2, modinverse.main(7, 13));
  }

  @Test
  public void test4() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(1, modinverse.main(1, 5));
  }

  @Test
  public void test5() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(6, modinverse.main(6, 7));
  }

  @Test
  public void test6() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(32, modinverse.main(25, 47));
  }

  @Test
  public void test7() {
    ModInverse modinverse = new ModInverse();
    Assert.assertEquals(2, modinverse.main(8, 15));
  }
}
