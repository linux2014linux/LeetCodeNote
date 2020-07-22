package Java.Solution.S0236;

import Java.Solution.S0236.S0236.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class S0236Test {

  @Test
  public void test1() {
    S0236 s0236 = new S0236();
    TreeNode root = s0236.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}, 0);
    TreeNode p = s0236.new TreeNode(5);
    TreeNode q = s0236.new TreeNode(1);
    TreeNode r = s0236.lowestCommonAncestor(root, p, q);
    Assert.assertTrue(new Integer(3).equals(r.val));

    p = s0236.new TreeNode(5);
    q = s0236.new TreeNode(4);
    r = s0236.lowestCommonAncestor(root, p, q);
    Assert.assertTrue(new Integer(5).equals(r.val));
  }
}
