package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class LogExpTest {

  public LogExpTest() {
  }
  @Test
  public void test1() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(2.0, 3) - (8.0)) < 1e-9);
  }

  @Test
  public void test2() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(5.0, 0) - (1.0)) < 1e-9);
  }
  @Test
  public void test3() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(7.0, 1) - (7.0)) < 1e-14);
  }
  @Test
  public void test4() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(10.0, 2) - (100.0)) < 1e-9);
  }
  @Test
  public void test5() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(-2.0, 3) - (-8.0)) < 1e-9);
  }
  @Test
  public void test6() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(-3.0, 4) - (81)) < 1e-9);
  }
  @Test
  public void test7() {
    LogExp logexp = new LogExp();
    Assert.assertEquals(true, Math.abs(logexp.main(2.0, 10) - (1024)) < 1e-9);
  }
}
