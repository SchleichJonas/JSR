
import java.util.*;

class InverseCounterAltered {

  // Function to count inversions in the array
  static int inversionCount(int arr[]) {
    int n = arr.length;
    int invCount = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n - 1; j++) { //Error

        // If the current element is greater than the next,
        // increment the count
        if (arr[i] > arr[j])
          invCount++;
      }
    }
    return invCount;
  }

  public static int main(int arr[]) {
    return inversionCount(arr);
  }
}