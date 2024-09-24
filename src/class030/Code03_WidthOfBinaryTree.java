package class030;

/**
 * ClassName: f
 * Package: class030
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/23 11:00
 * @Version 1.0
 */


// 二叉树的最大特殊宽度
// 测试链接 : https://leetcode.cn/problems/maximum-width-of-binary-tree/
public class Code03_WidthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 用每次处理一层的优化bfs就非常容易实现
    // 如果测试数据量变大了就修改这个值
    public static int MAXN = 3001;

    public static TreeNode[] nq = new TreeNode[MAXN];//存放节点

    public static int[] iq = new int[MAXN];//作为满二叉树节点的下标

    public static int l, r;

    public static int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        l = r = 0;
        nq[r] = root;
        iq[r++] = 1;
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, iq[r - 1] - iq[l] + 1);
            for (int i = 0; i < size; i++) {
                TreeNode cur = nq[l++];
                if (cur.left != null) {
                    nq[r] = cur.left;
                    iq[r++] = 2 * iq[l - 1];
                }
                if (cur.right != null) {
                    nq[r] = cur.right;
                    iq[r++] = 2 * iq[l - 1] + 1;
                }
            }
        }
        return ans;
    }

}