package Problems;

import java.util.*;
import java.util.stream.Collectors;

public class MayLeetCodingChallenge {

    // Week 1
    // 1st
    // Given n = 5, and version = 4 is the first bad version.
    // Then 4 is the first bad version.
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start != end) {
            int half = start + (end - start) / 2;
            boolean isBad = isBadVersion(half);

            if (isBad) {
                end = half;
            } else {
                start = half + 1;
            }
        }
        System.out.println("start = " + start);
        return start;
    }

    private boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

    // 4th
    // Input: 5
    // Output: 2
    // Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
    public int findComplement(int num) {
        String binaryStr = Integer.toBinaryString(num);

        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                reversed.append("0");
            } else {
                reversed.append("1");
            }
        }

        return Integer.parseInt(reversed.toString(), 2);
    }

    // 5th
    // s = "loveleetcode",
    // return 2.
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else if (map.containsKey(key) && map.get(key) != -1){
                map.put(key, -1);
            }
        }

        for (Integer value : map.values()) {
            if (value != -1) return value;
        }
        return -1;
    }
}