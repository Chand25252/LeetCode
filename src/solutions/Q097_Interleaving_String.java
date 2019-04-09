package solutions;

/*
    给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
*/

/**
 * @author Chand
 * @date 2019-04-09 13:38:06
 */
public class Q097_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s3.equals(s2);
        }
        if (s2.isEmpty()) {
            return s3.equals(s1);
        }
        if (s3.isEmpty()) {
            return false;
        }
        boolean result = partition(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, false);
        return result;
    }

    private boolean partition(char[] s1, char[] s2, char[] s3, int l1, int l2, int l3, boolean flag) {
        if (l1 == s1.length && l2 == s2.length) {
            return true;
        }
        if (l1 < s1.length && s1[l1] == s3[l3] && !flag) {
            flag = partition(s1, s2, s3, l1 + 1, l2, l3 + 1, flag);
        }
        if (l2 < s2.length && s2[l2] == s3[l3] && !flag) {
            flag = partition(s1, s2, s3, l1, l2 + 1, l3 + 1, flag);
        }
        return flag;
    }
}
