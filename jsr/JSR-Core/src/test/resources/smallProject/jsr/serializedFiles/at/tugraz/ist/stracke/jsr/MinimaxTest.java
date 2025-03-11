package at.tugraz.ist.stracke.jsr;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;

public class MinimaxTest {

  public MinimaxTest() {
  }

  @Test
  public void test1() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(12, minimax.main(new int[]{3, 5, 2, 9, 12, 5, 23, 23}));
  }

  @Test
  public void test2() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(7, minimax.main(new int[]{7, 8, 3, 5}));
  }

  @Test
  public void test3() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(-2, minimax.main(new int[]{-1, -2, -3, -4}));
  }

  @Test
  public void test4() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(10, minimax.main(new int[]{10}));
  }

  @Test
  public void test5() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(7, minimax.main(new int[]{4, 6, 8, 2, 1, 7, 9, 3}));
  }

  @Test
  public void test6() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(300, minimax.main(new int[]{100, 200, 300, 400, 500}));
  }

  @Test
  public void test7() {
    Minimax minimax = new Minimax();
    Assert.assertEquals(0, minimax.main(new int[]{-5, -10, 0, 5, 10}));
  }
}
