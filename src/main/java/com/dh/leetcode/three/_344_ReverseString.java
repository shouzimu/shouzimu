package com.dh.leetcode.three;

import org.junit.Test;

/**
 * 344. Reverse String
 * <p>
 * https://leetcode.com/problems/reverse-string/
 */
public class _344_ReverseString {

    public void reverseString(char[] s) {
        if (null == s) {
            return;
        }
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char c = s[length - 1 - i];
            s[length - i - 1] = s[i];
            s[i] = c;
        }
    }

    @Test
    public void testReverseString() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s.length);
    }

}
