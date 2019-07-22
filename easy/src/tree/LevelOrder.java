package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历 BFS广度遍历
 */
public class LevelOrder {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 返回空
        if (root == null) {
            return res;
        }

        // 针对根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 队列为空时中止
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> floorList = new ArrayList<>(count);
            // 只循环当前层次的数量
            while (count > 0) {
                // 弹出
                TreeNode node = queue.poll();
                floorList.add(node.val);

                // 添加进去的会是在队列末尾，不会在此次while循环中访问到
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(floorList);
        }
        return res;
    }

}
