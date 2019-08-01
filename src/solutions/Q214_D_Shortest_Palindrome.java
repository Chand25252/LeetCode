package solutions;

/*
    给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
    找到并返回可以用这种方式转换的最短回文串。
*/

public class Q214_D_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int l = 0;
        if (s.charAt(0) == s.charAt(1)) {
            l = 1;
        }
        String temp = "";
        for (int i = 0; i < s.length() - 1; i++) {
            temp = temp + s.charAt(i) + "#";
        }
        temp = temp + s.charAt(s.length() - 1);
        for (int i = 1; i <= temp.length() / 2; i++) {
            if(isPalindrome(temp, i)) {
                l = i * 2;
            }
        }
        String result = "";
        for (int i = l + 1; i < temp.length(); i++) {
            result = temp.charAt(i) + result;
        }
        result = result + temp;
        return result.replaceAll("#", "");
    }

    private boolean isPalindrome(String s, int start) {
        for (int i = 1; i <= start; i++) {
            if (start + i < s.length() && s.charAt(start + i) == s.charAt(start - i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
