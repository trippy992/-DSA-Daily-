/*
    Problem Statement :
    You are given a 0-indexed 2D integer array nums.
    Initially, your score is 0.
    Perform the following operations until the matrix becomes empty:
    From each row in the matrix, select the largest number and remove it.
    In the case of a tie, it does not matter which number is chosen.
    Identify the highest number amongst all those removed in step 1. Add that number to your score.
    Return the final score.
 */

package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class LC_2679_Sum_in_a_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows in a matrix : ");
        int m = sc.nextInt();
        System.out.print("Enter number of elements in each row : ");
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.print("Matrix sum is : " + matrixSum(nums));
    }

    public static int matrixSum(int[][] nums) {
        if (nums.length == 1 && nums[0].length == 1) {
            return nums[0][0];
        }
        for(int[] num :nums){
            Arrays.sort(num);
        }
        int result = 0;
        for (int i = 0;i<nums[0].length;i++) {
            int max = nums[0][i];
            for (int j = 0; j<nums.length;j++) {
                if (max < nums[j][i]) {
                    max = nums[j][i];
                }
            }
            result += max;
        }
        return result;
    }
}
