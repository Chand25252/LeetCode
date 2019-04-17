package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
    返回 s 所有可能的分割方案。
*/

/**
 * @author Chand
 * @date 2019-04-17 11:31:03
 */
public class Q131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            results.add(result);
            return results;
        }
        partition(results, result, s);
        return results;
    }

    private void partition(List<List<String>> results, List<String> result, String s) {
        if (s.isEmpty()) {
            results.add(result);
            return;
        }
        if (s.length() == 1) {
            result.add(s);
            results.add(result);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(0, i + 1);
            if (isPalindrome(temp)) {
                List<String> tempList = new ArrayList<>(result);
                tempList.add(temp);
                partition(results, tempList, s.substring(i + 1));
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
