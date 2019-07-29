public class Solution108 {
    public static void main(String args[])
    {
       int []nums ={-10,-3,0,5,9};

    }
}
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val =x;}
}

class Solution
{
    public  TreeNode sortedArrayToBST(int [] nums)
    {
        return change(nums,0,nums.length-1);
    }
    public  TreeNode change(int [] nums ,int start,int end)
    {
        if(end<start)
            return null;
        int mid=(start+end)/2;
        TreeNode node =new TreeNode( nums [mid]);
        node.left =change(nums,start,mid-1);
        node.right=change(nums,mid+1,end);
        return node;
    }
}