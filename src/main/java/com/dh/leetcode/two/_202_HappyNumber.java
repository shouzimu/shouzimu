package com.dh.leetcode.two;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * 202. Happy Number
 *
 * https://leetcode.com/problems/happy-number/
 */
public class _202_HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return happy(n, set);
    }

    private boolean happy(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
        int[] a = int2Arry(n);
        int sum = 0;
        for (int i : a) {
            sum += i * i;
        }
        if (!set.add(sum)) {
            return false;
        }
        return happy(sum, set);
    }

    int[] int2Arry(int n) {
        char[] chars = (n + "").toCharArray();
        int[] a = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            a[i] = chars[i] - '0';
        }
        return a;
    }

    public boolean isHappyV2(int n) {
        Set<Integer> set = new HashSet<>();
        int sum, tmp;
        while (set.add(n)) {
            sum = 0;
            while (n > 0) {
                tmp = n % 10;
                sum += tmp * tmp;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }


    @Test
    public void testIsHappy() {
        Assert.assertEquals(isHappyV2(980), isHappy(980));
        Assert.assertEquals(isHappyV2(19), isHappy(19));
    }
}
