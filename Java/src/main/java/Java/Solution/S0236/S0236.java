package Java.Solution.S0236;

public class S0236 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode buildTree(Integer[] nums, int i) {
    if (nums == null || i >= nums.length || nums[i] == null) {
      return null;
    }

    // 构造根节点
    TreeNode root = new TreeNode(nums[i]);

    // 构造左子树
    int li = i * 2 + 1;
    TreeNode left = null;
    if (li < nums.length) {
      left = buildTree(nums, li);
    }

    // 构造右子树
    int ri = i * 2 + 2;
    TreeNode right = null;
    if (ri < nums.length) {
      right = buildTree(nums, ri);
    }

    root.left = left;
    root.right = right;
    return root;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 到叶子结点或者根节点是待求结点本身返回即可
    if (root == null || root.val == p.val || root.val == q.val) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    return root;
  }
}
