import java.util.Stack;

public class Solution71 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.simplifyPath("/sdadf/dfs/s/./..///.."));
    }
}
class Solution {
    public String simplifyPath(String path) {
        String [] paths=path.split("/");
        Stack <String> NormalPath=new Stack<>();
        for (String s:paths) {
            if(s.length()>0 && !s.equals(".")) {
                if(s.equals("..")){
                    if(!NormalPath.isEmpty()) {
                        NormalPath.pop();
                    }
                }else {
                        NormalPath.push(s);
                }
            }
        }
        if(NormalPath.isEmpty()){
            return "/";
        }
        String s="";
        while (!NormalPath.isEmpty()){
            s="/"+NormalPath.pop()+s;
        }
        return s;
    }
}