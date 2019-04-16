package solutions;

/*
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：
        本题中，我们将空字符串定义为有效的回文串。
*/

/**
 * @author Chand
 * @date 2019-04-16 10:17:15
 */
public class Q125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if ((left < 'a' || left > 'z') && (left < '0' || left > '9') && (left < 'A' || left > 'Z')) {
                i++;
                continue;
            }
            if ((right < 'a' || right > 'z') && (right < '0' || right > '9')  && (right < 'A' || right > 'Z')) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
