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
// 数组中1种数出现了奇数次，其他的数都出现了偶数次
// 返回出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number/
public class Code04_SingleNumber {

    public static int singleNumber(int[] nums) {
        int eor=0;
        for(int i=0;i<nums.length;i++){
            eor^=nums[i];
        }
        return eor;
    }
}