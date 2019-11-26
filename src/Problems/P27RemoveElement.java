package Problems;

public class P27RemoveElement {

    // [0,1,2,2,3,0,4,2], 2 -> 5
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        // print
        for (int i=0; i<index; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return index;
    }
}
