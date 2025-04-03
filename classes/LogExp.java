
class LogExp {

  // Naive iterative solution to calculate pow(b, e)
  static double power(double b, int e) {

    // Initialize result to 1
    double pow = 1;

    // Multiply b for e times
    for (int i = 0; i < Math.abs(e); i++)
      pow = pow * b;

    if (e < 0)
      return 1 / pow;

    return pow;
  }

  public static double main(double b, int e) {
    return power(b, e);
  }
}