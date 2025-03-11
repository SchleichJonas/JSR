package at.tugraz.ist.stracke.jsr;
import java.io.*;

class RussianPeasant
{
  // Function to multiply two
  // numbers using Russian Peasant method
  static int russianPeasant(int a, int b)
  {
    // initialize result
    int res = 0;

    // While second number doesn't become 1
    while (b > 0)
    {
      // If second number becomes odd,
      // add the first number to result
      if ((b & 1) != 0)
        res = res % a; //Error

      // Double the first number
      // and halve the second number
      a = a << 1;
      b = b >> 1;
    }
    return res;
  }

  // driver program
  public static int main (int a, int b)
  {
    return russianPeasant(a, b);
  }
}