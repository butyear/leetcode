import Problems.*;

import java.util.Arrays;

//import P746_Min_Cost_Climbing_Stairs.*;


public class MainClass {

    public static void main(String[] args)  {

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
    }
}
