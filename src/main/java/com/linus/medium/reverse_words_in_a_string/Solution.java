package com.linus.medium.reverse_words_in_a_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        String result = "";
        s = s.trim();
        List<String> tokens = Arrays.asList(s.split("\\s"));
        if (tokens.size() > 1) {
            Collections.reverse(tokens);
            StringBuilder stringBuilder = new StringBuilder();
            for (String token : tokens) {
                token = token.trim();
                if (token.length() == 0) {
                    continue;
                }
                stringBuilder.append(token);
                stringBuilder.append(" ");
            }
            return stringBuilder.toString().trim();
        } else {
            return s;
        }
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new Solution().reverseWords(s));
        s = "test";
        System.out.println(new Solution().reverseWords(s));
        s = "    test    aaa    bbb    ";
        System.out.println(new Solution().reverseWords(s));
        s = "     ";
        System.out.println(new Solution().reverseWords(s));
    }
}
