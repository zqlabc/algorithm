package class030;

/**
 * ClassName: l
 * Package: class030
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/23 14:36
 * @Version 1.0
 */

// 求二叉树的最大、最小深度
public class Code04_DepthOfBinaryTree {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 测试链接 : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int ldeep=Integer.MAX_VALUE;
        int rdeep=Integer.MAX_VALUE;
        if(root.left!=null){
            ldeep=minDepth(root.left);
        }
        if(root.right!=null){
            rdeep=minDepth(root.right);
        }
        return Math.min(rdeep,ldeep)+1;
    }

}
