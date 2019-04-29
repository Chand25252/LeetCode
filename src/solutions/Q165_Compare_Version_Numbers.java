package solutions;

/*
    比较两个版本号 version1 和 version2。
    如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
    你可以假设版本字符串非空，并且只包含数字和 . 字符。
    . 字符不代表小数点，而是用于分隔数字序列。
    例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
    你可以假设版本号的每一级的默认修订版号为 0。
    例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。
    其第三级和第四级修订号均为 0。
    提示：
        版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
        版本字符串不以点开始或结束，并且其中不会有两个连续的点。
*/

/**
 * @author Chand
 * @date 2019-04-29 09:33:23
 */
public class Q165_Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < str1.length || j < str2.length) {
            String temp1 = i >= str1.length ? "0" : str1[i];
            String temp2 = j >= str2.length ? "0" : str2[j];
            if (Long.valueOf(temp1) == Long.valueOf(temp2)) {
                i++;
                j++;
                continue;
            }
            if (Long.valueOf(temp1) > Long.valueOf(temp2)) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
