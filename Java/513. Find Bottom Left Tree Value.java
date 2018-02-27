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
    public int findBottomLeftValue(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	// LinkedList实现的Queue操作备注：
    	// 添加元素到队列尾：add和offer没有任何区别；
    	// 查看但不去除队列头：element：如果Queue为空，则抛出异常；peek：如果Queue为空，则返回null；
    	// 获取队列头：remove：如果Queue为空，则抛出异常；poll：如果Queue为空，则返回null；
    	
    	// 使用一个队列，对树执行从右向左的宽度优先搜索，队列里的最后一个元素就是题目要求的最后一行的最左元素
    	queue.offer(root);
    	TreeNode tmp = null;
    	while( !queue.isEmpty() )
    	{
    		tmp = queue.poll();
    		if( tmp.right != null )
    		{
    			queue.offer(tmp.right);
    		}
    		if( tmp.left != null )
    		{
    			queue.offer(tmp.left);
    		}
    	}
    	return tmp.val;
    }

	//=========================================================//
	
    public int findBottomLeftValue2(TreeNode root) {
    	// 采用前序遍历，每个深度找到的第一个数字都记下来
    	int[] result = new int[2];
    	result[0] = -1;
    	result[1] = -1;
    	
    	search( root, result, 0 );
    	
        return result[0];
    }
    
    private void search( TreeNode node, int[] result, int depth )
    {
    	// 前序遍历，先处理自身，然后左子、右子
    	if( node == null )
    	{
    		return;
    	}
    	
    	// 记录每个深度找到的第一个节点
    	if( result[1] < depth )
    	{
    		result[0] = node.val;
    		result[1] = depth;
    	}
    	
    	search( node.left, result, depth+1 );
    	search( node.right, result, depth+1 );
    }
}
