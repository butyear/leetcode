package Problems;

import java.util.HashMap;

public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // check if there is subtracted value or not
            Integer value = hashMap.get(nums[i]);
            if (value != null) {
                result[0] = value;
                result[1] = i;
                break;
            }

            // save current index to subtracted value
            int remain = target - nums[i];
            hashMap.put(remain, i);
        }
        return result;
    }
}