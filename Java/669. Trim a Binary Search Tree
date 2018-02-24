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
    public TreeNode trimBST(TreeNode root, int L, int R) {
    	if( root == null )
    	{
    		return null;
    	}
    	
    	// 非递归处理方式
    	// 先处理根节点，保证根节点有效，由于LR有可能超出树范围，需要进行null判断
    	while( root!=null && (root.val<L || root.val>R) )
    	{
    		if( root!=null && root.val<L )
    		{
    			// 根节点比L小，则左子树可整个抛弃
    			root = root.right;
    		}
    		if( root!=null && root.val>R )
    		{
    			// 根节点比R大，则右子树可整个抛弃
    			root = root.left;
    		}
    	}
    	
    	// 处理整个左子树
    	TreeNode tmp = root;
    	// 从根节点开始，对应的tmp节点必须要满足LR要求
    	while( tmp != null )
    	{
    		// 如果左子有效，则左子的右子必然全部有效，可进而处理左子的左子；
    		// 如果左子无效，则左子的左子必然全部无效，需要将左子的右子上提作为左子，一直提到左子本身有效
			// 由于tmp本身已经满足要求，所以左子只需要判断L，不需要判断R
			while( tmp.left!=null && tmp.left.val<L )
			{
				tmp.left = tmp.left.right;
			}
			tmp = tmp.left;
    	}
    	
    	// 处理整个右子树
    	tmp = root;
    	// 从根节点开始，对应的tmp节点必须要满足LR要求
    	while( tmp != null )
    	{
    		// 如果右子有效，则右子的左子必然全部有效，可进而处理右子的右子；
    		// 如果右子无效，则右子的右子必然全部无效，需要将右子的左子上提作为右子，一直提到右子本身有效
			// 由于tmp本身已经满足要求，所以右子只需要判断R，不需要判断L
			while( tmp.right!=null && tmp.right.val>R )
			{
				tmp.right = tmp.right.left;
			}
			tmp = tmp.right;
    	}
    	
    	return root;
    }
    
    //==================================================//	
    	
    public TreeNode trimBST2(TreeNode root, int L, int R) {
    	// 递归处理方式
    	
        //1、判断自身；
    	if( root == null )
    	{
    		return null;
    	}
    	
    	//2、如果本身比L小，本身不需要保留，由于左树更小，可以整个抛弃，只需要处理右树；
    	if( root.val < L )
    	{
    		return trimBST( root.right,  L,  R);
    	}
    	
    	//3、如果本身比R大，本身不需要保留，由于右树更大，可以整个抛弃，只需要处理左树；
    	if( root.val > R )
    	{
    		return trimBST( root.left,  L,  R);
    	}
    	
    	//4、如果满足要求，则分别处理左右子树；
    	root.left = trimBST( root.left,  L,  R);
    	root.right = trimBST( root.right,  L,  R);
    	return root;
    }    
}
