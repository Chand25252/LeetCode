package solutions;

import java.util.HashMap;
import java.util.Map;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/

/**
 * @author Chand
 * @date 2019-02-15 09:08:22
 */
public class Q3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        char[] strArr = s.toCharArray();
        int result = 0;
        int count = 0;
        int position = 0;
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for(int i = 0; i < strArr.length; i++) {
            if(countMap.containsKey(strArr[i])) {
                position = position > countMap.get(strArr[i]) ? position : countMap.get(strArr[i]);
                int length = i - position;
                result = result < length ? length : result;
                result = result < count ? count : result;
                count = length;
            } else {
                count++;
            }
            countMap.put(strArr[i], i);
        }
        result = result < count ? count : result;
        return result;
    }
}
