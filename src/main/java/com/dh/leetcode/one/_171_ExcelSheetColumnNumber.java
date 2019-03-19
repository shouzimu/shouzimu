package com.dh.leetcode.one;

import org.junit.Assert;
import org.junit.Test;

/**
 * 171. Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 */
public class _171_ExcelSheetColumnNumber {

    /**
     * 从上面描述来看，本题就是一个很简单的一个26进制转换为10进制
     *
     * AC结果
     *
     * Runtime: 1 ms, faster than 99.91% of Java online submissions for Excel Sheet Column Number.
     * Memory Usage: 34.5 MB, less than 75.94% of Java online submissions for Excel Sheet Column Number.
     */
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (chars[i] - 'A' + 1) * Math.pow(26, length - i - 1);
        }
        return sum;
    }

    @Test
    public void testTitleToNumber() {
        Assert.assertEquals(701, titleToNumber("ZY"));
        Assert.assertEquals(1, titleToNumber("A"));
        Assert.assertEquals(28, titleToNumber("AB"));
    }
}
