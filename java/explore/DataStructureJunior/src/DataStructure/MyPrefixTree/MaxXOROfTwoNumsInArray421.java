package DataStructure.MyPrefixTree;

/**
 * @Author Voidmian
 * @Date 2019/11/19 16:33
 */
public class MaxXOROfTwoNumsInArray421 {
    public static void main(String[] args) {
        MaxXOROfTwoNumsInArray421 maxXOROfTwoNumsInArray421 = new MaxXOROfTwoNumsInArray421();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(maxXOROfTwoNumsInArray421.findMaximumXOR(nums));
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int i = 0; i < nums.length; i++) {
            root = root.insert(nums[i], 1 << 30);
        }
        return root.findMax(root, root, 1 << 30);
    }

    public class Node {

        public Node zero;
        public Node one;


        private int findMax(Node left, Node right, int temp) {
            if (temp == 0)
                return 0;
            int ans = 0;
            if (left.zero != null && right.one != null && left.one != null && right.zero != null) {
                ans = Math.max(findMax(left.zero, right.one, temp >> 1), findMax(left.one, right.zero, temp >> 1)) + temp;
            } else if (left.one != null && right.zero != null) {
                ans = findMax(left.one, right.zero, temp >> 1) + temp;
            } else if (left.zero != null && right.one != null) {
                ans = findMax(left.zero, right.one, temp >> 1) + temp;
            } else if(left.zero != null && right.zero!= null) {
                ans = findMax(left.zero,right.zero,temp>>1);
            } else if(left.one != null && right.one != null) {
                ans= findMax(left.one,right.one,temp>>1);
            }
            return ans;
        }

        private Node insert(int num, int temp) {
            if (temp == 0)
                return this;
            if ((num & temp) > 0) {
                if (one == null)
                    one = new Node();
                one = one.insert(num, temp >> 1);
            } else {
                if (zero == null)
                    zero = new Node();
                zero = zero.insert(num, temp >> 1);
            }
            return this;
        }
    }
}

