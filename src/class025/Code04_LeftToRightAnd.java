package class025;

/**
 * ClassName: f
 * Package: class025
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/20 12:04
 * @Version 1.0
 */


// 给你两个整数 left 和 right ，表示区间 [left, right]
// 返回此区间内所有数字 & 的结果
// 包含 left 、right 端点
// 测试链接 : https://leetcode.cn/problems/bitwise-and-of-numbers-range/
public class Code04_LeftToRightAnd {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right -= right & -right;
        }
        return right;
    }

}