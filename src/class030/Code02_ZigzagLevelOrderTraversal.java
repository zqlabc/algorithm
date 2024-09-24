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
import java.util.List;

// 二叉树的锯齿形层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class Code02_ZigzagLevelOrderTraversal {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    // 用每次处理一层的优化bfs就非常容易实现
    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;
            boolean reverse = false;
            while (l < r) {
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();
                // reverse == false, 左 -> 右， l....r-1, 收集size个
                // reverse == true,  右 -> 左， r-1....l, 收集size个
                // 左 -> 右, i = i + 1
                // 右 -> 左, i = i - 1
                for (int i = reverse ? r - 1 : l, j = reverse ? -1 : 1, k = 0; k < size; k++, i = i + j) {
                    list.add(queue[i].val);
                }
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
                reverse = !reverse;
            }
        }
        return ans;
    }

}