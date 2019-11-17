package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/15 14:21
 */
public class PowXN50 {
    static public void test(){
        PowXN50 powXN50 = new PowXN50();
        powXN50.myPow(2,-2147483648);
    }
    public double myPow(double x, int n) {
        if(n == 0)
            return (double)1;
        if(n<0){
            n=-n;
            x=1/x;
        }
        return fun(x,n);
    }
    private double fun(double x, int n){
        if(x == 0 || x == 1)
            return x;
        if (n == 1)
            return x;
        if (n % 2 == 0){
            return fun(x*x,n/2);
        } else {
            return x*fun(x*x,n/2);
        }
    }
}
