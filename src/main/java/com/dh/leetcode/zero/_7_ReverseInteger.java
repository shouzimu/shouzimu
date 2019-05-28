package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;


/**
 * 7. Reverse Integer
 *
 * 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @date 2019-05-19 10:05
 */
public class _7_ReverseInteger {

    /**
     * AC结果
     * 执行用时 : 23 ms, 在Reverse Integer的Java提交中击败了58.25% 的用户
     * 内存消耗 : 34.6 MB, 在Reverse Integer的Java提交中击败了77.82% 的用户
     */
    public int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        char[] a = String.valueOf(x).replace("-", "").toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i < (a.length) / 2) {
                char y = a[i];
                a[i] = a[a.length - i - 1];
                a[a.length - i - 1] = y;
            }
            builder.append(a[i]);
        }
        Long y = Long.valueOf(builder.toString());
        if (x < 0) {
            y = 0 - y;
        }
        if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
            y = 0l;
        }
        return y.intValue();
    }

    @Test
    public void testReverse() {
        Assert.assertEquals(-321, reverse(-123));
        Assert.assertEquals(-4321, reverse(-1234));
        Assert.assertEquals(0, reverse(Integer.MIN_VALUE));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(4321, reverse(1234));
    }

}
