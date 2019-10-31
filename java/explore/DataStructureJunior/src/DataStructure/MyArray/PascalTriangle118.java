package DataStructure.MyArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/31 15:03
 */
public class PascalTriangle118 {
    static public void test() {
        PascalTriangle118 pascalTriangle118 = new PascalTriangle118();
//        List<List<Integer>> ans = pascalTriangle118.generate(5);
//        for (int i = 0; i < ans.size(); i++) {
//            for (int j = 0; j < ans.get(i).size(); j++) {
//                System.out.print(ans.get(i).get(j) + "  ");
//            }
//            System.out.println();
//        }

        List<Integer> ans1 = pascalTriangle118.getRow(4);
        for (int i = 0; i < ans1.size(); i++) {
                System.out.print(ans1.get(i)+ "  ");
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).add(1);
        }
        if (numRows <= 1)
            return ans;
        for (int i = 1; i < numRows; i++) {

            int index1 = 0, index2 = 1;

            while (index2 < ans.get(i - 1).size()) {
                ans.get(i).add( ans.get(i - 1).get(index1++) + ans.get(i - 1).get(index2++));
            }
            ans.get(i).add(1);
        }
        return ans;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex<0)
            return ans;
        ans.add(1);
        if(rowIndex==0)
            return ans;
        ans.add(1);
        if(rowIndex==1)
            return ans;
        for(int i=2;i<=rowIndex;i++) {
            Object[] pre = ans.toArray();
            ans = new ArrayList<>();
            ans.add(1);
            for(int j=1;j<i;j++){
                ans.add((Integer) pre[j-1]+(Integer)pre[j]);
            }
            ans.add(1);
        }

        return ans;
    }

}
