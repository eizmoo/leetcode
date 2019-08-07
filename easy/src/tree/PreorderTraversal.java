package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {


    public List<Integer> perOrderNoRecursion(TreeNode node) {
        List<Integer> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;

        while (p != null || !stack.empty()) {
            while (p != null) {
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }

            if (!stack.empty()) {
                p = stack.pop();
                p = p.right;
            }
        }

        return result;
    }

    List<Integer> result = new ArrayList<>();

    public void preOrderRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }


}
