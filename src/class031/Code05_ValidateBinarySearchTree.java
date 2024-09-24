package class031;

/**
 * ClassName: f
 * Package: class031
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/24 15:29
 * @Version 1.0
 */


// 验证搜索二叉树
// 测试链接 : https://leetcode.cn/problems/validate-binary-search-tree/
public class Code05_ValidateBinarySearchTree {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交以下的方法
    public static int MAXN = 10001;

    public static TreeNode[] stack = new TreeNode[MAXN];

    public static int r;

    // 提交时改名为isValidBST
    // 提交时改名为isValidBST
    public static boolean isValidBST(TreeNode head) {
        if (head == null) {
            return true;
        }
        TreeNode pre = null;
        r = 0;
        while (r > 0 || head != null) {
            if (head != null) {
                stack[r++] = head;
                head = head.left;
            } else {
                head=stack[--r];
                if (pre != null && pre.val >= head.val) {
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }

    public static long min, max;

    // 提交时改名为isValidBST
    public static boolean isValidBST2(TreeNode head) {
        if (head == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean lok = isValidBST2(head.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST2(head.right);
        long rmin = min;
        long rmax = max;
        min = Math.min(Math.min(lmin, rmin), head.val);//返回给上一层的最小值
        max = Math.max(Math.max(lmax, rmax), head.val);//返回给上一层的最大值
        return lok && rok && lmax < head.val && head.val < rmin;//左边是，右边是head也满足
    }


}

