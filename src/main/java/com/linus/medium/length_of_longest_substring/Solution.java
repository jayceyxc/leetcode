package com.linus.medium.length_of_longest_substring;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String maxSubString = "";
        String subString = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (subString.indexOf(ch) == -1) {
                subString += ch;
                if (maxLength < subString.length()) {
                    maxLength = subString.length();
                    maxSubString = subString;
                }
            } else {
                int index = subString.indexOf(ch);
                subString = subString.substring(index + 1);
                subString += ch;
                if (maxLength < subString.length()) {
                    maxLength = subString.length();
                    maxSubString = subString;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
        s = "pwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
