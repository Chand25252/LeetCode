package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，
    例如：
        “ACGAATTCCG”。
    在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
    编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
*/

/**
 * @author Chand
 * @date 2019-05-05 09:36:09
 */
public class Q187_Repeated_DNA_Sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty() || s.length() <= 10) {
            return result;
        }
        Map<String, Boolean> sMap = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            if (sMap.containsKey(str) && !result.contains(str)) {
                result.add(str);
                continue;
            }
            sMap.put(str, true);
        }
        return result;
    }
}
