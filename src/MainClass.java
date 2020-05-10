import Problems.*;

import java.util.Arrays;
import java.util.Stack;

//import P746_Min_Cost_Climbing_Stairs.*;


public class MainClass {

    public static void main(String[] args)  {

        /*
        // P746
        // [10, 15, 20] : 15
        // [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] : 6
        System.out.println(
                new P746MinCostClimbingStairs().minCostClimbingStairs(new int[]{10, 15, 20}));

        // P35
        // [1,3,5,6], 5 : 2
        // [1,3,5,6], 2 : 1
        // [1,3,5,6], 7 : 4
        // [1,3,5,6], 0 : 0
        System.out.println(
                new P35SearchInsertPosition().searchInsert(new int[]{1 ,3 ,5 ,6}, 5));

        // P66
        // [1,2,3] : [1,2,4]
        System.out.println((Arrays.toString(
                new P66PlusOne().plusOne(new int[]{9,9}))));

        // P1
        // [3, 2, 4], 6 : [1, 2]
        // [2, 7, 11, 15], 9 : [0, 1]
        // [0, 4, 3, 0], 0 : [0, 3]
        // [-1,-2,-3,-4,-5], -8 : [2, 4]
        System.out.println(Arrays.toString(
                new P1TwoSum().twoSum(new int[]{-1,-2,-3,-4,-5}, -8)));

        // P7
        // 1534236469 : 0 (overflow)
        // 123450 : 54321
        System.out.println(
                new P7ReverseInteger().reverse(123450));

        // P9
        // 121 : true
        // -12321 : false
        // 10 : false
        System.out.println(
                new P9PalindromeNumber().isPalindrome(2147483647));

        // P21
        // [1,2,4]
        // [1,3,4]
        // -> [1, 1, 2, 3, 4, 4]
        P21MergeTwoSortedLists p21 = new P21MergeTwoSortedLists();
        p21.print(p21.mergeTwoLists(p21.getTestL1(), p21.getTestL2()));

        // P26
        // [0,0,1,1,1,2,2,3,3,4] -> 5
        System.out.println("P26 : " +
                new P26RemoveDuplicatesFromSortedArray().removeDuplicates(
                        new int[] {0,0,1,1,1,2,2,3,3,4}));

        // P27
        // [0,1,2,2,3,0,4,2] -> 5
        System.out.println("P27 : " +
                new P27RemoveElement().removeElement(
                        new int[] {0,1,2,2,3,0,4,2}, 2));

        // P2
        // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 0 -> 8
        // Explanation: 342 + 465 = 807.
        P2AddTwoNumbers p2 = new P2AddTwoNumbers();
        P2AddTwoNumbers.ListNode l1 = p2.makeTestNode(342);
        P2AddTwoNumbers.ListNode l2 = p2.makeTestNode(465);
        p2.print(p2.addTwoNumbers(l1, l2));
        */

        // 30day coding challenge
        LeetCodingChallenge30Day challenge = new LeetCodingChallenge30Day();
        // week1
        System.out.println(challenge.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(challenge.isHappy(25));
        System.out.println(challenge.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        challenge.moveZeroes(new int[]{0, 1, 0, 3, 12});
        System.out.println(challenge.maxProfit(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 5, 6, 10, 9}));
        System.out.println(challenge.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(challenge.countElements(new int[] {1,3,2,3,5,0}));
        // week2
        challenge.printNode(challenge.middleNode(challenge.createTestHead()));
        challenge.backspaceCompare("a#c", "asdf##asdf");
        challenge.testMinStack();
        challenge.diameterOfBinaryTree(challenge.createTestNode());
        challenge.lastStoneWeight(new int[] {10,2, 1});
        challenge.findMaxLength(new int[] {0,1,1,1,1,0,0,0,1});

        // May Coding Challenge
        // week1
        MayLeetCodingChallenge mayChallenge = new MayLeetCodingChallenge();
        mayChallenge.findComplement(5);
        System.out.println(mayChallenge.firstUniqChar("loveleetcode"));
        mayChallenge.firstBadVersion(2126753390);
        System.out.println(mayChallenge.majorityElement(new int[] {2,2,1,1,1,2,2}));
        mayChallenge.isCousins(mayChallenge.createTestRoot(), 4, 3);
        // week2
        mayChallenge.checkStraightLine(new int[][] { {2,2},{3,4},{1, 2}, {1,1},{4,5},{5,6},{7,7}});
        System.out.println("isPerfectSquare = " + mayChallenge.isPerfectSquare(2126753390));
        System.out.println(mayChallenge.findJudge(4, new int[][] { {1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
