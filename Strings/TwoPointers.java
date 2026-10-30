/*
    Problem Statement :
    You are given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.
    You can return the answer in any order.
 */

package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoPointers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the target number : ");
        int target = sc.nextInt();
        sc.close();
        twoSum(nums, target);
    }

    public static void twoSum(int[] arr, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        // Improvement : If no element pair can add up to target, return invalid indices
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < arr.length; i++) {
            int rem = t - arr[i];
            if (map.containsKey(rem)) {
                res[0] = i;
                res[1] = map.get(t - arr[i]);
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
