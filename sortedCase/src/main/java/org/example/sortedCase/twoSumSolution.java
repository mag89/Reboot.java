package org.example.sortedCase;

import java.util.Arrays;

public class twoSumSolution {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;


        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    //O(n*log(n)) + O(n*log(n)) ~ O(2n*log(n)) ~ O(n*log(n))
    public static int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);
        int temp = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {

            temp = target - nums[i];
            int s = Arrays.binarySearch(nums, temp);

            if ((nums[i] + nums[s]) != target) {
                continue;
            } else {
                result[0] = i;
                result[1] = s;
                break;
            }
        }
        return result;
    }

}
