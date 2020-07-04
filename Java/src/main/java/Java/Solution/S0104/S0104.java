
package Java.Solution.S0104;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class S0104 {

  public int maxDepth(TreeNode root) {
    return root == null ? 0 : depth(root, 1);
  }

  public int offical(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int ll = offical(root.left);
      int rl = offical(root.right);
      return Math.max(ll, rl) + 1;
    }
  }

  public int officalQueue(TreeNode root) {
    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    if (root != null) {
      queue.add(new Pair(root, 1));
    }

    int depth = 0;
    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> current = queue.poll();
      root = current.getKey();
      int current_depth = current.getValue();
      if (root != null) {
        depth = Math.max(depth, current_depth);
        queue.add(new Pair(root.left, current_depth + 1));
        queue.add(new Pair(root.right, current_depth + 1));
      }
    }
    return depth;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode buildTree(Integer[] nums, int idx) {
    if (nums == null || idx >= nums.length) {
      return null;
    }

    Integer val = nums[idx];
    if (val == null) {
      return null;
    }

    int length = nums.length;
    TreeNode p = new TreeNode(val);
    TreeNode lc = null;
    int li = (idx << 1) + 1;
    if (li < length) {
      lc = buildTree(nums, li);
    }

    TreeNode rc = null;
    int ri = (idx + 1) << 1;
    if (ri < length) {
      rc = buildTree(nums, ri);
    }

    p.left = lc;
    p.right = rc;
    return p;
  }

  public void frontTravel(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val);
    System.out.print(" ");
    frontTravel(root.left);
    frontTravel(root.right);
  }

  public int depth(TreeNode root, int height) {
    if (root == null) {
      return height;
    }

    int leftHeight = height, rightHeight = height;
    if (root.left != null) {
      leftHeight = depth(root.left, height + 1);
    }
    if (root.right != null) {
      rightHeight = depth(root.right, height + 1);
    }

    return leftHeight > rightHeight ? leftHeight : rightHeight;
  }
}
