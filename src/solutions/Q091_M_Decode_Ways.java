package solutions;

/*
    一条包含字母 A-Z 的消息通过以下方式进行了编码：
        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。
*/
public class Q091_M_Decode_Ways {
//    public static int numDecodings(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) != '0') {
//                break;
//            }
//            if (s.charAt(i) == 0 && i == s.length() - 1) {
//                return 0;
//            }
//        }
//        int result = 1;
//        boolean flag = false;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i - 1) == '0') {
//                continue;
//            }
//            int code = Integer.parseInt(s.substring(i - 1, i + 1));
//            if (code > 0 && code <= 26) {
//                result = flag ? result + 1 : result * 2;
//                flag = true;
//                continue;
//            }
//            flag = false;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String s = "2206";
//        numDecodings(s);
//    }
}
