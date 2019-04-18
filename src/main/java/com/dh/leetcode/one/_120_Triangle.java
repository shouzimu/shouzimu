package com.dh.leetcode.one;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 120. Triangle
 * 三角形最小路径和
 * https://leetcode.com/problems/triangle/
 *
 * For example, given the following triangle
 *
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *
 * 从顶部向下走，可以往左下或者右下行走，求出路径的最小值
 * 这题属于动态规划
 */
public class _120_Triangle {


    /**
     * triangle[i][j]表示第i行第j个数
     * minNum[i][j]表示triangle[i][j]到各底边路径中，最短路径之和，最终问题就转换成求minNum[0][0]
     */
    public int minimumTotalRecursion(List<List<Integer>> triangle) {
        int m = minimumTotalRecursion(triangle, 0, 0);
        return m;
    }


    /**
     * 递推公式如下
     * x表示第x行，y表示第x行的第y个元素
     if(x==n){
         min = rows[y]
     }else{
         min = min(minLeft,minRight)+rows[y]
     }
     */
    public int minimumTotalRecursion(List<List<Integer>> triangle, int x, int y) {
        List<Integer> rows = triangle.get(x);
        int rowLength = triangle.size();
        if (x == rowLength - 1) {
            return rows.get(y);
        }
        int minLeft = minimumTotalRecursion(triangle, x + 1, y);
        int minRight = minimumTotalRecursion(triangle, x + 1, y + 1);
        return Math.min(minLeft, minRight) + rows.get(y);
    }

    @Test
    public void testMinimumTotalRecursion() {
        List<List<Integer>> testData = new ArrayList<>();
        testData.add(Arrays.asList(new Integer[]{2}));
        testData.add(Arrays.asList(new Integer[]{3, 4}));
        testData.add(Arrays.asList(new Integer[]{5, 6, 7}));
        testData.add(Arrays.asList(new Integer[]{4, 7, 1, 3}));
        testData.add(Arrays.asList(new Integer[]{3, 9, 3, 5, 34}));
        Assert.assertEquals(11, minimumTotalRecursion(testData));
    }
}
