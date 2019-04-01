package solutions;

import java.util.Stack;

/*
    以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
    在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
    此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
    请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
    最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
*/

/**
 * @author Chand
 * @date 2019-04-01 17:24:01
 */
public class Q071_Simplify_Path {
    public String simplifyPath(String path) {
        Stack<String> resultStack = new Stack<>();
        String[] pathArr = path.split("/");
        for (String str : pathArr) {
            if (!str.isEmpty()) {
                if (".".equals(str)) {
                    continue;
                }
                if ("..".equals(str)) {
                    if (!resultStack.empty()) {
                        resultStack.pop();
                    }
                    continue;
                }
                resultStack.push(str);
            }
        }
        String result = "";
        while (!resultStack.empty()) {
            if (result.isEmpty()) {
                result = resultStack.pop();
                continue;
            }
            result = resultStack.pop() + "/" + result;
        }
        return result.isEmpty() ? "/" : "/" + result;
    }
}
