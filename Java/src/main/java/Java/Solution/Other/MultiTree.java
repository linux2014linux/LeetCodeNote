package Java.Solution.Other;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MultiTree {

  class MyNode {
    int val;
    List<MyNode> childList;

    MyNode(int n) {
      val = n;
      childList = new LinkedList<>();
    }
  }

  /**
   * 构建多叉树
   * @param value 当前结点的值
   * @param childValueListMap key 父结点的值, value 子结点值列表
   * @return
   */
  public MyNode build(int value, Map<Integer, Queue<Integer>> childValueListMap) {
    MyNode node = new MyNode(value);
    if (!childValueListMap.containsKey(value)) {
      return node;
    }

    Queue<Integer> childValueList = new LinkedList<>();
    if (childValueListMap.containsKey(value)) {
      childValueList = childValueListMap.get(value);
    }

    List<MyNode> childNodeList = new LinkedList<>();
    for (Integer childValue : childValueList) {
      MyNode childRoot = build(childValue, childValueListMap);
      childNodeList.add(childRoot);
    }
    node.childList = childNodeList;
    return node;
  }

  public List<Integer> levelTraversal(MyNode root) {
    List<Integer> numList = new LinkedList<>();
    if (root == null) {
      return numList;
    }

    numList.add(root.val);
    Queue<MyNode> queue = new LinkedList<>(root.childList);
    while (queue.size() != 0) {
      MyNode node = queue.poll();
      numList.add(node.val);
      ((LinkedList<MyNode>) queue).addAll(node.childList);
    }
    return numList;
  }


}
