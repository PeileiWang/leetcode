package algorithm.dp;

/**
 * @author: wangpeilei
 * @date: 2021/04/17 16:18
 * 斐波那契数列
 **/
public class Fib {
    public static void main(String[] args) {
        System.out.println("暴力递归fib");
        long startTime = System.currentTimeMillis();
        System.out.println(fibV1(8));
        System.out.println(fibV1(10));
        System.out.println(fibV1(40));
        System.out.println("cost:" + (System.currentTimeMillis() - startTime));
        System.out.println("--------------");


        System.out.println("递归用备忘录fib");
        startTime = System.currentTimeMillis();
        System.out.println(fibV2(8));
        System.out.println(fibV2(10));
        System.out.println(fibV2(40));
        System.out.println("cost:" + (System.currentTimeMillis() - startTime));
        System.out.println("---------------");


        System.out.println("自底向上fib");
        startTime = System.currentTimeMillis();
        System.out.println(fibV3(8));
        System.out.println(fibV3(10));
        System.out.println(fibV3(40));
        System.out.println("cost:" + (System.currentTimeMillis() - startTime));
        System.out.println("----------------");

        System.out.println("最简单fib");
        startTime = System.currentTimeMillis();
        System.out.println(fibV4(8));
        System.out.println(fibV4(10));
        System.out.println(fibV4(40));
        System.out.println("cost:" + (System.currentTimeMillis() - startTime));
        System.out.println("----------------");
    }


    /**
     * 暴力递归
     *
     * @param n
     * @return
     */
    private static int fibV1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibV1(n - 1) + fibV1(n - 2);
    }

    /**
     * 用备忘录
     *
     * @param n
     * @return
     */
    private static int fibV2(int n) {
        int[] backups = new int[n + 1];

        return fibV2Inner(n, backups);
    }

    private static int fibV2Inner(int n, int[] backups) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (backups[n] != 0) {
            return backups[n];
        }

        backups[n] = fibV2Inner(n - 1, backups) + fibV2Inner(n - 2, backups);
        return backups[n];
    }

    private static int fibV3(int n) {
        int[] res = new int[n + 1];
        res[1] = res[2] = 1;

        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }


    private static int fibV4(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int fib1 = 1;
        int fib2 = 1;

        int fibn = 2;
        for (int i = 3; i <= n; i++) {
            fibn = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibn;
        }

        return fibn;
    }


}
