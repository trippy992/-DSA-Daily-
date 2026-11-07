/*
    Problem Statement :
    Given an integer array nums and an integer k,
    return the k most frequent elements.
    You may return the answer in any order.

 */


package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LC_347_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the array elements : ");
        for (int i = 0;i<n;i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter number of most frequent elements : ");
        int k = sc.nextInt();
        int[] res = topKFrequent(nums, k);
        for (int p : res) {
            System.out.print(p+ " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : nums) {
            map.put(p, map.getOrDefault(p, 1) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int[] res = new int[k];
        int ind = 0;
        while(!pq.isEmpty() && k -- > 0) {
            res[ind++] = pq.poll();
        }
        return res;
    }
}
