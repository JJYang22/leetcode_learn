package GraphTheory;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/12/30 19:27
 */
public class CourseScheduleII210 {
    public static void main(String[] args) {
        CourseScheduleII210 courseScheduleII210 = new CourseScheduleII210();
        int numCourses = 3;
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};
        int[] ans = courseScheduleII210.findOrder(numCourses, prerequisites);
        System.out.println();
    }

    private int temp = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> used = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!used.contains(i)) {
                if (map.containsKey(i)) {
                    Set<Integer> needLearn = new HashSet<>();
                    ans = BFS(map, used, needLearn, ans, i);
                    if (ans.length == 0) {
                        return ans;
                    }
                } else {
                    used.add(i);
                    ans[temp++] = i;
                }
            }
        }


        return ans;
    }

    private int[] BFS(HashMap<Integer, List<Integer>> map, Set<Integer> used, Set<Integer> needLearn, int[] ans, int cur) {
        List<Integer> integers = map.get(cur);
        needLearn.add(cur);
        boolean isLearned = true;
        for (int i : integers) {
            if (!used.contains(i)) {
                if (!map.containsKey(i)) {
                    ans[temp++] = i;
                } else {
                    if (needLearn.contains(i)) {
                        isLearned = false;
                    } else {
                        ans = BFS(map, used, needLearn, ans, i);
                        if (ans.length == 0) {
                            return ans;
                        }
                    }
                }
            }
            used.add(i);
        }
        if (!isLearned) {
            return new int[0];
        }
        ans[temp++] = cur;
        used.add(cur);
        return ans;
    }
}
