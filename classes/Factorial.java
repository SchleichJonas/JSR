
class Factorial {

  // Method to find factorial of the given number
  static int factorial(int n)
  {
    int res = 1;
    for (int i = 2; i <= n; i++)
      res *= i;
    return res;
  }

  // Driver method
  public static int main(int num)
  {
    return factorial(num);
  }
}