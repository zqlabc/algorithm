package class030;

/**
 * ClassName: f
 * Package: class030
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/23 15:53
 * @Version 1.0
 */

// 验证完全二叉树
// 测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
public class Code08_CompletenessOfBinaryTree {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 101;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public static boolean isCompleteTree(TreeNode h) {
        if (h == null) {
            return true;
        }
        l = r = 0;
        queue[r++] = h;
        boolean leaf = false;//是否遇到过左右孩子不双全
        while (l < r) {
            h = queue[l++];
            if ((h.left == null && h.right != null) || (leaf && (h.left != null || h.right != null))) {
                return false;
            }
            if (h.left != null) {
                queue[r++] = h.left;
            }
            if (h.right != null) {
                queue[r++] = h.right;
            }
            if (h.left == null || h.right == null) {
                leaf = true;
            }
        }
        return true;
    }

}