package Java.Solution.S0084;

import java.util.Stack;

public class S0084 {

  /**
   * O(N*N) 双重循环遍历, 依次求出以各个范围的矩形面积, 然后取最大值
   */
  public int way1(int[] heights) {

    int maxRectArea = 0;
    int size = heights.length;
    for (int i = 0; i < size; i++) {
      int minHeight = Integer.MAX_VALUE;
      for (int j = i; j < size; j++) {
        minHeight = Math.min(minHeight, heights[j]);
        maxRectArea = Math.max(maxRectArea, (j - i + 1) * minHeight);
      }
    }
    return maxRectArea;
  }

  /**
   * 依次计算完全包含当前高度的最大面积
   * 当前高度的最大矩形宽度为左右两侧第一个比自己矮的范围差
   * stack.peek() + 1解释见picture/S0084.png图
   * 参考了这里https://blog.csdn.net/Zolewit/article/details/88863970
   */
  public int way2(int[] heights) {

    int maxRectArea = 0;
    int size = heights.length;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i <= size; i++) {
      int currentHeight = i < size ? heights[i] : -1;
      if (stack.empty() || heights[stack.peek()] <= currentHeight) { // 栈空 || 当前高度>=栈顶元素
        stack.push(i);
      } else { // 当前高度小于栈定元素
        while (!stack.empty() && heights[stack.peek()] > currentHeight) {
          int top = stack.pop();
          int li = stack.empty() ? 0 : stack.peek() + 1; // 栈为空时, 说明左边没有比栈定高的元素, 因此最左边取0
          int ri = i;
          int width = ri - li;
          maxRectArea = Math.max(maxRectArea, width * heights[top]);
        }
        stack.push(i);
      }
    }

    return maxRectArea;
  }
}
