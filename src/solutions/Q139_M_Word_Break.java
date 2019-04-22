package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
    判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    说明：
        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。
*/
public class Q139_M_Word_Break {

    private static boolean flag = false;

    public static boolean wordBreak(String s, List<String> wordDict) {
        List<String> distinctWordDict = new ArrayList<>();
        for (String word : wordDict) {
            String newWord = distinct(word);
            if (!wordDict.contains(newWord)) {
                distinctWordDict.add(word);
                continue;
            }
            if (!distinctWordDict.contains(newWord)) {
                distinctWordDict.add(newWord);
            }
        }
        partition(s, distinctWordDict, 0);
        return flag;
    }

    private static String distinct(String str) {
        int len = str.length();
        while (len > 0) {
            if (str.length() % len != 0) {
                len--;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                String item = str.substring(0, str.length() / len);
                for (int i = 0; i < len; i++) {
                    sb.append(item);
                }
                if (sb.toString().equals(str)) {
                    return item;
                }
                len--;
            }
        }
        return str;
    }

    private static void partition(String s, List<String> wordDict, int position) {
        if (position == s.length()) {
            flag = true;
            return;
        }
        for (String word : wordDict) {
            if (!flag && position + word.length() <= s.length()
                    && word.equals(s.substring(position, position + word.length()))) {
                partition(s, wordDict, position + word.length());
            }
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        System.out.println(wordBreak(s, wordDict));
    }
}
