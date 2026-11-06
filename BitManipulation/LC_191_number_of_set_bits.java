/*
    Problem Description : Given a positive integer n,
     write a function that returns the number of set bits in its binary representation
     (also known as the Hamming weight).
 */

package BitManipulation;

import java.util.Scanner;

public class LC_191_number_of_set_bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to count set bits : ");
        int n = sc.nextInt();
        // Use bit calculation logic
        System.out.println("Calculated hamming weight using bit calculation logic : " + hammingWeight(n));

        // Use Java method
        System.out.println("Calculated hamming weight using Java standard method : " + Integer.bitCount(n));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
