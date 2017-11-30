package algo.easy.twosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Solution {

    private static int[] originalImplementation(int nums[], int target) {

        Map<Integer, List<Integer>> entryToIndexMap = new HashMap<>();

        int startingTarget = Math.abs(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (startingTarget > nums[i]) {
                startingTarget = nums[i];
            }
            if (entryToIndexMap.containsKey(nums[i])) {
                entryToIndexMap.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                entryToIndexMap.put(nums[i], indices);
            }
        }

        int indicesForTheSum[] = new int[2];

        boolean isNegative = false;
        if (startingTarget < 0 && target < 0) {
            isNegative = true;
        }
        while (isNegative ? startingTarget >= target : startingTarget <= target) {
            int remainingTarget = target - startingTarget;
            if (entryToIndexMap.containsKey(startingTarget) && entryToIndexMap.containsKey(remainingTarget)) {
                if (remainingTarget != startingTarget) {
                    indicesForTheSum[0] = entryToIndexMap.get(startingTarget).get(0);
                    indicesForTheSum[1] = entryToIndexMap.get(remainingTarget).get(0);
                    return indicesForTheSum;
                } else if (entryToIndexMap.get(startingTarget).size() == 2) {
                    indicesForTheSum[0] = entryToIndexMap.get(startingTarget).get(0);
                    indicesForTheSum[1] = entryToIndexMap.get(startingTarget).get(1);
                    return indicesForTheSum;
                } else {
                    startingTarget++;
                }
            } else {
                startingTarget++;
            }
        }
        return indicesForTheSum;
    }

    public static int[] moreOptimalSolution(int nums[], int target) {

        Map<Integer, Integer> entryToIndexMap = new HashMap<>();

        int indicesForTheSum[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (entryToIndexMap.containsKey(target - nums[i])) {
                return new int[]{i, entryToIndexMap.get(target - nums[i])};
            } else {
                entryToIndexMap.put(nums[i], i);
            }
        }
        return indicesForTheSum;
    }


    public static void main(String args[]) {
        int a[] = {0, 2147483647};

        int result[] = Solution.originalImplementation(a, 2147483647);
        System.out.println("Indices are " + result[0] + "," + result[1]);
    }


}


