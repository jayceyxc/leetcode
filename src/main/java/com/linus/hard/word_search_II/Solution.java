package com.linus.hard.word_search_II;

import java.util.*;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();

        int wordMaxLength = 0;
        int wordMinLength = Integer.MAX_VALUE;
        for (String word : words) {
            if (word.length() > wordMaxLength) {
                wordMaxLength = word.length();
            }
            if (word.length() < wordMinLength) {
                wordMinLength = word.length();
            }
        }

        Set<String> dict = new HashSet<>(Arrays.asList(words));
        //the length of x axis direction
        int xLength = board.length;
        //the length of y axis direction
        int yLength = board[0].length;
        System.out.printf("xLength: %d, yLength: %d\n",xLength, yLength);

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                int currLength = 0;
                int iIndex = i;
                int jIndex = j;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(board[iIndex][jIndex]);
                currLength++;
                if (currLength >= wordMinLength && currLength <= wordMaxLength) {
                    if (dict.contains(stringBuilder.toString())) {
                        result.add(stringBuilder.toString());
                    }
                }

            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o', 'a', 'a', 'n'},{'e', 't', 'a', 'e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(new Solution().findWords(board, words));
    }
}
