package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
        push(x) -- 将元素 x 推入栈中。
        pop() -- 删除栈顶的元素。
        top() -- 获取栈顶元素。
        getMin() -- 检索栈中的最小元素。
*/

/**
 * @author Chand
 * @date 2019-04-28 14:48:20
 */
public class Q155_Min_Stack {
    private List<Integer> minList = new ArrayList<>();

    private Stack<Integer> itemStack = new Stack<>();

    public Q155_Min_Stack() {

    }

    public void push(int x) {
        itemStack.push(x);
        minList.add(x);
        Collections.sort(minList);
    }

    public void pop() {
        int num = itemStack.pop();
        for (int i = 0; i < minList.size(); i++) {
            if (minList.get(i) == num) {
                minList.remove(i);
                break;
            }
        }
        Collections.sort(minList);
    }

    public int top() {
        return itemStack.peek();
    }

    public int getMin() {
        return minList.get(0);
    }
}
