package solutions;

/*
    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母在一个单词中不允许被重复使用。
    说明:
        你可以假设所有输入都由小写字母 a-z 组成。
*/

public class Q212_D_Word_Search_II {
    private DicTree[] dicTree;

    private boolean result = false;

    private int size = 0;

    class DicTree {
        boolean flag = false;
        DicTree[] nextTree = new DicTree[26];
    }

    /** Initialize your data structure here. */
    public Q212_D_Word_Search_II() {
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
