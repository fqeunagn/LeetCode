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
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> result = new ArrayList<Double>();
    	if( root == null )
    	{
    		return result;
    	}
    	
        // 使用宽度优先搜索，逐层计算
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	// 从第一层开始，第一层只有root节点
    	queue.offer(root);
    	double sum;
    	int count;
    	TreeNode tmpNode;
    	while( !queue.isEmpty() )
    	{
    		// 此处queue的大小代表当前层次的节点数量，需要按照这个大小统计总数
    		count = queue.size();
    		sum = 0;
    		// 统计当前层；
    		for( int i=0; i<count; i++ )
    		{
    			// 累加数量
    			tmpNode = queue.poll();
    			sum += tmpNode.val;
    			// 将下一层加入队列
    			if( tmpNode.left != null )
    			{
        			queue.offer(tmpNode.left);
    			}
    			if( tmpNode.right != null )
    			{
        			queue.offer(tmpNode.right);
    			}    			
    		}
    		
    		// 计算当前层的平均数
    		result.add(sum/count);
    	}
    	
    	return result;
    }
}
