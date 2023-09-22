class Main {
  public static void main(String[] args) {
    if (isPrime(9) == true) {
      System.out.println("true");
    }
    else {
      System.out.println("false");
    }
  }

  static boolean isPrime(int n) {

    // Check if number is less than
    // equal to 1
    if (n <= 1) {
      return false;
    }
    // Check if number is 2
    else if (n == 2) {
      return true;
    }
    // Check if n is a multiple of 2
    else if (n % 2 == 0) {
      return false;
    }
    // If not, then just check the odds
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}