package algo.easy.twosum;

/*
 * Problem Statement:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * Assumptions:
 *  1. You may assume that each input would have exactly one solution,
 *  2. and you may not use the same element twice.
 *
 * Example:
 *     Given nums = [2, 7, 11, 15], target = 9,
 *
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *            return [0, 1].
 */
public class FastestOptimalSolution {

    public static void main(String args[]) {
        int a[] = {0, 2147483647};

        int result[] = FastestOptimalSolution.twoSumFastestRunningSolution(a, 2147483647);
        System.out.println("Indices are " + result[0] + "," + result[1]);
    }

    private static int[] twoSumFastestRunningSolution(int[] nums, int target) {
        // Since x1 + x2 = target, we can in one loop
        // mark both x1 and x2 is additional array we we'll keep indices
        // Though to build that array we'd need another loop

        int min = 0, max = 0;
        // first loop to find max and min integers
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min = nums[i];
                max = min;
            } else {
                if (nums[i] < min)
                    min = nums[i];
                if (nums[i] > max)
                    max = nums[i];
            }
        }
        // valid range for input integers relative to target

        int sMin = Math.max(min, target - max);
        int sMax = Math.min(max, target - min);

        // array to keep indices of valid input integers
        // initialize with -1
        int size = 1 + sMax - sMin;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = -1;

        // second loop
        int offset = -sMin;
        for (int i = 0; i < nums.length; i++) {
            // Skip if integer is not from a valid range
            if (nums[i] > sMax || nums[i] < sMin)
                continue;
            // if found valid X1 and corresponding element of indices array is still -1
            // then mark its pair X2 = target - X1 in indices array
            if (arr[nums[i] + offset] == -1)
                arr[target - nums[i] + offset] = i;
            else
                return new int[]{arr[nums[i] + offset], i};
        }

        return new int[]{0, 0};

    }

}
