package com.linus.hard.longest_consecutive_sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 1;
        int maxLength = 1;
//        int maxStartIndex = 0;
        int startIndex = 0;

        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        List<Integer> input = new ArrayList<>();
        for (int num : nums) {
            input.add(num);
        }
        Collections.sort(input);
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).equals(input.get(i+1))) {
                continue;
            }
            if ((input.get(i) + 1) == input.get(i+1)) {
                length++;
                if (maxLength < length) {
                    maxLength = length;
//                    maxStartIndex = startIndex;
                }
            } else {
//                startIndex = i + 1;
                length = 1;
            }
        }
//        System.out.println(maxStartIndex);
//        System.out.println(maxLength);
//        for (int i = maxStartIndex; i < maxStartIndex + maxLength; i++) {
//            System.out.println(input.get(i));
//        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
        nums = new int[]{1, 4, 100, 5, 89, 6, 90, 91,92, 101, 99};
        System.out.println(new Solution().longestConsecutive(nums));
        nums = null;
        System.out.println(new Solution().longestConsecutive(nums));
        nums = new int[]{0};
        System.out.println(new Solution().longestConsecutive(nums));
        nums = new int[]{1, 1, 1};
        System.out.println(new Solution().longestConsecutive(nums));
        nums = new int[]{1, 2, 0, 1};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
