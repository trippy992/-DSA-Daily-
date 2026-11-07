/*
    Problem Statement :

    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.

 */

package Strings;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LC_215_Kth_Largest_Element_In_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements : ");
        for (int i = 0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter the value of K : ");
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int p : nums) {
            pq.offer(p);
        }
        while(k --> 1) {
            pq.poll();
        }
        return (!pq.isEmpty() ? pq.peek() : -1);
    }
}
