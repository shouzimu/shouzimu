package com.dh.leetcode.zero;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 17. Letter Combinations of a Phone Number
 * 电话号码的字母组合
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17_LetterCombinationsofaPhoneNumber {

    private static final String[] arry = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    /**
     * 回溯法
     *
     * AC结果
     * 执行用时 : 1 ms, 在Letter Combinations of a Phone Number的Java提交中击败了99.94% 的用户
     * 内存消耗 : 35.3 MB, 在Letter Combinations of a Phone Number的Java提交中击败了84.20% 的用户
     *
     * @param digits 输入
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return res;
        }
        List<String> zu = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if ('2' <= c && '9' >= c) {
                zu.add(arry[c - '0' - 2]);
            }
        }

        combin("", res, zu, 0);
        return res;
    }

    private void combin(String combin, List<String> res, List<String> combinList, int current) {
        if (combin.length() == combinList.size()) {
            res.add(combin);
            return;
        }
        char[] array = combinList.get(current).toCharArray();
        for (int j = 0; j < array.length; j++) {
            combin = combin + array[j];
            combin(combin, res, combinList, current + 1);
            combin = combin.substring(0, combin.length() - 1);
        }

    }

    @Test
    public void testLetterCombinations() {
        List<String> strings = letterCombinations("234");
        for (String string : strings) {
            System.out.println(string + " ");
        }
    }
}
