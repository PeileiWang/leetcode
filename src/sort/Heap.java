package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/05/17 22:24
 **/
public class Heap {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 110, 23, 12, 432423, 543, 543, 54, 55, 6543, 24, 753, 1, 4, 64, 2, 4, 2, 54, 3, 2, 45};

        int[] ints = minK(arr, 10);
        System.out.println(Arrays.toString(ints));

        int[] ints1 = maxK(arr, 10);
        System.out.println(Arrays.toString(ints1));
    }

    // 最小的k个数，维护大顶堆
    private static int[] minK(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }

        int[] heap = new int[k];

        System.arraycopy(arr, 0, heap, 0, k);

        for (int i = (k - 2) / 2; i >= 0; i--) {
            adjustHeap(heap, i, k);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) { // 当前值比大顶堆的顶小
                heap[0] = arr[i];

                adjustHeap(heap, 0, k);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            swap(heap, 0, i);
            adjustHeap(heap, 0, i);
        }

        return heap;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 调整最大堆
    private static void adjustHeap(int[] heap, int i, int length) {
        int temp = heap[i];

        int cur = i * 2 + 1;

        for (; cur < length; cur = cur * 2 + 1) {
            if (cur + 1 < length && heap[cur + 1] > heap[cur]) {
                cur++;
            }

            if (heap[cur] > temp) {
                heap[i] = heap[cur]; // 子节点的值赋给父节点
                i = cur;
            } else {
                break;
            }
        }
        heap[i] = temp;
    }

    // 最大k个数，用小顶堆
    private static int[] maxK(int[] arr, int k) {
        int[] heap = new int[k];

        System.arraycopy(arr, 0, heap, 0, k);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > heap[0]) {
                heap[0] = arr[i];

                adjustMinHeap(heap, 0, k);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            swap(heap, 0, i);
            adjustMinHeap(heap, 0, i);
        }

        return heap;
    }

    private static void adjustMinHeap(int[] heap, int i, int length) {
        int temp = heap[i];

        for (int cur = i * 2 + 1; cur < length; cur = cur * 2 + 1) {
            if (cur + 1 < length && heap[cur + 1] < heap[cur]) {
                cur++;
            }


            if (heap[cur] < temp) { // 子小于temp
                heap[i] = heap[cur]; // 头等于子
                i = cur;
            } else { // 这里是一直找到 大于等于 头i 的
                break;
            }
        }

        heap[i] = temp;
    }
}
