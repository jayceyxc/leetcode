package com.linus.medium.longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {
        String result;
        int midIndex;
        int leftIndex = 0;
        int rightIndex = 0;
        int resultLeftIndex = 0;
        int resultRightIndex = 0;
        if (s.length() <= 1) {
            return s;
        }
        for (midIndex = 0; midIndex < s.length() - 1; midIndex++) {
            leftIndex = rightIndex = midIndex;
            while ((rightIndex + 1 < s.length()) && (s.charAt(rightIndex) == s.charAt(rightIndex+1))) {
                rightIndex = rightIndex + 1;
            }
            while (leftIndex >= 0 && rightIndex <= s.length() - 1) {
                if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    leftIndex--;
                    rightIndex++;
                } else {
                    break;
                }
            }
            if ((rightIndex - leftIndex - 2) > (resultRightIndex - resultLeftIndex)) {
                resultRightIndex = rightIndex - 1;
                resultLeftIndex = leftIndex + 1;
            }
        }

        System.out.printf("left: %d, right: %d\r\n", resultLeftIndex, resultRightIndex);
        result = s.substring(resultLeftIndex, resultRightIndex + 1);

        return result;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution().longestPalindrome(s));
        s = "cbbd";
        System.out.println(new Solution().longestPalindrome(s));
        s = "abcdcbad";
        System.out.println(new Solution().longestPalindrome(s));
        s = "ccc";
        System.out.println(new Solution().longestPalindrome(s));
    }
}
