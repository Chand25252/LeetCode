package solutions;

/*
    给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    如果不存在最后一个单词，请返回 0 。
    说明：一个单词是指由字母组成，但不包含任何空格的字符串。
*/

/**
 * @author Chand
 * @date 2019-03-26 17:40:10
 */
public class Q058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean blankFlag = false;
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                result = blankFlag ? 1 : result + 1;
                blankFlag = false;
                continue;
            }
            blankFlag = true;
        }
        return result;
    }
}
