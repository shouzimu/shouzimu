package com.dh.leetcode.zero;

import org.junit.Assert;
import org.junit.Test;

/**
 * 74. Search a 2D Matrix
 * 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @date 2019-05-28 23:47
 */
public class _74_Searcha2DMatrix {

    /**
     * 转换为二分查找
     * 二维逻辑转换为一维逻辑
     *
     * 假设二维位m*n
     *
     * i行j列的一纬左标 为m*i+j
     *
     * AC结果
     * 执行用时 : 1 ms, 在Search a 2D Matrix的Java提交中击败了99.64% 的用户
     * 内存消耗 : 38.7 MB, 在Search a 2D Matrix的Java提交中击败了87.48% 的用户
     *
     * 第一次提交由于没有考虑到传入为空的情况，即下面代码m为0的判断，导致一个越界的异常
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix) {
            return false;
        }
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //拆解mid的二维坐标
            int cloumn = mid / n;
            int row = mid % n;
            if (matrix[cloumn][row] == target) {
                return true;
            } else if (matrix[cloumn][row] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void testSearchMatrix() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Assert.assertEquals(false, searchMatrix(new int[][]{}, 1));
        Assert.assertEquals(false, searchMatrix(matrix, 60));
        Assert.assertEquals(true, searchMatrix(matrix, 3));
        Assert.assertEquals(false, searchMatrix(matrix, 13));
        Assert.assertEquals(true, searchMatrix(matrix, 50));
        Assert.assertEquals(true, searchMatrix(matrix, 1));
    }

}
