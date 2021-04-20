package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 16:55
 * <p>
 * 凑零钱
 **/
public class CoinChange {

    /*
    先看下题目：给你k种面值的硬币，面值分别为c1, c2 ... ck，每种硬币的数量无限。
    再给一个总金额amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：

    // coins 中是可选硬币面值，amount 是目标金额
    int coinChange(int[] coins, int amount);
     */

    public static void main(String[] args) {
        coinChangeV3(new int[]{2}, 3);
    }

    /**
     * 自顶向下，备忘录形式
     * dp(n) 表示当前目标金额为n，最少需要dp(n)个硬币凑出该金额
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChangeV1(int[] coins, int amount) {
        return coinChangeV1Helper(coins, amount, new HashMap<>());
    }

    private static int coinChangeV1Helper(int[] coins, int amount, Map<Integer, Integer> resMap) {
        if (resMap.containsKey(amount)) {
            return resMap.get(amount);
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;

        int nextRes;
        for (int coin : coins) {

            // 选择了一枚硬币后，剩下的需要计算amount-coinValue最少需要多少枚硬币，结果为nextRes
            nextRes = coinChangeV1Helper(coins, amount - coin, resMap);
            if (nextRes == -1) { // -1表示无解，不记录下来
                continue;
            }

            // res为循环里的每个nextRes+1的最小值
            res = Math.min(nextRes + 1, res);
        }

        res = res == Integer.MAX_VALUE ? -1 : res;

        resMap.put(amount, res);
        return res;
    }

    /**
     * 自底向上的动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChangeV2(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res, amount + 1);

        res[0] = 0;

        for (int i = 0; i < res.length; i++) {
            // 内层求解所有子问题+1的最小值
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                res[i] = Math.min(res[i], 1 + res[i - coin]);
            }
        }

        if (res[amount] == amount + 1) {
            return -1;
        } else {
            return res[amount];
        }
    }


    /**
     * 自己练习
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChangeV3(int[] coins, int amount) {
        int[] res = new int[amount + 1]; // 从0到n
        Arrays.fill(res, -1); // 都置为无解

        res[0] = 0;

        // i指的是amount为i,res[i]指当前最小的金币数
        for (int i = 1; i < res.length; i++) {

            int minValue = Integer.MAX_VALUE;
            for (int coinValue : coins) {
                if (i - coinValue < 0) {
                    continue;
                }

                if (res[i - coinValue] == -1) {
                    continue;
                }

                minValue = Math.min(minValue, res[i - coinValue] + 1);
            }
            if (minValue != Integer.MAX_VALUE) {
                res[i] = minValue;
            }
        }

        return res[amount];
    }

    private static int coinChangeV4(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 从0到n

        dp[0] = 0;

        int curMin;
        for (int i = 1; i < dp.length; i++) {
            curMin = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }

                if (dp[i - coin] == Integer.MAX_VALUE) {
                    continue;
                }

                curMin = Math.min(curMin, 1 + dp[i - coin]);
            }
            dp[i] = curMin;
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }


}
