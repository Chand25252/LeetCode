package solutions;


/*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
*/

/**
 * @author Chand
 * @date 2019-03-12 09:46:11
 */
public class Q014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        while(true) {
            String compareStr = "";
            for(String str : strs) {
                if(str.length() <= index) {
                    return str.substring(0, index);
                }
                String target = String.valueOf(str.charAt(index));
                if("".equals(compareStr)) {
                    compareStr = target;
                } else if(target.equals(compareStr)) {
                    continue;
                } else {
                    return str.substring(0, index);
                }
            }
            index++;
        }
    }
}
