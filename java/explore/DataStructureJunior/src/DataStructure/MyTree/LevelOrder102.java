package DataStructure.MyTree;

import DataStructure.Obj.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/11/11 16:27
 */
public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            int length = queue.size();
            ans.add(new LinkedList<>());
            for (int i = 0; i < length; i++) {
                TreeNode cur = queue.poll();
                ans.get(level).add(cur.val);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            level++;
        }
        return ans;
    }
}
