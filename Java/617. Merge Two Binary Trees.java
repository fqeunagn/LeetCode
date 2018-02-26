/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if( t1 == null )
        {
            return t2;
        }
        
        if( t2 == null )
        {
            return t1;
        }
        /*
        TreeNode tmp = new TreeNode( t1.val + t2.val );
        tmp.left = mergeTrees( t1.left, t2.left );
        tmp.right = mergeTrees( t1.right, t2.right );
        */
        // 没有new，省去了部分空间及时间，但没啥明显的效果
        t1.val += t2.val;
        t1.left = mergeTrees( t1.left, t2.left );
        t1.right = mergeTrees( t1.right, t2.right );
            
        
        return t1;        
    }
}
