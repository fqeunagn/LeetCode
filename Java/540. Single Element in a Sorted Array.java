class Solution {
	public int singleNonDuplicate(int[] nums) {
		// 这种解法时间占用1ms，前一种要15ms；
		// 题目要求：Your solution should run in O(log n) time and O(1) space，基本上看到这个时间复杂度就需要想到要用二分法了
		// 题目给出的重要条件：nums是从小到大排序的（这个条件貌似没什么用），除了目标数字，其他数字一定是出现两次
		// 由此可以分析，对于随便一个偶数位置 2k：
		// 1、如果nums[2k]==nums[2k+1]，说明目标数字在他们右边；
		// 2、如果nums[2k]!=nums[2k+1]，换言之，如果nums[2k]==nums[2k-1]，说明目标数字在他们左边；
		// 3、如果同时满足nums[2k]!=nums[2k+1]和nums[2k]!=nums[2k-1]，那这就是目标数字；
		int l = 0, r = nums.length-1, mid;
		// 最终收敛结果，一定是l==r
		while( l != r )
		{
			// 找到中间位置，为了便于分析，固定找到一个偶数位置
			mid = (l + r) / 2;
			if( mid % 2 == 1 )
			{
				mid--;
			}
			
			if( nums[mid] == nums[mid+1] )
			{
				// 如果偶数位置是一对数字的头，那么目标数字在他们右边；
				l = mid+2;
			}else
			{
				// mid有可能是一对数字的尾，也有可能就是目标数字
				// 此处也可以做进一步判断，排除mid就是目标数字的可能，可以省去一定的时间，但是没那必要
				r = mid;
			}
		}
		
		return nums[l];
	}
	
	//===============================================================//
	
    public int singleNonDuplicate2(int[] nums) {
    	// 首先想个办法解决问题
    	// 用一个Set存数字，如果存在就删除，最后剩下的就是目标；
    	// 不过没有贴合题目的要求：O(log n) time and O(1) space
    	Set<Integer> tmp = new HashSet<Integer>(nums.length/2+1);
    	for( int num : nums )
    	{
    		if( tmp.contains(nums) )
    		{
    			tmp.remove(nums);
    		}else
    		{
    			tmp.add(num);
    		}
    	}
    	
        return tmp.toArray(new Integer[0])[0];
    }
}
