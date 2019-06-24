package org.angrybeard.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by angry_beary on 2019/6/21.
 * 读取一个文件 :单词 , .
 * 统计次数
 * 打印
 * hello 44
 * workd 23
 * quietness 13
 */
public class BinarySearch {

    //[0, 0, 0, 2, 2, 2, 3, 3, 4, 6, 9]
    public static void main(String[] args) {
        List<Integer> randomNums = getRandomNums(11);
        System.out.println(randomNums);
        System.out.println(binSearch(randomNums, 0, 10, 6));
        System.out.println(binSearch(randomNums, 6));
    }

    // 二分查找普通循环实现
    public static int binSearch(List<Integer> randomNums, int key) {
        int mid = randomNums.size() >> 1;
        if (key == randomNums.get(mid)) {
            return mid;
        }

        int start = 0;
        int end = randomNums.size() - 1;
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (key < randomNums.get(mid)) {
                end = mid - 1;
            } else if (key > randomNums.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static List<Integer> getRandomNums(int bound) {
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i < bound; i++) {
            randomNums.add(new Random().nextInt(bound));
        }

        Collections.sort(randomNums);
        return randomNums;
    }

    // 二分查找递归实现
    public static int binSearch(List<Integer> srcArray, int start, int end, int key) {
        int mid = ((end - start) >> 1) + start;
        if (srcArray.get(mid) == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray.get(mid)) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray.get(mid)) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

}
