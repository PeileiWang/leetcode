package test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangpeilei
 * @date: 2021/05/23 17:45
 **/
public class Test {
    public static void main(String[] args) {

        Object obj = new Object();

        WeakReference<Object> weakReference = new WeakReference<>(obj);


        System.out.println(obj);
        System.out.println(weakReference.get());

        obj = null;

        System.out.println(obj);
        System.out.println(weakReference.get());

        System.gc();

        System.out.println(obj);
        System.out.println(weakReference.get());

        StringBuffer str = new StringBuffer("Hello,程序猿");

        StringBuffer str1 = str;

        str = null;

        System.gc();


        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        System.out.println(str1);

    }

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            swap(nums, i, minPos);
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, i, j - 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
