package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 58. Length of Last Word
 *
 * 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * @date 2019-08-26 00:54
 */
public class _58_LengthofLastWord {

    /**
     * 从前往后算法
     *
     * 执行用时 :
     * 2 ms, 在所有 Java 提交中击败了45.02%的用户
     */
    public int lengthOfLastWordV1(String s) {
        if (null == s || "" == s || " " == s) {
            return 0;
        }
        char[] array = s.toCharArray();
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ' ') {
                if (i < array.length - 1 && array[i + 1] != ' ') {
                    length = 0;
                }
            } else {
                length++;
            }
        }
        return length;
    }

    /**
     * 从后往前遍历
     *
     * 执行用时 :
     * 1 ms, 在所有 Java 提交中击败了92.20%的用户
     * 内存消耗 :
     * 35.6 MB, 在所有 Java 提交中击败了81.46%的用户
     */
    public int lengthOfLastWord(String s) {
        if (null == s || "" == s || " " == s) {
            return 0;
        }
        char[] array = s.toCharArray();
        int al = array.length;
        int length = 0;
        for (int i = al - 1; i >= 0; i--) {
            char c = array[i];
            if (c == ' ') {
                //到头了，或则空格的前一个是字符 说明空格结束
                if (i == 0 || (i > 0 && array[i - 1] != ' ')) {
                    //如果测试长度大于0，表示最后一个单词已经计算完毕
                    if (length > 0) {
                        break;
                    }
                }
            } else {
                length++;
            }
        }
        return length;
    }

    @Test
    public void testLengthOfLastWord() {
        Assert.assertEquals(1, lengthOfLastWord("d "));
        Assert.assertEquals(5, lengthOfLastWord("Hello World "));
        Assert.assertEquals(5, lengthOfLastWord("Hello World"));
        Assert.assertEquals(2, lengthOfLastWord(" dw   "));
        Assert.assertEquals(0, lengthOfLastWord("      "));
        Assert.assertEquals(0, lengthOfLastWord("      "));
    }
}
