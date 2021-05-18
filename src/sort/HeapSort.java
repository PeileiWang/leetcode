package sort;

import java.util.Arrays;

/**
 * @author: wangpeilei
 * @date: 2021/05/16 21:23
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sortSmallToBig(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        sortBigToSmall(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sortBigToSmall(int[] arr) {
        for (int i = (arr.length-2) / 2; i >= 0; i--) {
            adjustSmallHeap(arr, i, arr.length);
        }


        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustSmallHeap(arr, 0, i);
        }
    }

    public static void sortSmallToBig(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustBigHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustBigHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * @param arr
     * @param i      当前父节点下标
     * @param length 需要调整的长度范围
     */
    public static void adjustBigHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始

            // 判断是否有右子节点，有的话，如果左子结点小于右子结点，用右子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点
                k++; // k对应的是右子节点
            }

            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k]; // 把子节点的值赋给父节点
                i = k; // 父节点设置为子节点
            } else {
                break; // 否则表示
            }
        }
        arr[i] = temp;//将temp值放到最终的位置 跟 i = k 对应
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 构建小顶堆
     *
     * @param arr
     * @param parentPos
     * @param length
     */
    public static void adjustSmallHeap(int[] arr, int parentPos, int length) {
        int temp = arr[parentPos];

        int cur = parentPos * 2 + 1;

        for (; cur < length; cur = cur * 2 + 1) {

            // 处理，使得cur指向最小子节点
            if (cur + 1 < length && arr[cur + 1] < arr[cur]) {
                cur++;
            }

            if (arr[cur] < temp) {
                arr[parentPos] = arr[cur];
                parentPos = cur;
            } else {
                break;
            }
        }

        arr[parentPos] = temp;
    }
}
