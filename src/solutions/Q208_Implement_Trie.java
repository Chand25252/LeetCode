package solutions;

import java.util.HashSet;
import java.util.Set;


/*
    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
    示例:
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    说明:
        你可以假设所有的输入都是由小写字母 a-z 构成的。
        保证所有输入均为非空字符串。
*/

/**
 * @author Chand
 * @Date: 2019-07-23 22:03:32
 */
public class Q208_Implement_Trie {
    private Set<String> trieSet = new HashSet<>();

    private Node node = new Node();

    class Node {
        boolean val = false;
        Node[] nodeArr = new Node[26];

        public Node() {}
    }

    public Q208_Implement_Trie() {
    }

    public void insert(String word) {
        trieSet.add(word);
        Node temp = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97;
            if (temp.nodeArr[index] == null) {
                Node node = new Node();
                temp.nodeArr[index] = node;
            }
            temp.nodeArr[index].val = true;
            temp = temp.nodeArr[index];
        }
    }

    public boolean search(String word) {
        return trieSet.contains(word);
    }

    public boolean startsWith(String prefix) {
        Node temp = this.node;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 97;
            if (temp.nodeArr[index] != null && temp.nodeArr[index].val == true) {
                temp = temp.nodeArr[index];
            } else {
                return false;
            }
        }
        return true;
    }
}
