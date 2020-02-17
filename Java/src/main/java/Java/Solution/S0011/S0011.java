package Java.Solution.S0011;

public class S0011 {
  // O(n*n)
  public int maxArea1(int[] height) {
    int maxArea = 0, length = height.length;
    for (int width = 1; width < length; width++) {
      for (int i = 0; i < length - width; i++) {
        int curArea = width * Math.min(height[i], height[i + width]);
        maxArea = curArea > maxArea ? curArea : maxArea;
      }
    }
    return maxArea;
  }

  /**
   * O(n)
   * 两侧同时移动,低的一侧向内移动
   */
  public int maxArea(int[] height) {
    int maxArea = 0, curArea = 0, start = 0, end = height.length - 1;
    while (start < end) {
      curArea = (end - start) * Math.min(height[start], height[end]);
      maxArea = curArea > maxArea ? curArea : maxArea;
      if (height[start] < height[end]) {
        start++;
      } else {
        end--;
      }
    }
    return maxArea;
  }
}
