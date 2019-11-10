package DataStructure.MyHashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/7 17:12
 */
public class HappyNumber202 {
    static public void test(
    ){
        HappyNumber202 happyNumber202 = new HappyNumber202();
        System.out.println(happyNumber202.isHappy(2));
    }

    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        if(n<0)
            n=-n;
        Set<Integer> used = new HashSet<>();
        while (!used.contains(n)){
            used.add(n);
            n=fun(n);
            if(n == 1)
                return true;
        }
        return false;
    }
    private int fun (int n){
        int ans=0;
        while (n!=0){
            ans+=(n%10)*(n%10);
            n/=10;
        }
        return ans;
    }
}
