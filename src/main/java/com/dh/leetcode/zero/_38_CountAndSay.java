package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 38. Count and Say
 *
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 *
 * 这个题目开始一直读不懂，知道看了评论才明白
 * 序列的值就是读出上一个序列
 * 所以5应该读作
 * 3个1 2个2 1个1
 * 那么6的序列就是： 312211
 *
 * 同理7就是把6的序列读出来
 * 1个3 1个1 2个2 2个1
 * 13112221
 *
 *
 * 题目说输入1<=n<=30 可以猥琐的把所有结果存起来
 */
public class _38_CountAndSay {

    private static String[] cache = new String[31];


    /**
     * 执行结果
     * 执行用时 : 7 ms, 在Count and Say的Java提交中击败了57.95% 的用户
     * 内存消耗 : 35.2 MB, 在Count and Say的Java提交中击败了84.33% 的用户
     *
     * 结果不大理想
     *
     * @param n 输入
     */
    public String countAndSay(int n) {
        cache[1] = "1";
        if (n <= 30) {
            if (null != cache[n] && cache[n].length() > 0) {
                return cache[n];
            }
        }
        //找出缓存中第一个小于n且不为空的值
        int lasySay = n;
        for (int k = 30; k > 0; k--) {
            if (null != cache[k] && cache[k].length() > 0) {
                lasySay = k;
                break;
            }
        }
        String lastSay = cache[lasySay];
        String currentSay;
        for (int k = lasySay; k < n; k++) {
            currentSay = count(lastSay);
            if (k < 31) {
                cache[k + 1] = currentSay;
            }
            lastSay = currentSay;
        }
        return lastSay;

    }

    //312211
    private String count(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        char pre = chars[0];
        char cur;
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            cur = chars[i];
            if (pre == cur) {
                count++;
            } else {
                builder.append(say(count, pre));
                pre = cur;
                count = 1;
            }
        }
        builder.append(say(count, pre));
        return builder.toString();
    }

    private String say(int count, char c) {
        return count + "" + c;
    }

    @Test
    public void testCountAndSay() {
        Assert.assertEquals("1", countAndSay(1));
        Assert.assertEquals("11", countAndSay(2));
        Assert.assertEquals("21", countAndSay(3));
        Assert.assertEquals("1211", countAndSay(4));
        Assert.assertEquals("111221", countAndSay(5));
        Assert.assertEquals("312211", countAndSay(6));
    }

}
