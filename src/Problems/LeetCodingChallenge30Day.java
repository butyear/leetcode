package Problems;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCodingChallenge30Day {

    // Week 1

    // 1st
    // Input: [4,1,2,1,2]
    // Output: 4
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    // 2nd
    // Input: 19
    // Output: true
    private List<Integer> happyList = new ArrayList<>();
    public boolean isHappy(int n) {
        happyList.clear();

        while (n != 1) {
            n = getHappyValue(n);
            if (happyList.contains(n)) {
                return false;
            }
            happyList.add(n);
        }

        return true;
    }

    private int getHappyValue(int n) {
        int result = 0;
        while (n >= 10) {
            int remain = n % 10;
            result += remain * remain;
            n = n / 10;
        }
        result += n * n;
        return result;
    }

    // 3rd
    // Input: [-2,1,-3,4,-1,2,1,-5,4],
    // Output: 6
    // Explanation: [4,-1,2,1] has the largest sum = 6.
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int prevMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prevMax < 0) {
                prevMax = nums[i];
                if (prevMax > max) max = prevMax;
                continue;
            }

            prevMax = prevMax + nums[i];
            if (nums[i] >= 0) {
                if (prevMax > max) max = prevMax;
            }
        }
        return max;
    }

    // 4th
    // Input: [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        int gap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                gap++;
            } else {
                nums[i - gap] = nums[i];
            }
        }

        for (int i = nums.length - gap; i < nums.length; i++) {
            nums[i] = 0;
        }

        // print
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    // 5th
    // Input: [7,1,5,3,6,4]
    // Output: 7
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int sum = 0;
        int prev = prices[0];
        int start = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prev) {
                sum += prev - start;
                start = prices[i];
            }
            prev = prices[i];
        }
        sum += prices[prices.length - 1] - start;

        return sum;
    }

    // 6th
    // Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    //Output:
    //  [
    //    ["ate","eat","tea"],
    //    ["nat","tan"],
    //    ["bat"]
    //  ]
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> listHashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = String.valueOf(charArray);

            if (listHashMap.containsKey(sortedStr)) {
                listHashMap.get(sortedStr).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                listHashMap.put(sortedStr, list);
            }
        }

        return new ArrayList(listHashMap.values());
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();

        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);

        return String.valueOf(charArrayA).equals(String.valueOf(charArrayB));
    }

    // 7th
    // Input: arr = [1,3,2,3,5,0]
    // Output: 3
    private Set<Integer> countSet = new HashSet<>();

    public int countElements(int[] arr) {
        int result = 0;
        for (int i : arr) {
            countSet.add(i);
        }
        for (int i : arr) {
            if (countSet.contains(i + 1)) result++;
        }

        return result;
    }

    // Week 2

    // 1st
    // Input: [1,2,3,4,5]
    // Output: Node 3 from this list (Serialization: [3,4,5])
    public Week2ListNode middleNode(Week2ListNode head) {
        Week2ListNode[] nodes = new Week2ListNode[100];
        int i = 0;
        while (head != null) {
            nodes[i++] = head;
            head = head.next;
        }
        return nodes[i / 2];
    }

    public Week2ListNode createTestHead() {
        return new Week2ListNode(1, new Week2ListNode(2, new Week2ListNode(3, new Week2ListNode(4, new Week2ListNode(5, new Week2ListNode(6))))));
    }

    public void printNode(Week2ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    // 2nd
    // Input: S = "a##c", T = "#a#c"
    // Output: true
    public boolean backspaceCompare(String S, String T) {

        char[] charArray = S.toCharArray();
        int pointer = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '#') {
                charArray[pointer] = charArray[i];
                pointer++;
            } else {
                if (pointer > 0) {
                    pointer--;
                }
            }
        }
        S = String.valueOf(charArray, 0, pointer);

        charArray = T.toCharArray();
        pointer = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '#') {
                charArray[pointer] = charArray[i];
                pointer++;
            } else {
                if (pointer > 0) {
                    pointer--;
                }
            }
        }
        T = String.valueOf(charArray, 0, pointer);

        return S.equals(T);
    }

    // 3rd
    // Input
    // ["MinStack","push","push","push","getMin","pop","top","getMin"]
    // [[],[-2],[0],[-3],[],[],[],[]]
    // Output
    // [null,null,null,null,-3,null,0,-2]
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minStack.getMin() = " + minStack.getMin());
        minStack.pop();
        System.out.println("minStack.top() = " + minStack.top());
        System.out.println("minStack.getMin() = " + minStack.getMin());
    }

    // 4th
    //      1
    //     / \
    //    2   3
    //   / \
    //  4   5
    // Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
    private int max = 0;
    public int diameterOfBinaryTree(Day30TreeNode root) {
        trace(root);
        return max;
    }

    private int trace(Day30TreeNode node) {
        if (node == null) return 0;

        int maxLength = 0;
        if (node.left != null && node.right != null) {
            int leftDepth = trace(node.left);
            int rightDepth = trace(node.right);
            int maxValue = leftDepth + rightDepth + 2;

            if (maxValue >= max) max = maxValue;
            maxLength = Math.max(leftDepth, rightDepth) + 1;
        } else if (node.left != null) {
            int leftDepth = trace(node.left);
            maxLength = leftDepth + 1;
            if (maxLength >= max) max = maxLength;
        } else if (node.right != null) {
            int rightDepth = trace(node.right);
            maxLength = rightDepth + 1;

            if (maxLength >= max) max = maxLength;
        }
        return maxLength;
    }

    public Day30TreeNode createTestNode() {
        return new Day30TreeNode(1, new Day30TreeNode(2, new Day30TreeNode(4), new Day30TreeNode(5)), new Day30TreeNode(3));
    }

    // 5th
    // Input: [2,7,4,1,8,1]
    // Output: 1
    // 1, 1, 2, 4, 7, 8
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());

        while(list.size() > 1) {
            int len = list.size();
            int diff = list.get(len - 1) - list.get(len - 2);

            list.remove(len - 1);
            list.remove(len - 2);
            if (diff != 0) {

                for (int i=0; i<list.size(); i++) {
                    if (diff < list.get(i)) {
                        list.add(i, diff);
                        break;
                    } else if (i == list.size() - 1) {
                        list.add(diff);
                        break;
                    }
                }

                if (list.size() == 0) list.add(diff);
            }
        }

        if (list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }

    // 6th
    // Input: [0,1,1,1,1,0,0,0,1]
    // Output: 8
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> positionMap = new HashMap<>();

        positionMap.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else if (nums[i] == 1) {
                sum++;
            }

            if (!positionMap.containsKey(sum)) {
                positionMap.put(sum, i);
            } else {
                int firstIndex = positionMap.get(sum);
                max = Math.max(max, i - firstIndex);
            }
        }

        System.out.println("max = " + max);
        return max;
    }
}

class MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valueStack.push(x);
        if (minStack.size() > 0) {
            Integer min = minStack.peek();
            if (x < min) {
                minStack.push(x);
            } else {
                minStack.push(min);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class Week2ListNode {
    int val;
    Week2ListNode next;

    Week2ListNode() {
    }

    Week2ListNode(int val) {
        this.val = val;
    }

    Week2ListNode(int val, Week2ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Day30TreeNode {
    int val;
    Day30TreeNode left;
    Day30TreeNode right;

    Day30TreeNode() {
    }

    Day30TreeNode(int val) {
        this.val = val;
    }

    Day30TreeNode(int val, Day30TreeNode left, Day30TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}