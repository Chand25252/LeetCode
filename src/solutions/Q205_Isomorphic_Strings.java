package solutions;

import java.util.HashMap;
import java.util.Map;


/*
    给定两个字符串 s 和 t，判断它们是否是同构的。
    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    说明:
        你可以假设 s 和 t 具有相同的长度。
*/

/**
 * @author Chand
 * @Date: 2019-07-18 12:04:21
 */
public class Q205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> cMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (cMap.containsKey(key)) {
                if (!cMap.get(key).equals(value)) {
                    return false;
                }
                continue;
            }
            cMap.put(key, value);
        }
        cMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = t.charAt(i);
            char value = s.charAt(i);
            if (cMap.containsKey(key)) {
                if (!cMap.get(key).equals(value)) {
                    return false;
                }
                continue;
            }
            cMap.put(key, value);
        }
        return true;
    }

//     public boolean isIsomorphic(String s, String t) {
//         String sNew = getNewStr(s);
//         String tNew = getNewStr(t);
//         for (int i = 0; i < s.length(); i++) {
//             if (sNew.charAt(i) != tNew.charAt(i)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private String getNewStr(String str) {
//         Map<Character, Integer> sMap = new HashMap<>();
//         String newStr = "";
//         for (int i = 0; i < str.length(); i++) {
//             char key = str.charAt(i);
//             if (sMap.containsKey(key)) {
//                 newStr = newStr + sMap.get(key);
//                 continue;
//             }
//             sMap.put(key, i);
//             newStr = newStr + i;
//         }
//         return newStr;
//     }
}
