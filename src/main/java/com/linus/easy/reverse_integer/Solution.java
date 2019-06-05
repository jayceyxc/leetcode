package com.linus.easy.reverse_integer;

public class Solution {
    public int reverse(int x) {
        long result = 0;
        long input = x;
        boolean negative = false;
        if (x < 0) {
            negative = true;
            input = x * -1L;
        }
        while (input > 0) {
            result = result * 10 + input % 10;
            input = input / 10;
        }

        if (negative) {
            result *= -1;
        }

        if (result < Integer.MIN_VALUE) {
            result = 0;
        } else if (result > Integer.MAX_VALUE) {
            result = 0;
        }

        return Long.valueOf(result).intValue();
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(x);
        System.out.println(new Solution().reverse(x));
        x = Integer.MAX_VALUE;
        System.out.println(x);
        System.out.println(new Solution().reverse(x));
        x = 123;
        System.out.println(new Solution().reverse(x));
        x = -123;
        System.out.println(new Solution().reverse(x));
        x = 120;
        System.out.println(new Solution().reverse(x));
        x = -120;
        System.out.println(new Solution().reverse(x));
        x = 1534236469;
        System.out.println(new Solution().reverse(x));
    }
}
