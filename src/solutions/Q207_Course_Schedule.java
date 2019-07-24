package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/*
    现在你总共有 n 门课需要选，记为 0 到 n-1。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
    给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
    说明:
        输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。
        你可以假定输入的先决条件中没有重复的边。
*/

/**
 * @author Chand
 * @Date: 2019-07-23 19:37:23
 */
public class Q207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] coursesArr = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            coursesArr[prerequisites[i][0]]++;
            if (adj.containsKey(prerequisites[i][1])) {
                ArrayList list = adj.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(prerequisites[i][0]);
            adj.put(prerequisites[i][1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < coursesArr.length; i++) {
            if (coursesArr[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.size() == 0) {
            return false;
        }
        int count = numCourses;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            ArrayList<Integer> list = adj.get(i);
            for (int j = 0; list != null && j < list.size(); j++) {
                if (--coursesArr[list.get(j)] == 0) {
                    queue.add(list.get(j));
                }
            }
            count--;
            if (count > 0 && queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
