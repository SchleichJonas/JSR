package at.tugraz.ist.stracke.jsr;

class Isprime {

  static boolean isPrime(int n) {
    if (n <= 1)
      return false;

    // Check divisibility from 2 to n-1
    for (int i = 2; i <= n; i++) //Error
      if (n % i == 0)
        return false;

    return true;
  }

  public static boolean main(int n) {
    return isPrime(n);
  }
}