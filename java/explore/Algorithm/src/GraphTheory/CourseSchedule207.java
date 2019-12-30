package GraphTheory;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/12/30 14:31
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        CourseSchedule207 courseSchedule207 = new CourseSchedule207();
        int numCourses = 8;
        int[][] prerequisites = {{1, 0}, {2,6},{1,7},{6,4},{7,0},{0,5}};
        System.out.println(courseSchedule207.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int ans = 0;
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
        for (int i = 0; i < numCourses; i++) {
            if (!used.contains(i)) {
                used.add(i);
                if (map.containsKey(i)) {
                    Set<Integer> learned = new HashSet<>();
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i);
                    learned.add(i);
                    while (!queue.isEmpty()) {
                        int length = queue.size();
                        for (int j = 0; j < length; j++) {
                            int temp = queue.poll();
                            if (map.containsKey(temp)) {
                                List<Integer> classes = map.get(temp);
                                for (int course : classes) {
                                    if (learned.contains(course)) {
                                        return false;
                                    }
                                    if (!used.contains(course)) {
                                        if (map.containsKey(course)) {
                                            queue.offer(course);
                                            learned.add(course);
                                        }
                                        used.add(course);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
