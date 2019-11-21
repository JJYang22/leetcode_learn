package DataStructure.MyNaryTree;

import DataStructure.Obj.NaryTreeNode.Node;

/**
 * @Author Voidmian
 * @Date 2019/11/19 10:51
 */
public class MaxDepOfNaryTree559 {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        if(root.children == null || root.children.size() == 0)
            return 1;
        int max = Integer.MIN_VALUE;
        for (Node n: root.children
             ) {
            int temp = maxDepth(n);
            if(max < temp){
                max = temp;
            }
        }
        return max + 1;
    }
}
