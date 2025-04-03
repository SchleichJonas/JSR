
class Mult {

  /* function to multiply two numbers x and y*/
  static int multiply(int x, int y) {

    /* 0 multiplied with anything gives 0 */
    if (y == 0)
      return 0;

    /* Add x one by one */
    if (y > 0)
      return (x + multiply(x, y - 1));

    /* the case where y is negative */
    if (y < 0)
      return -multiply(x, -y);

    return -1;
  }

  // Driver code
  public static int main(int a, int b) {

    return multiply(a,b);
  }
}

// This code is contributed by Anant Agarwal.
