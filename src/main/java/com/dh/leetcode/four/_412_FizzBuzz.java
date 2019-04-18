package com.dh.leetcode.four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * 412. Fizz Buzz
 *
 * https://leetcode.com/problems/fizz-buzz/
 */
public class _412_FizzBuzz {


    /**
     *
     * 此题存灌水，木有任何含量，由于使用了lambda，速度明显太慢
     *
     * AC结果
     * Runtime: 34 ms, faster than 5.56% of Java online submissions for Fizz Buzz.
     * Memory Usage: 38.6 MB, less than 21.04% of Java online submissions for Fizz Buzz.
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        IntStream.rangeClosed(1, n).forEach(i -> {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        });
        return res;
    }

    @Test
    public void testFizzBuzz(){
        fizzBuzz(15);
    }

}
