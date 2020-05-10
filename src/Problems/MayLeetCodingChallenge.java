package Problems;

import java.util.*;

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

    // 6th
    // Input: [2,2,1,1,1,2,2]
    // Output: 2
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
            if (v == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++v);
            }
        }
        System.out.println("map = " + map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > nums.length / 2) {
                return key;
            }
        }

        return 0;
    }

    // 7th
    // Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    // Output: true
    private int foundDepth = -1;
    private int foundParentValue = -1;
    private boolean result = false;
    public boolean isCousins(TreeNode root, int x, int y) {

        trace(root, x, y, 0, -1);
        System.out.println("result = " + result);
        return result;
    }

    private void trace(TreeNode node, int x, int y, int depth, int parentValue) {
        if (result || node == null) return;

        if (node.val == x || node.val == y) {
            if (foundDepth == -1) {
                foundDepth = depth;
                foundParentValue = parentValue;
            } else {
                if (foundDepth == depth && foundParentValue != parentValue) {
                    result = true;
                    return;
                }
            }
        }

        depth++;
        trace(node.left, x, y, depth, node.val);
        trace(node.right, x, y, depth, node.val);
    }


    public TreeNode createTestRoot() {
        return new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, new TreeNode(5), null));
    }

    // week 2

    // 1st
    // Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    // Output: false
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i-1][1] - coordinates[i-2][1]) * (coordinates[i][0] - coordinates[i-1][0]) !=
                    (coordinates[i][1] - coordinates[i-1][1]) * (coordinates[i-1][0] - coordinates[i-2][0])) {
                return false;
            }
        }
        return true;
    }

    // 2nd
    // Input: 16 = 1 + 3 + 5 + 7
    // Output: true
    public boolean isPerfectSquare(int num) {

        // <Timeout>
        // int i = 0;
        // int curr = 0;
        // while (curr < num) {
        //     curr += 2 * (i++) + 1;
        // }
        // return curr == num;

        // binary
        long start = 0;
        long end = num;
        while (start < end) {
            long mid = (start + end) / 2;
            if (mid * mid > num) {
                end = mid;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return start * start == num;
    }

    // 3rd
    // Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    // Output: 3
    public int findJudge(int N, int[][] trust) {
        if (N == 1 && trust.length == 0) return 1;

        List<Integer> candidates = new ArrayList<>();
        Set<Integer> fromSet = new HashSet<>();
        int[] countList = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            fromSet.add(trust[i][0]);
            int count = ++countList[trust[i][1]];
            if (count == N-1) {
                candidates.add(trust[i][1]);
            }
        }

        for (Integer candidate : candidates) {
            if (!fromSet.contains(candidate)) {
                return candidate;
            }
        }

        return -1;
    }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {
     }

     TreeNode(int val) {
         this.val = val;
     }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }