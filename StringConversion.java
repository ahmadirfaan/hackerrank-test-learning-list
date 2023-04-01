
/**
 * @author irfaanhibatullah
 * @version $Id: StringConversion.java, v 0.1 2023‐04‐01 19.40 irfaanhibatullah Exp $$
 */
public class StringConversion {

    /**
     * |s| is the length of string s. Form a new string b as follows.
     * <p>
     * String b is initially empty.
     * <p>
     * For each i where 1 ≤ i ≤ |s|:
     * <p>
     * Append s[i-1] to the end of b.
     * Reverse the string b.
     * Before creating b, reorder s to produce the b that is the lexicographically maximum possible.
     * <p>
     * Example
     * s = “011”.
     * <p>
     * Reorder s from “011” to “101”. String b is formed as follows
     * <p>
     * b after
     * --------------
     * Operation  Append Reverse
     * ---------  ------ -------
     * 1	         1      1
     * 2          10     01
     * 3          011    110
     * Return "101", the permutation of s that generates the maximum possible b.
     * <p>
     * Function Description
     * <p>
     * Complete the function getOptimalString in the editor below.
     * <p>
     * getOptimalString has the following parameter:
     * <p>
     * s: a string
     * <p>
     * Returns
     * <p>
     * string: the permutation of s that generates the maximal b
     * <p>
     * Constraints
     * - 1 ≤ |s| ≤ 10^5
     * - The string s consists only of characters ‘0’ and ‘1’.
     * <p>
     * Input Format For Custom Testing
     * The first line contains a string, s.
     * <p>
     * Sample Case 0
     * Sample Input For Custom Testing
     * <p>
     * STDIN        FUNCTION
     * -----        --------
     * 1100    →    s = "1100"
     * Sample Output
     * 0101
     * <p>
     * Explanation
     * Using the permutation “0101”:
     * <p>
     * b after
     * --------------
     * Operation  Append Reverse
     * ---------  ------ -------
     * 1	         0      0
     * 2          01     10
     * 3          100    001
     * 4          0011   1100
     * Sample Input For Custom Testing
     * <p>
     * STDIN        FUNCTION
     * -----        --------
     * 111     →    s = "111"
     * Sample Output
     * 111
     * <p>
     * Explanation
     * <p>
     * The result string is already lexicographically maximum.
     * <p>
     * Solution
     * Concepts Covered: strings, loops, and counters, implementation
     * <p>
     * Optimal Solution
     * Since any permutation of string b can be formed.
     * We can fix the lexicographically-maximum-string b by sorting the string s.
     * We then can construct the required string s from string b.
     * The operation of converting string is like
     * <p>
     * 1. appending characters to begin
     * 2. and end one by one.
     * So we will keep 2 pointers at mid of b and move one pointer in a backward direction
     * and the other in a forward direction to construct the final string s.
     */

    public static String getOptimalString(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result.add(String.valueOf(s.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        result = result.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        if (n % 2 != 0) {
            sb.append(result.get(n / 2));
        }
        int i = (n + 1) / 2;
        int j = (n - 2) / 2;
        while (j >= 0 && i < n) {
            sb.append(result.get(i));
            sb.append(result.get(j));
            i += 1;
            j -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getOptimalString("1100")); //Expected output 0101
        System.out.println(getOptimalString("111")); //Expected output 111
        System.out.println(getOptimalString("00001")); //Expected output 00001

    }
}