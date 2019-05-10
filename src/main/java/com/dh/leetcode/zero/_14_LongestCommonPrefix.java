package com.dh.leetcode.zero;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * 14. Longest Common Prefix
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class _14_LongestCommonPrefix {


    /**
     *
     * 解题思路比较简单，就是从前往后，两两比较出前缀后，继续往后比较
     * 当前缀为空或者到达数组末尾结束
     *
     * AC结果
     *
     * 执行用时 : 4 ms, 在Longest Common Prefix的Java提交中击败了76.78% 的用户
     * 内存消耗 : 36.1 MB, 在Longest Common Prefix的Java提交中击败了87.16% 的用户
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        String prefix = strs[0];
        String current;
        for (int i = 1; i < length; i++) {
            current = strs[i];
            //求出current和prefix的最小前缀，并赋值给prefix
            StringBuilder tmp = new StringBuilder();

            for (int j = 0; j < current.length() && j < prefix.length(); j++) {
                if(prefix.charAt(j) == current.charAt(j)){
                    tmp.append(prefix.charAt(j));
                }else{
                    break;
                }
            }

            prefix = tmp.toString();

            if (Objects.equals(prefix, "")) {
                break;
            }
        }
        return prefix;
    }

    @Test
    public void testLongestCommonPrefix() {
        Assert.assertEquals("fl",longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Assert.assertEquals("",longestCommonPrefix(new String[]{"dog","racecar","car"}));
        Assert.assertEquals("dog",longestCommonPrefix(new String[]{"dog"}));
        Assert.assertEquals("",longestCommonPrefix(new String[]{""}));
        Assert.assertEquals("",longestCommonPrefix(new String[]{}));
        Assert.assertEquals(null,longestCommonPrefix(new String[]{null}));
    }

}
