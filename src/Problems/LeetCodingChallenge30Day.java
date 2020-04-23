package Problems;

import java.util.ArrayList;
import java.util.List;

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
}