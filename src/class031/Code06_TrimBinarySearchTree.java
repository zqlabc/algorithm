package class031;

/**
 * ClassName: f
 * Package: class031
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/24 15:56
 * @Version 1.0
 */


// 修剪搜索二叉树
// 测试链接 : https://leetcode.cn/problems/trim-a-binary-search-tree/
public class Code06_TrimBinarySearchTree {

    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // [low, high]
    public static TreeNode trimBST(TreeNode cur, int low, int high) {
        if(cur==null){
            return null;
        }
        if(cur.val<low){
            return trimBST(cur.right,low,high);
        }
        if (cur.val>high){
            return trimBST(cur.left, low, high);
        }
        cur.left=trimBST(cur.left,low,high);
        cur.right=trimBST(cur.right,low,high);
        return cur;
    }

}
