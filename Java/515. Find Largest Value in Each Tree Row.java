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
    public List<Integer> largestValues(TreeNode root) {
        // 这题居然有空值输入，不地道，以后还是随手加上非空校验吧
    	if( root == null )
    	{
    		return new ArrayList<Integer>();
    	}
        
        // 宽度优先搜索，通过一个队列记录每层节点，并得出最大值
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	int size;
    	int tmp;
    	TreeNode node;
    	List<Integer> result = new ArrayList<Integer>();
    	while( !queue.isEmpty() )
    	{
    		// 记录当前层次节点数量
    		size = queue.size();
    		tmp = Integer.MIN_VALUE;
    		// 按当前层数量处理当前层所有节点
    		while( size-- > 0 )
    		{
    			node = queue.poll();
    			tmp = node.val>tmp ? node.val : tmp;
    			//将下一层的节点加入队列
    			if( node.left != null )
    			{
    				queue.offer(node.left);
    			}
    			if( node.right != null )
    			{
    				queue.offer(node.right);
    			}
    		}
    		result.add(tmp);
    	}
    	
    	return result;
    }
}
