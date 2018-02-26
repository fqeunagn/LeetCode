class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 题目要求不允许使用额外存储，并给出条件：
    	// 1、题目给出的条件限制，数组长度为n时，数组中的数字范围是1到n
    	// 2、数字要么出现一次，要么出现两次；
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for( int i=0; i<nums.length; i++ )
    	{
    		// 必须要通过某种方式标记数字已经出现过，基于题目给出的限制，对于第i个数字，可以用第nums[i]个数字的值进行标记，可以通过取负数的方式判断
    		if( nums[ Math.abs(nums[i])-1 ] < 0 )
    		{
    			result.add( Math.abs(nums[i]) );
    		}else
    		{
    			nums[ Math.abs(nums[i])-1 ] = -nums[ Math.abs(nums[i])-1 ];
    		}
    		
    	}
    	return result;
    }
	
	//===================================================/
	
    public List<Integer> findDuplicates2(int[] nums) {
        // 先来个直接的解法，通过一个Set判断数字是否曾经存在，如果是则需要放进结果里
    	Set<Integer> check = new HashSet<Integer>();
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for( int num : nums )
    	{
    		if( check.contains(num) )
    		{
    			result.add(num);
    		}
    		check.add(num);
    	}
    	return result;
    }
}
