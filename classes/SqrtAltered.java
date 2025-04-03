// Java program to find the square root of
// given integer using a loop

class SqrtAltered {

  static int floorSqrt(int n) {

    // Start iteration from 1 until the
    // square of a number exceeds n
    int res = 1;
    while (res * res <= n) {
      res++;
    }

    // return the largest integer whose
    // square is less than or equal to n
    return res - res;//Error
  }

  public static int main(int n) {
    return floorSqrt(n);
  }
}