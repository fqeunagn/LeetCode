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
	public int maxDepth(TreeNode root) {
		if( root == null )
        {
        	return 0;
        }
		
		// 采用更直接的思路，由于这题只需要获取最深深度，按照递归思想，一棵树的最大深度，就是1加上左子树/右子树深度中比较大的那个
		return Math.max( maxDepth( root.left ), maxDepth( root.right ) ) + 1;
	}

	//===========================================================//
	
    public int maxDepth2(TreeNode root) {
        if( root == null )
        {
        	return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        // 通过队列逐层扫下去就好
        int depth = 0;
        int count = 0;
        TreeNode tmp;
        while( !queue.isEmpty() )
        {
        	depth++;
        	count = queue.size();
        	for( int i=0; i<count; i++ )
        	{
        		tmp = queue.poll();
        		if( tmp.left != null )
        		{
        			queue.offer(tmp.left);
        		}
        		if( tmp.right != null )
        		{
        			queue.offer(tmp.right);
        		}
        	}
        }
    	
    	return depth;
    }
}
