package solutions;

/*
    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
*/


import java.util.ArrayList;
import java.util.List;

/**
 * @author Chand
 * @date 2019-03-19 10:34:46
 */
public class Q028_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        List<Integer> position = new ArrayList<Integer>();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                position.add(i);
            }
        }
        if (position.size() == 0) {
            return -1;
        }
        for (int i = 0; i < position.size(); i++) {
            boolean correct = true;
            int index = position.get(i);
            for (int j = 0; j < needle.length(); j++) {
                if (index < haystack.length() && haystack.charAt(index) == needle.charAt(j)) {
                    index++;
                    continue;
                }
                correct = false;
                break;
            }
            if (correct) {
                return position.get(i);
            }
        }
        return -1;
    }
}
