package Java.Solution.Other.RebuildBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class RebuildBinaryTree {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  /**
   * 递归重建二叉树
   * @param preorder 前序遍历
   * @param inorder 中序遍历
   * @return
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }

    Map<Integer, Integer> inOrderIndexMap = new HashMap<Integer, Integer>();
    int length = preorder.length;
    for (int i = 0; i < length; i++) {
      inOrderIndexMap.put(inorder[i], i);
    }
    TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, inOrderIndexMap);

    return root;
  }

  /**
   * 递归构建二叉树
   * @param preorder 前序序列
   * @param preorderStart 当前结点为根时, 前序树开始位置
   * @param preorderEnd 当前结点为根时, 前序树结束位置
   * @param inorder 中序序列
   * @param inorderStart 前结点为根时, 中序树开始位置
   * @param inorderEnd 前结点为根时, 中序树结束位置
   * @param indexMap 中序位置map
   * @return
   */
  public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
      int[] inorder, int inorderStart, int inorderEnd,
      Map<Integer, Integer> indexMap) {
    if (preorderStart > preorderEnd) {
      return null;
    }

    // 先用前序构建根节点
    int rootVal = preorder[preorderStart];
    TreeNode root = new TreeNode(rootVal);

    if (preorderStart == preorderEnd) { // 构建结束
      return root;
    } else {
      // 根结点的中序位置
      int rootIndex = indexMap.get(rootVal);

      // 左右子树孩子的数量
      int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;

      // 构建左子树
      TreeNode leftSubtree =
          buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
              inorder, inorderStart, rootIndex - 1, indexMap);

      // 构建右子树
      TreeNode rightSubtree =
          buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
          inorder, rootIndex + 1, inorderEnd, indexMap);

      root.left = leftSubtree;
      root.right = rightSubtree;
      return root;
    }
  }
}
