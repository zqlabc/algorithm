package class031;

/**
 * ClassName: f
 * Package: class031
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/24 15:12
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

// 收集累加和等于aim的所有路径
// 测试链接 : https://leetcode.cn/problems/path-sum-ii/
public class Code03_PathSumII {


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int aim) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            f(root, aim, 0, path, ans);
        }
        return ans;
    }

    public static void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {
        if(cur.left==null&&cur.right==null){//叶子节点
            if(cur.val+sum==aim){
                path.add(cur.val);
                copy(path,ans);
                path.remove(path.size()-1);
            }
        }else {//非叶子节点
            path.add(cur.val);
            if(cur.left!=null){
                f(cur.left,aim,sum+ cur.val,path,ans);
            }
            if(cur.right!=null){
                f(cur.right,aim,sum+ cur.val,path,ans);
            }
            path.remove(path.size()-1);
        }
    }

    public static void copy(List<Integer> path, List<List<Integer>> ans) {
        List<Integer> copy = new ArrayList<>();
        for (Integer num : path) {
            copy.add(num);
        }
        ans.add(copy);
    }

}