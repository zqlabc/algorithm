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

// 数组中有2种数出现了奇数次，其他的数都出现了偶数次
// 返回这2种出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number-iii/
public class Code05_DoubleNumber {

    public static int[] singleNumber(int[] nums) {
        int eor1 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            eor1 ^= nums[i];
        }
        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int i = 0; i < len; i++) {
            if ((rightOne & nums[i])==1){
                eor2^=nums[i];
            }
        }
        return new int[]{eor1,eor1^eor2};
    }

}
