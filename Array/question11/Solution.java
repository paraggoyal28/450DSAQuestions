package question11;

public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }
        return -1;
    }
}
