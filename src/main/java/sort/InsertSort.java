package sort;

import util.CommonUtils;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1), 算法所需的辅助空间不随待排序规模的变化而变化, 是个常量
 * 稳定性: 稳定
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        int i, j, k;
        for (i = 1; i < arr.length; i++) {
            // 为arr[i]在 arr[0] ~ arr[i-1] 之间找到一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    break;
                }
            }
            // 找到了一个合适的位置j
            // 如果j没有动, 继续下一个的比较和移动
            if (j == i - 1) {
                continue;
            }
            // 将比arr[i]大的数据向后移
            int temp = arr[i];
            for (k = i - 1; k > j; k--) {
                arr[k + 1] = arr[k];
            }
            // 将arr[i]插入
            arr[k + 1] = temp;
            // 下一个循环
        }
    }

    // 这个写法有点像冒泡
    public static void insertSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    CommonUtils.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 2, 1, 3};
        int[] b = Arrays.copyOf(a, a.length);
        insertSort(a);
        System.out.println(Arrays.toString(a));
        insertSort2(b);
        System.out.println(Arrays.toString(b));
    }

}
