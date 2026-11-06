/*
    Problem Statement :
    Given an array nums, you can perform the following operation any number of times:
    Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist,
    choose the leftmost one
    Replace the pair with their sum.
    Return the minimum number of operations needed to make the array non-decreasing.
    An array is said to be non-decreasing if each element is greater than or equal to
    its previous element (if it exists).

 */


package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC_3507_Minimum_Pair_Removal_To_Sort_Array_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0;i<n;i++) {
            nums[i] = sc.nextInt();
        }
        int result = minimumPairRemoval(nums);
        System.out.println("Result is : " + result);
    }

    public static int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int p : nums) {
            list.add(p);
        }
        while (list.size() > 1) {
            boolean isNonDecreasing = true;
            int min = Integer.MAX_VALUE;
            int replaceIndex = -1;
            for (int i = 0;i<list.size()-1; i++) {
                int sum = list.get(i) + list.get(i+1);
                if (sum < min) {
                    replaceIndex = i;
                    min = sum;
                }

                if (list.get(i) > list.get(i+1)) {
                    isNonDecreasing = false;
                }

            }
            if (isNonDecreasing) {
                break;
            }
            count++;
            list.set(replaceIndex, min);
            list.remove(replaceIndex + 1);
        }

        return count;
    }

}
