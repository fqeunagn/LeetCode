class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		// 通过引入一个Map，存好数字，以及对应的位置，只需要一层遍历就可以完成
		// 题目提醒只会有一个解决方式，意味着数字都是唯一的
		Map<Integer, Integer> check = new HashMap<Integer, Integer>();
		for( int i=0; i<nums.length; i++ )
		{
			if( check.containsKey(target - nums[i]) )
			{
				result[0] = i;
				result[1] = check.get( target - nums[i] );
				return result;
			}
			check.put(nums[i], i);
		}
		
		return result;
	}
	
	//==================================================//
	
    public int[] twoSum2(int[] nums, int target) {
        // 直观的做法，直接两层遍历所有情况，效率比较低
        int[] result = new int[2];
        
        for( int i=0; i<nums.length; i++ )
        {
            for( int j=i+1; j<nums.length; j++ )
            {
                if( nums[i]+nums[j] == target )
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        return result;
    }
}
