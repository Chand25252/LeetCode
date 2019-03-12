package solutions;

/*
    给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
*/

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chand
 * @date 2019-03-11 14:40:41
 */
public class Q13_Roman_to_Integer {
    public int romanToInt(String s) {
        Map<String, Integer> roman_map = new HashMap<String, Integer>();
        roman_map.put("M", 1000);
        roman_map.put("CM", 900);
        roman_map.put("D", 500);
        roman_map.put("CD", 400);
        roman_map.put("C", 100);
        roman_map.put("XC", 90);
        roman_map.put("L", 50);
        roman_map.put("XL", 40);
        roman_map.put("X", 10);
        roman_map.put("IX", 9);
        roman_map.put("V", 5);
        roman_map.put("IV", 4);
        roman_map.put("I", 1);
        roman_map.put("", 0);
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = roman_map.get(String.valueOf(s.charAt(i)));
            if(temp > 0) {
                if(current > temp) {
                    result = result + current - temp;
                    temp = 0;
                } else {
                    result = result + temp;
                    temp = current;
                }
            } else {
                temp = current;
            }
        }
        result = result + temp;
        return result;
    }

}
