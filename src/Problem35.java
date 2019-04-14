/**
 * search-insert-position
 * 二分查找法
 */
public class Problem35 {

    public static int searchInsert(int[] nums, int target) {
        int numsLength = nums.length;
        if (target <= nums[0]) {
            return 0;
        }
        if (target == nums[numsLength - 1]) {
            return numsLength - 1;
        }
        if (target > nums[numsLength - 1]) {
            return numsLength;
        }
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (true) {
            if (leftIndex == rightIndex - 1) {
                return rightIndex;
            }
            int midIndex = (leftIndex + rightIndex) / 2;
            int midNum = nums[midIndex];
            if (midNum == target) {
                return midIndex;
            }
            if (midNum > target) {
                rightIndex = midIndex;
            }
            if (midNum < target) {
                leftIndex = midIndex;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
}
