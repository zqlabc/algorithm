package class031;

/**
 * ClassName: r
 * Package: class031
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/24 15:24
 * @Version 1.0
 */

// 验证平衡二叉树
// 测试链接 : https://leetcode.cn/problems/balanced-binary-tree/
public class Code04_BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean balance;

    public static boolean isBalanced(TreeNode root) {
        // balance是全局变量，所有调用过程共享
        // 所以每次判断开始时，设置为true
        balance = true;
        height(root);
        return balance;
    }

    // 一旦发现不平衡，返回什么高度已经不重要了
    public static int height(TreeNode cur) {
        if(!balance||cur==null){
            return 0;
        }
        int lh=height(cur.left);
        int rh=height(cur.right);
        if(Math.abs(lh-rh)>1){
            balance=false;
        }
        return Math.max(lh,rh)+1;
    }

}