package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
    现在你总共有 n 门课需要选，记为 0 到 n-1。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
    给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
    可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    说明:
        输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。
        你可以假定输入的先决条件中没有重复的边。
*/

/**
 * @author Chand
 * @Date: 2019-07-24 10:35:25
 */
public class Q210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            List<Integer> list = null;
            if (!adj.containsKey(prerequisites[i][1])) {
                list = new ArrayList<Integer>();
                list.add(prerequisites[i][0]);
                adj.put(prerequisites[i][1], list);
            } else {
                list = adj.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int position = 0;
        while (!queue.isEmpty()) {
            if (position == numCourses) {
                return new int[0];
            }
            int num = queue.poll();
            List<Integer> list = adj.get(num);
            for (int i = 0; list != null && i < list.size(); i++) {
                if (--inDegree[list.get(i)] == 0) {
                    queue.add(list.get(i));
                }
            }
            result[position++] = num;
        }
        if (position == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
