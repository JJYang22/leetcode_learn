package MyQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/10/26 16:54
 */
public class OpenLock {
    static public void test() {
        String[] deadends = {"0001","0010","0100","1000","0009","0090","0900","9000"};
        String target = "2222";
        OpenLock openLock = new OpenLock();
        System.out.println(openLock.openLock(deadends, target));

    }

    public int openLock(String[] deadends, String target) {
        Set<String> used = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int ans = -1;
        queue.offer("0000");
        System.out.println(queue.peek());
        for (String str : deadends
        ) {
            if(str.equals("0000"))
                return ans;
            used.add(str);
        }
        used.add("0000");
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    char temp = cur.charAt(j);
                    String new1, new2;
                    if (temp == '0') {
                        new1 = cur.substring(0, j) + "1" + cur.substring(j + 1, 4);
                        new2 = cur.substring(0, j) + "9" + cur.substring(j + 1, 4);
                    } else {
                        if (temp == '9') {
                            new1 = cur.substring(0, j) + "0" + cur.substring(j + 1, 4);
                            new2 = cur.substring(0, j) + "8" + cur.substring(j + 1, 4);
                        } else {
                            new1 = cur.substring(0, j) + (char)(temp - 1) + cur.substring(j + 1, 4);
                            new2 = cur.substring(0, j) + (char)(temp + 1) + cur.substring(j + 1, 4);
                        }
                    }

                    if (new2.equals(target) || new1.equals(target))
                        return ans+1;
                    if (!used.contains(new1)) {
                        queue.offer(new1);
                        used.add(new1);
                    }
                    if (!used.contains(new2)) {
                        queue.offer(new2);
                        used.add(new2);
                    }
                }
            }
        }
        return -1;
    }
}
