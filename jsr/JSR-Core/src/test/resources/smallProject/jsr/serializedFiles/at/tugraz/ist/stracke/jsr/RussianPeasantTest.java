package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class RussianPeasantTest {

  public RussianPeasantTest() {
  }

  @Test
  public void test1() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(126, russianpeasant.main(18, 7));
  }

  @Test
  public void test2() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(53, russianpeasant.main(1, 53));
  }

  @Test
  public void test3() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(0, russianpeasant.main(0, 45));
  }

  @Test
  public void test4() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(512, russianpeasant.main(16, 32));
  }

  @Test
  public void test5() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(200, russianpeasant.main(25, 8));
  }

  @Test
  public void test6() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(7006652, russianpeasant.main(1234, 5678));
  }

  @Test
  public void test7() {
    RussianPeasant russianpeasant = new RussianPeasant();
    Assert.assertEquals(315, russianpeasant.main(15, 21));
  }
}
