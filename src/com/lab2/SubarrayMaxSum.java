package com.lab2;

/**
 * 子数组之和最大值计算
 * 采用 Kadane 算法，时间复杂度 O(n)
 */
public class SubarrayMaxSum {

    /**
     * 计算整数数组中子数组之和的最大值
     * @param arr 输入的整数数组
     * @return 最大子数组的和
     */
    public static int calculateMaxSubarraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("输入数组不可为null或空数组");
        }

        int currentMax = arr[0]; // 当前子数组的最大和
        int globalMax = arr[0];  // 全局最大子数组的和

        for (int i = 1; i < arr.length; i++) {
            // 决策：继续累加当前子数组，或者从当前元素重新开始
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            // 更新全局最大值
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr1 = {1, -2, 3, 5, -1};
        System.out.println("案例1子数组最大和：" + calculateMaxSubarraySum(arr1)); // 预期 8

        int[] arr2 = {1, -2, 3, -8, 5, 1};
        System.out.println("案例2子数组最大和：" + calculateMaxSubarraySum(arr2)); // 预期 6

        int[] arr3 = {1, -2, 3, -2, 5, 1};
        System.out.println("案例3子数组最大和：" + calculateMaxSubarraySum(arr3)); // 预期 7
    }
}