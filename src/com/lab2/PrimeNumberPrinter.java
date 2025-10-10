package com.lab2; // 声明包名，对应文件夹结构 src/com/lab2

/**
 * 素数打印程序
 * 使用埃拉托色尼筛法（Sieve of Eratosthenes）高效找出 1~20000 内的所有素数
 */
public class PrimeNumberPrinter {

    // 常量定义：筛选的最大数值
    private static final int MAX_NUM = 20000;
    // 常量定义：每行打印的素数个数
    private static final int PRIMES_PER_LINE = 5;

    /**
     * 主方法：程序入口
     */
    public static void main(String[] args) {
        // 记录程序开始执行的时间（用于统计耗时）
        long startTime = System.currentTimeMillis();

        // 调用埃拉托色尼筛法，获取素数标记数组
        boolean[] isPrimeArr = sieveOfEratosthenes(MAX_NUM);

        int primeCount = 0; // 用于计数，控制每行输出数量
        System.out.println("1~" + MAX_NUM + "范围内的素数（每行" + PRIMES_PER_LINE + "个）：");

        // 遍历数组，打印所有素数
        for (int i = 2; i <= MAX_NUM; i++) {
            if (isPrimeArr[i]) { // 如果当前数字是素数
                System.out.printf("%8d", i); // 格式化输出，每个数字占8个字符宽度
                primeCount++; // 素数计数器加 1

                // 每输出 PRIMES_PER_LINE 个素数就换行
                if (primeCount % PRIMES_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }

        // 记录程序结束时间
        long endTime = System.currentTimeMillis();
        // 输出总耗时
        System.out.println("\n程序执行完成！总耗时：" + (endTime - startTime) + "毫秒");
    }

    /**
     * 埃拉托色尼筛法：高效筛选素数
     *
     * @param maxNum 筛选范围的最大值
     * @return boolean数组，isPrimeArr[i] = true 表示 i 是素数
     */
    private static boolean[] sieveOfEratosthenes(int maxNum) {
        // 如果最大值小于 2，则没有素数，返回空数组
        if (maxNum < 2) {
            return new boolean[0];
        }

        // 创建布尔数组，默认所有元素为 false
        boolean[] isPrimeArr = new boolean[maxNum + 1];

        // 初始化：所有大于等于 2 的数字先假设为素数
        for (int i = 2; i <= maxNum; i++) {
            isPrimeArr[i] = true;
        }

        // 筛选过程：从 2 开始到 sqrt(maxNum)
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrimeArr[i]) { // 如果 i 是素数，则标记其所有倍数为非素数
                // 从 i*i 开始标记（优化点：小于 i*i 的倍数已经被更小的数标记过）
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrimeArr[j] = false;
                }
            }
        }

        return isPrimeArr;
    }
}