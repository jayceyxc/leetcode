package com.linus.medium.string_to_integer;

import java.math.BigDecimal;

public class Solution {
    public int myAtoi(String str) {
        BigDecimal result = BigDecimal.ZERO;
        str = str.trim();
        boolean negative = false;
        boolean firstChar = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (firstChar) {
                if (ch == '-') {
                    negative = true;
                    firstChar = false;
                } else if (ch == '+') {
                    firstChar = false;
                } else if ((ch <= '9') && (ch >= '0')) {
                    int value = ch - '0';
                    result = result.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(value));
                    firstChar = false;
                } else {
                    break;
                }
            } else if ((ch <= '9') && (ch >= '0')) {
                int value = ch - '0';
                result = result.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(value));
            } else {
                break;
            }
        }
        if (negative) {
            result = result.negate();
        }
        if (result.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
            result = BigDecimal.valueOf(Integer.MAX_VALUE);
        } else if (result.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
            result = BigDecimal.valueOf(Integer.MIN_VALUE);
        }

        return result.intValue();
    }

    public static void main(String[] args) {
        String s = "-178";
        System.out.println(new Solution().myAtoi(s));
        s = "42";
        System.out.println(new Solution().myAtoi(s));
        s = "   -42";
        System.out.println(new Solution().myAtoi(s));
        s = "4193 with words";
        System.out.println(new Solution().myAtoi(s));
        s = "words and 987";
        System.out.println(new Solution().myAtoi(s));
        s = "-91283472332";
        System.out.println(new Solution().myAtoi(s));
        s = "+-2";
        System.out.println(new Solution().myAtoi(s));
        s = "9223372036854775808";
        System.out.println(new Solution().myAtoi(s));
        System.out.println(Long.MAX_VALUE);
    }
}
