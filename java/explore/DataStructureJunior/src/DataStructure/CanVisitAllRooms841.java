package DataStructure;


import java.net.ProxySelector;
import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/10/31 9:31
 */
public class CanVisitAllRooms841 {
    static public void test() {
        CanVisitAllRooms841 canVisitAllRooms = new CanVisitAllRooms841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>(List.of(1, 3));
        List<Integer> room2 = new ArrayList<>(List.of(3, 0, 1));
        List<Integer> room3 = new ArrayList<>(List.of(2));
        List<Integer> room4 = new ArrayList<>(List.of(2));

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> used = new HashSet<>();
        Queue<Integer> key = new LinkedList<>();
        key.offer(0);
        while (!key.isEmpty()) {
            int curKey = key.poll();
            used.add(curKey);
            int keyNums = rooms.get(curKey).size();
            for (int i = 0; i < keyNums; i++) {
                int keyInRoom = rooms.get(curKey).get(i);
                if (!used.contains(keyInRoom)) {
                    key.offer(keyInRoom);
                    used.add(keyInRoom);
                }
            }
        }
        if(used.size()==rooms.size())
            return true;
        else
            return false;
    }
}
