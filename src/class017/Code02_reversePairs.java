package class017;

/**
 * ClassName:
 * Package: class017
 * Description:
 *
 * @Author 曾清林
 * @Create 2024/9/17 11:29
 * @Version 1.0
 */
// 小和问题
// 测试链接 : https://leetcode.cn/problems/reverse-pairs/
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

import java.io.*;

public class Code02_reversePairs {

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];


    public static int reversePairs(int[] arr) {
        return counts(arr, 0, arr.length - 1);
    }

    // 统计l...r范围上，翻转对的数量，同时l...r范围统计完后变有序
    // 时间复杂度O(n * logn)
    public static int counts(int[] arr, int l, int r) {
       if(l==r){
           return 0;
       }
       int m=(l+r)/2;
       return counts(arr,l,m)+counts(arr,m+1,r)+merge(arr,l,m,r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
       int ans=0;
       for(int i=l,j=m+1;i<=m;i++){
           while (j<=r&&arr[i]>arr[j]*2){
               j++;
           }
           ans+=j-m-1;
       }
       int i=l;
       int a=l;
       int b=m+1;
       while (a<=m&&b<=r){
           help[i++]=arr[a]<=arr[b]?arr[a++]:arr[b++];
       }
       while (a<=m){
           help[i++]=arr[a++];
       }
       while (b<=r){
           help[i++]=arr[b++];
       }
       for(i=l;i<=r;i++){
           arr[i]=help[i];
       }
       return ans;
    }
}