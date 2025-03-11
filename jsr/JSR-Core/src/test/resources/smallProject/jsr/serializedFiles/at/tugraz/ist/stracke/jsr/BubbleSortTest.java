package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class BubbleSortTest {

  public BubbleSortTest() {
  }

  @Test
  public void test1() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{1, 2, 5, 5, 6, 9}, bubblesort.main(new int[]{5, 2, 9, 1, 5, 6})));
  }

  @Test
  public void test2() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{2, 3, 4, 8}, bubblesort.main(new int[]{3, 8, 2, 4})));
  }

  @Test
  public void test3() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{5, 6, 7, 8, 9, 10}, bubblesort.main(new int[]{10, 9, 8, 7, 6, 5})));
  }

  @Test
  public void test4() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, bubblesort.main(new int[]{1, 2, 3, 4, 5})));
  }

  @Test
  public void test5() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{3}, bubblesort.main(new int[]{3})));
  }

  @Test
  public void test6() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{4, 4, 4, 4, 4}, bubblesort.main(new int[]{4, 4, 4, 4, 4})));
  }

  @Test
  public void test7() {
    BubbleSort bubblesort = new BubbleSort();
    Assert.assertFalse(Arrays.equals(new int[]{-3, -2, -1, 0, 5}, bubblesort.main(new int[]{-3, -1, -2, 5, 0})));
  }
}
