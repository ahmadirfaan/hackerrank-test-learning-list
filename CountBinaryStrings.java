
/**
 * @author irfaanhibatullah
 * @version $Id: CountBinaryStrings.java, v 0.1 2023‐04‐01 19.35 irfaanhibatullah Exp $$
 */
public class CountBinaryStrings {

    /**
     * Given a binary string s, return the number of non-empty substrings that have
     * the same number of 0's and 1's,
     * and all the 0's and all the 1's in these substrings are grouped consecutively.
     * Substrings that occur multiple times are counted the number of times they occur.
     */

    /**
     * Example 1
     * Input: s = "00110011"
     * Output: 6
     * Explanation: There are 6 substrings that have equal number of
     * consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
     * Notice that some of these substrings repeat and are counted the number of times they occur.
     * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     *
     */

    /**
     * Example 2:
     *
     * Input: s = "10101"
     * Output: 4
     * Explanation:
     * There are 4 substrings:
     * "10", "01", "10", "01"
     * that have equal number of consecutive 1's and 0's.
     */
    public static void main(String[] args) {
        System.out.println(getSubstringCount("001100011")); //expected 6
        System.out.println(getSubstringCount("000110")); //expected 3
        System.out.println(getSubstringCount("010101010")); //expected 8
    }

    public static int getSubstringCount(String s) {
        // Write your code here
        int curr = 1;
        int prev = 0;
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                sum += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        sum += Math.min(prev, curr);
        return sum;
    }
}