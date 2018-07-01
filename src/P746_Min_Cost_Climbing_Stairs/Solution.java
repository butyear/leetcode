package P746_Min_Cost_Climbing_Stairs;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = cost[i] + (a < b ? a : b);
            a = b;
            b = temp;
        }

        return a < b ? a : b;
    }
}

