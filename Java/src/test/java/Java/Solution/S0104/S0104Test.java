package Java.Solution.S0104;

import Java.Solution.S0104.S0104.TreeNode;
import java.util.LinkedList;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched.Link;

public class S0104Test {

  @Test
  public void test1() {
    S0104 s0104 = new S0104();
    Integer[] nums = {3, 9, 20, null, null, 15, 7};
    TreeNode root = s0104.buildTree(nums, 0);
//    s0104.frontTravel(root);
    Assert.assertTrue(s0104.maxDepth(root) == 3);
  }

  @Test
  public void test2() {
    S0104 s0104 = new S0104();
    Integer[] nums = null;
    TreeNode root = s0104.buildTree(nums, 0);
//    s0104.frontTravel(root);
    Assert.assertTrue(s0104.maxDepth(root) == 0);
  }

  @Test
  public void test3() {
    S0104 s0104 = new S0104();
    Integer[] nums = {3, 9, 20, null, null, 15, 7};
    TreeNode root = s0104.buildTree(nums, 0);
//    s0104.frontTravel(root);
    Assert.assertTrue(s0104.offical(root) == 3);
  }

  @Test
  public void test4() {
    S0104 s0104 = new S0104();
    Integer[] nums = null;
    TreeNode root = s0104.buildTree(nums, 0);
//    s0104.frontTravel(root);
    Assert.assertTrue(s0104.offical(root) == 0);

    LinkedList<Integer> stack = new LinkedList<>();
    stack.poll();
  }
}