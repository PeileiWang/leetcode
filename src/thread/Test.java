package thread;

/**
 * @author: wangpeilei
 * @date: 2021/05/05 19:56
 **/
public class Test {

    private static int a = 1;

    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (a == 1) {
                System.out.println(a);
            }

            System.out.println(b);
        });

        thread.start();
        Thread.sleep(100);


        b = 3;
        a = 2;

        Thread.sleep(10000);
    }
}
