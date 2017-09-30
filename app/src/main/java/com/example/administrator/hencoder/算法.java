package com.example.administrator.hencoder;

/**
 * Created by yang.jianan on 2017/09/30 09:29.
 */

public class 算法 {
    public static void main(String[] args) {
        System.out.println("算法: orderSearch --> " + orderSearch(2, new int[]{5, 2, 3, 4, 8}));
        System.out.println("算法: binarySearch --> " + binarySearch(2, new int[]{0, 1, 2, 3, 4, 8}));
    }

    /**
     * 顺序查找平均时间复杂度 O（n）
     *
     * @param searchKey 要查找的值
     * @param array     数组（从这个数组中查找）
     * @return 查找结果（数组的下标位置）
     */
    public static int orderSearch(int searchKey, int[] array) {
        if (array == null || array.length < 1)
            return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchKey) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 二分查找又称折半查找，它是一种效率较高的查找方法。 【二分查找要求】：1. 必须采用顺序存储结构 2. 必须按关键字大小有序排列。
     *
     * @param searchKey 查找元素 *
     * @param array     有序数组 *
     * @return searchKey 的数组下标，没找到返回 - 1
     */
    public static int binarySearch(int searchKey, int[] array) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (searchKey == array[middle]) {
                return middle;
            } else if (searchKey < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 分块查找
     *
     * @param index 索引表，其中放的是各块的最大值
     * @param st    顺序表，
     * @param key   要查找的值
     * @param m     顺序表中各块的长度相等，为 m
     * @return
     */
    public static int blockSearch(int[] index, int[] st, int key, int m) {
        // 在序列 st 数组中，用分块查找方法查找关键字为 key 的记录
        // 1. 在 index[ ] 中折半查找，确定要查找的 key 属于哪个块中
        int i = binarySearch(key, index);
        if (i >= 0) {
            int j = i > 0 ? i * m : i;
            int len = (i + 1) * m;
            // 在确定的块中用顺序查找方法查找 key
            for (int k = j; k < len; k++) {
                if (key == st[k]) {
                    System.out.println("查询成功");
                    return k;
                }
            }
        }
        System.out.println("查找失败");
        return -1;
    }
}
