package class030;

/**
 * ClassName: f
 * Package: class030
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/23 10:59
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 二叉树的层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class Code01_LevelOrderTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 普通bfs
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            HashMap<TreeNode, Integer> levels = new HashMap<>();
            queue.add(root);
            levels.put(root, 0);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int level = levels.get(cur);
                if (queue.size() == level) {
                    ans.add(new ArrayList<>());
                }
                ans.get(level).add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                    levels.put(cur.left, level + 1);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    levels.put(cur.right, level + 1);
                }
            }
        }
        return ans;
    }


    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    // 每次处理一层的优化bfs
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            while (l < r) {
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }

}