package solutions;

/*
    给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000。
*/

/**
 * @author Chand
 * @date 2019-03-04 13:51:03
 */
public class Q005_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int radius1 = check(s, i, i);
            int radius2 = check(s, i, i + 1);
            if (radius2 == 0 && i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1) && (end - start) == 0) {
                start = i;
                end = i + 1;
            }
            if (radius1 > radius2 && radius1 * 2 > (end - start)) {
                start = i - radius1;
                end = i + radius1;
            }
            if (radius2 > 0 && radius2 >= radius1 && radius2 * 2 > (end - start - 1)) {
                start = i - radius2;
                end = i + radius2 + 1;
            }
        }
        return s.substring(start, end + 1);
    }

    private int check(String s, int i, int j) {
        int radius = 0;
        if (s.charAt(i) != s.charAt(j)) {
            return radius;
        }
        int start = i - 1;
        int end = j + 1;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            radius++;
            start--;
            end++;
        }
        return radius;
    }
}
