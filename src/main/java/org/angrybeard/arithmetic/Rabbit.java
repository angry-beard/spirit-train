package org.angrybeard.arithmetic;

/**
 * Created by angry_beary on 2019/7/4.
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class Rabbit {

    //1 2 3 4 5 6 7 8 9 10 11 12
    //1 1 2 3 5

    static long pairs(int month) {
        if (month > 2) {
            return (pairs(month - 1) + pairs(month - 2));
        } else {
            return 1;
        }
    }

    static long rabbitNums(int month) {
        int beforeLast = 0, last = 0, sum = 0;
        for (int i = 1; i <= month; i++) {
            if (i < 3) {
                beforeLast = 0;
                last = 1;
            }
            sum = beforeLast + last;
            beforeLast = last;
            last = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 50; i++) {
            long n = pairs(i);
            long m = rabbitNums(i);
            System.out.println("a第" + i + "个月有兔子对数为" + n);
            System.out.println("b第" + i + "个月有兔子对数为" + m);
        }
    }
}
