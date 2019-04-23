package solutions;


import java.util.HashMap;
import java.util.Map;

/*
    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
    它应该支持以下操作：
        获取数据 get 和 写入数据 put 。
        获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
        写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
        当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
    进阶:
        你是否可以在 O(1) 时间复杂度内完成这两种操作？
*/

/**
 * @author Chand
 * @date 2019-04-23 17:19:20
 */
public class Q146_LRU_Cache {

    private int capacity;

    private int size = 0;

    private ListNode headNode;

    private ListNode tailNode;

    private Map<Integer, Integer> item = new HashMap<>();

    private Map<Integer, ListNode> nodeMap = new HashMap<>();

    public Q146_LRU_Cache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!item.containsKey(key)) {
            return -1;
        }
        ListNode node = nodeMap.get(key);
        ListNode pre = node.pre;
        ListNode next = node.next;
        if (next == null) {
            return item.get(key);
        }
        if (pre == null) {
            headNode = next;
            headNode.pre = null;
        }
        if (pre != null) {
            pre.next = next;
        }
        next.pre = pre;
        tailNode.next = node;
        node.pre = tailNode;
        node.next = null;
        tailNode = node;
        return item.get(key);
    }

    public void put(int key, int value) {
        if (item.containsKey(key)) {
            item.put(key, value);
            ListNode node = nodeMap.get(key);
            node.val = key;
            nodeMap.put(key, node);
            get(key);
            return;
        }
        ListNode newNode = new ListNode(key);
        item.put(key, value);
        nodeMap.put(key, newNode);
        size++;
        if (size == 1) {
            tailNode = newNode;
        }
        if (size == 2) {
            headNode = tailNode;
            tailNode = newNode;
            headNode.next = tailNode;
            tailNode.pre = headNode;
        }
        if (size > 2) {
            tailNode.next = newNode;
            newNode.pre = tailNode;
            tailNode = tailNode.next;
        }
        if (capacity == 1 && size == 2) {
            item.remove(headNode.val);
            nodeMap.remove(headNode.val);
            headNode = null;
            return;
        }
        if (size > capacity) {
            int oldKey = headNode.val;
            item.remove(oldKey);
            nodeMap.remove(oldKey);
            if (headNode.next != null) {
                headNode = headNode.next;
                headNode.pre = null;
            }
        }
    }

    class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
