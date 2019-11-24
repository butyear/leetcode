package Problems;

public class P26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int curr = nums[0];
        int x = curr - 1;
        int count = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == curr) {
                nums[i] = x;
            } else {
                count++;
                curr = nums[i];
            }
        }

        int index = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != x) {
                nums[index++] = nums[i];
            }
        }

        // print
        for (int i=0; i<count; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return count;
    }
}
