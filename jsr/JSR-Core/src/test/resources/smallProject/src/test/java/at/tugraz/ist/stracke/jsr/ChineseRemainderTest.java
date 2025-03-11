package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class ChineseRemainderTest {

  public ChineseRemainderTest() {
  }

  @Test
  public void test1() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(8, chineseremainder.main(new int[]{3,5}, new int[]{2,3}));
  }

  @Test
  public void test2() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(46, chineseremainder.main(new int[]{3,7,8}, new int[]{1,4,6}));
  }

  @Test
  public void test3() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(425, chineseremainder.main(new int[]{3,7,11,13}, new int[]{2,5,7,9}));
  }

  @Test
  public void test4() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(3, chineseremainder.main(new int[]{35}, new int[]{3}));
  }

  @Test
  public void test5() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(183, chineseremainder.main(new int[]{5,11,13}, new int[]{3,7,1}));
  }

  @Test
  public void test6() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(1064202, chineseremainder.main(new int[]{7,13,19,23,29}, new int[]{6,9,12,15,18}));
  }

  @Test
  public void test7() {
    ChineseRemainder chineseremainder = new ChineseRemainder();
    Assert.assertEquals(1, chineseremainder.main(new int[]{2,3,5,7,11,13}, new int[]{1,1,1,1,1,1}));
  }
}
