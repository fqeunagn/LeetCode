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
    public TreeNode constructMaximumBinaryTree(int[] nums) 
    {
    	// 这种做法和一开始的做法其实类似，只是代码更为明朗
    	if( nums==null || nums.length==0 )
    	{
    		return null;
    	}
    	
        // 使用另一个递归方法
    	return constructMaximumBinaryTree( nums, 0, nums.length-1 );
    }
    
    private TreeNode constructMaximumBinaryTree( int[] nums, int left, int right )
    {
    	if( left > right )
    	{
    		return null;
    	}
    	
    	int maxIndex = getMax( nums, left, right );
    	TreeNode result = new TreeNode(nums[maxIndex]);
    	
    	//递归处理
    	result.left = constructMaximumBinaryTree( nums, left, maxIndex-1 );
    	result.right = constructMaximumBinaryTree( nums, maxIndex+1, right );
    	
    	return result;
    }
    
    private int getMax( int[] nums, int left, int right )
    {
    	int maxIndex = left;
    	for( int i=left; i<=right; i++ )
    	{
    		if( nums[i] > nums[maxIndex] )
    		{
    			maxIndex = i;
    		}
    	}
    	
    	return maxIndex;
    }	
    
    //========================================================//
    
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
    	
    	//check null
    	if( nums==null || nums.length==0 )
    	{
    		return null;
    	}
    	
    	//找到最大数字及其位置
    	int maxIndex = 0;
    	int max = 0;
    	for( int i=0; i<nums.length; i++ )
    	{
    		if( nums[i] > max )
    		{
    			max = nums[i];
    			maxIndex = i;
    		}
    	}
    	TreeNode result = new TreeNode(max);
    	
    	//以最大值为分割，将数组左右分割两份
    	int[] left = new int[maxIndex];
    	int[] right = new int[nums.length-maxIndex-1];
    	
    	for( int i=0; i<maxIndex; i++ )
    	{
    		left[i] = nums[i];
    	}
  
    	for( int i=maxIndex+1; i<nums.length; i++ )
    	{
    		right[i-maxIndex-1] = nums[i];
    	}
    	
    	//递归分割处理
    	result.left = constructMaximumBinaryTree( left );
    	result.right = constructMaximumBinaryTree( right );
    	
    	return result;
    }	
}
