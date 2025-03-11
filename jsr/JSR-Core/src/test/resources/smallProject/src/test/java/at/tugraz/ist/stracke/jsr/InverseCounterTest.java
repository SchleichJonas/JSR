package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class InverseCounterTest {

  public InverseCounterTest() {
  }

  @Test
  public void test1() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(0, inversecounter.main(new int[]{1,2,3,4,5}));
  }

  @Test
  public void test2() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(10, inversecounter.main(new int[]{5,4,3,2,1}));
  }

  @Test
  public void test3() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(2, inversecounter.main(new int[]{1,3,2,5,4}));
  }

  @Test
  public void test4() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(6, inversecounter.main(new int[]{7,5,3,1}));
  }

  @Test
  public void test5() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(4, inversecounter.main(new int[]{1,2,3,4,0}));
  }

  @Test
  public void test6() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(0, inversecounter.main(new int[]{10, 20, 30, 40, 50}));
  }

  @Test
  public void test7() {
    InverseCounter inversecounter = new InverseCounter();
    Assert.assertEquals(6, inversecounter.main(new int[]{8, 4, 2, 1}));
  }
}
