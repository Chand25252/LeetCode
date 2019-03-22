package solutions;

import java.util.*;

/*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
*/


/**
 * @author Chand
 * @date 2019-03-22 18:07:35
 */
public class Q049_Group_Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String sortStr = String.valueOf(chArr);
            if (strMap.containsKey(sortStr)) {
                List<String> result = strMap.get(sortStr);
                result.add(strs[i]);
                strMap.put(sortStr, result);
            } else {
                List<String> result = new ArrayList<>();
                result.add(strs[i]);
                strMap.put(sortStr, result);
            }
        }
        List<List<String>> results = new ArrayList<List<String>>(strMap.values());
        return results;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strArr);
    }
}
