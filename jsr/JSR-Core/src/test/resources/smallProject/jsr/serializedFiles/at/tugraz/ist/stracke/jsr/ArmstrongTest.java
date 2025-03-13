package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ArmstrongTest {

  public ArmstrongTest() {
  }

  @Test
  public void test1() {
    Armstrong armstrong = new Armstrong();
    Assert.assertTrue(armstrong.main(0));
  }

  @Test
  public void test2() {
    Armstrong armstrong = new Armstrong();
    Assert.assertTrue(armstrong.main(1));
  }

  @Test
  public void test3() {
    Armstrong armstrong = new Armstrong();
    Assert.assertTrue(armstrong.main(153));
  }

  @Test
  public void test4() {
    Armstrong armstrong = new Armstrong();
    Assert.assertTrue(armstrong.main(370));
  }

  @Test
  public void test5() {
    Armstrong armstrong = new Armstrong();
    Assert.assertTrue(armstrong.main(9474));
  }

  @Test
  public void test6() {
    Armstrong armstrong = new Armstrong();
    Assert.assertFalse(armstrong.main(9475));
  }

  @Test
  public void test7() {
    Armstrong armstrong = new Armstrong();
    Assert.assertFalse(armstrong.main(100));
  }
}
