// Java program to find modular inverse

import java.io.*;

class ModInverseAltered {

  // A naive method to find modulor
  // multiplicative inverse of A
  // under modulo M
  static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
  static int modInverse(int A, int M) {
    if (gcd(A, M) > 1) {

      // modulo inverse does not exist
      return -1;
    }
    for (int X = 1; X < M; X++)
      if (((A % M) * (X % M)) % M == 1)
        return X;
    return 1;
  }

  public static int main(int A, int M)
  {
    return modInverse(M, M);//Error
  }
}