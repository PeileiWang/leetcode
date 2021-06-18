import java.util.concurrent.TimeUnit;

/**
 * @author: wangpeilei
 * @date: 2021/06/07 18:29
 **/
public class LeakBucket {
    public long timeStamp = System.currentTimeMillis();  // 当前时间
    public long capacity; // 桶的容量
    public long rate; // 水漏出的速度
    public long water; // 当前水量(当前累积请求数)

    LeakBucket(long capacity, long rate) {
        this.capacity = capacity;
        this.rate = rate;
    }

    public boolean grantOne() {
        long now = System.currentTimeMillis();

        // 当前流的水量
        long leakWater = (now - timeStamp) * rate;
        water = Math.max(0, water - leakWater);
        timeStamp = now;

        if (water + 1 <= capacity) {
            water++;
            System.out.println("成功！" + "当前water：" + water + ", 当前capacity：" + capacity);
            return true;
        } else {
            System.out.println("失败！" + "当前water：" + water + ", 当前capacity：" + capacity);
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LeakBucket leakBucket = new LeakBucket(100, 10);

        for (int i = 0; i < 1000; i++) {
            leakBucket.grantOne();
        }
        System.out.println("xxx");
        Thread.sleep(2);
        for (int i = 0; i < 1000; i++) {
            leakBucket.grantOne();
        }
    }

}
