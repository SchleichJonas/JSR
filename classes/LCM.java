
import java.io.*;
public class LCM
{
  // Recursive method to return gcd of a and b
  static int gcd(int a, int b)
  {
    if (a == 0)
      return b;
    return gcd(b % a, a); 
  }

  // method to return LCM of two numbers
  static int lcm(int a, int b)
  {
    return (a / gcd(a, b)) * b;
  }

  // Driver method
  public static int main(int a, int b)
  {
    return lcm(a,b);
  }
}