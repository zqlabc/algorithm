package class032;

/**
 * ClassName: f
 * Package: class032
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/25 16:29
 * @Version 1.0
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 有重复项数组的去重全排列
// 测试链接 : https://leetcode.cn/problems/permutations-ii/
public class Code04_PermutationWithoutRepetition {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    public static void f(int[] nums, int i, List<List<Integer>> ans) {
        if(i==nums.length){
            List<Integer> cur=new ArrayList<>();
            for (int num:nums){
                cur.add(num);
            }
            ans.add(cur);
        }else {
            HashSet<Integer> set=new HashSet<>();
            for(int j=i;j< nums.length;j++){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    swap(nums,i,j);
                    f(nums,i+1,ans);
                    swap(nums,i,j);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
