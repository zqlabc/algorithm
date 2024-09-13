package class004;


/**
 * ClassName: FindPeekElement
 * Package: class004
 * Description:  二分找峰值
 *
 * @Author 曾清林
 * @Create 2024/9/12 20:20
 * @Version 1.0
 */
public class FindPeekElement {

    public static int exist(int[] arr) {
        int ans = -1;
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 1, r = arr.length - 2, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m - 1] > arr[m]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}
