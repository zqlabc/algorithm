package class024;

/**
 * ClassName: code1
 * Package: class024
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/20 11:07
 * @Version 1.0
 */
// 找到缺失的数字
// 测试链接 : https://leetcode.cn/problems/missing-number/
public class Code03_MissingNumber {

    public static int missingNumber(int[] nums) {
        int eorHas=0,eorALl=0;
        for(int i=0;i<nums.length;i++){
            eorHas^=nums[i];
            eorALl^=i;
        }
        eorALl^=nums.length;
        return eorALl^eorHas;
    }

}