package Java.Solution.S0922;

public class S0922 {
  // 数组 双指针
  public int[] sortArrayByParityII(int[] A) {
    int j = 1;
    for (int i = 0; i < A.length - 1; i = i + 2) {
      if ((A[i] & 1) != 0) { // 当前偶数位置是奇数需要交换
        while (j < A.length && (A[j] & 1) != 0) { // 寻找最近的一个为奇数的偶数位置
          j = j + 2;
        }
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
      }
    }
    return A;
  }
}
