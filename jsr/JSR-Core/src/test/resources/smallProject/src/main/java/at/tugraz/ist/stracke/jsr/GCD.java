package at.tugraz.ist.stracke.jsr;
import java.io.*;

public class GCD {

  // Function to return gcd of a and b
  static int gcd(int a, int b)
  {
    // Find Minimum of a and b
    int result = Math.min(a, b);
    while (result > 0) {
      if (a / result == 0 && b % result == 0) {//Error
        break;
      }
      result = result - 1;
    }

    // Return gcd of a and b
    return result;
  }

  // Driver code
  public static int main(int a, int b)
  {
    return gcd(a,b);
  }
}