package solutions;


import java.util.HashMap;
import java.util.Map;

/*
    给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    要求返回这个链表的深拷贝。
    提示：
        你必须返回给定头的拷贝作为对克隆列表的引用。
*/

/**
 * @author Chand
 * @date 2019-04-22 09:40:03
 */
public class Q138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(head.val, head.next, null);
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(head, newHead);
        newHead.next = copyNextNode(nodeMap, head);
        Node tempNode = newHead;
        while (tempNode != null) {
            if (head.random != null) {
                tempNode.random = nodeMap.get(head.random);
            }
            head = head.next;
            tempNode = tempNode.next;
        }
        return newHead;
    }

    private Node copyNextNode(Map<Node, Node> nodeMap, Node origin) {
        if (origin == null) {
            return null;
        }
        Node next = null;
        if (origin.next != null) {
            if (nodeMap.containsKey(origin.next)) {
                next = nodeMap.get(origin.next);
            } else {
                next = new Node(origin.next.val, copyNextNode(nodeMap, origin.next), null);
                nodeMap.put(origin.next, next);
            }
        }
        return next;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;
        public Node() {}
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
