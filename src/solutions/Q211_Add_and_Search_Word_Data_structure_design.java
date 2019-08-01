package solutions;

/*
    设计一个支持以下两种操作的数据结构：
        void addWord(word)
        bool search(word)
    search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
    示例:
        addWord("bad")
        addWord("dad")
        addWord("mad")
        search("pad") -> false
        search("bad") -> true
        search(".ad") -> true
        search("b..") -> true
    说明:
        你可以假设所有单词都是由小写字母 a-z 组成的。
*/

/**
 * @author Chand
 * @Date: 2019-07-29 09:16:54
 */
public class Q211_Add_and_Search_Word_Data_structure_design {
    private DicTree[] dicTree;

    private boolean result = false;

    private int size = 0;

    class DicTree {
        boolean flag = false;
        DicTree[] nextTree = new DicTree[26];
    }

    /** Initialize your data structure here. */
    public Q211_Add_and_Search_Word_Data_structure_design() {
        dicTree = new DicTree[26];
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        int start = word.charAt(0) - 97;
        if (dicTree[start] == null) {
            dicTree[start] = new DicTree();
        }
        dicTree[start].flag = word.length() == 1 ? true : dicTree[start].flag;
        DicTree temp = dicTree[start];
        for (int i = 1; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            if (temp.nextTree[index] == null) {
                temp.nextTree[index] = new DicTree();
            }
            temp.nextTree[index].flag = i == word.length() - 1 ?  true : temp.nextTree[index].flag;
            temp = temp.nextTree[index];
        }
        size = size < word.length() ? word.length() : size;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        result = false;
        if (word == null || word.length() == 0 || word.length() > size) {
            return false;
        }
        searchForWord(word, 0, dicTree);
        return result;
    }

    private void searchForWord(String word, int n, DicTree[] dictionary) {
        if (result || n == word.length()) {
            return;
        }
        char ch = word.charAt(n);
        if (ch != '.' && dictionary[ch - 97] != null) {
            if (n + 1 == word.length() && dictionary[ch - 97].flag) {
                result = true;
                return;
            }
            searchForWord(word, n + 1, dictionary[ch - 97].nextTree);
        }
        if (ch == '.') {
            for (int i = 0; !result && i < 26; i++) {
                if (dictionary[i] == null) {
                    continue;
                }
                if (n + 1 == word.length() && dictionary[i].flag) {
                    result = true;
                    return;
                }
                searchForWord(word, n + 1, dictionary[i].nextTree);
            }
        }
    }
}
