/**
 * Problem Statement:
 * Given an input string s, reverse the order of the words.

 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

 * Return a string of the words in reverse order concatenated by a single space.

 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */

/*
 * @author Ritabrata
 */

package Strings;

import java.util.Scanner;

public class LC_151_Reverse_words_in_a_String {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input string : ");
        String s = scanner.nextLine();
        scanner.close();
        String result = reverseWordsWithTwoPointers(s);
        System.out.println(result);

        String result1 = reverseWordsWithoutTwoPointers(s);
        System.out.println(result1);
    }

    /** Method 1 : Without 2 pointer approach **/

    private static String reverseWordsWithoutTwoPointers(String s) {
         s = s.trim();
         String[] word = s.split("\\s+");
         StringBuilder sb = new StringBuilder();
         for(int i = word.length - 1; i>=0;i--) {
             sb.append(word[i]).append(" ");
         }
         return sb.toString().trim();
    }


    /** Method 2 : 2 Pointer approach **/

    private static String reverseWordsWithTwoPointers(String s) {
        // Cut any trailing or leading spaces
        s = s.trim();
        String[] words = s.split("\\s+");
        int i = 0, j = words.length - 1;
        while (i <= j) {
            swap(words, words[i], words[j], i, j);
            i++;
            j--;
        }
        return String.join(" ", words);
    }

    public static void swap(String[] words, String s1, String s2, int i, int j) {
        words[i] = s2;
        words[j] = s1;
    }

}
