/**
 * https://leetcode-cn.com/problems/remove-element/
 * 双指针
 */
public class Problem27 {

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {

    }

}
