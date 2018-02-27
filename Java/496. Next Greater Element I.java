class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		// 通过一个Map存储nums2中每个数字的nextGreater
		Map<Integer, Integer> greateMap = new HashMap<Integer, Integer>();
		// 通过一个栈解决回溯效率太低的问题
		Stack<Integer> tmp = new Stack<Integer>();
		
		for( int num : nums2 )
		{
			// 检查stack，一直提取直到栈顶比现在这个数字大
			// 这些数字都是比num小的，他们的nextGreater都是num
			while( !tmp.isEmpty() && tmp.peek()<num )
			{
				greateMap.put(tmp.pop(), num);
			}
			// 把当前数字入栈
			tmp.push(num);
		}
		
		for( int i=0; i<nums1.length; i++ )
		{
			// 直接把nums1当成结果使用
			if( greateMap.containsKey(nums1[i]) )
			{
				nums1[i] = greateMap.get(nums1[i]);
			}else
			{
				nums1[i] = -1;
			}
		}
		return nums1;
	}
	
	//===============================================================//
	
	public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
		// 研究新的解决办法
		// 通过一个Map存储nums2中每个数字的nextGreater
		// 另外说一声，这个方法耗时居然高达114ms，简直感人，前面一个方法11ms，后面一个用栈的12ms
		Map<Integer, Integer> greateMap = new HashMap<Integer, Integer>();
		
		// 遍历nums2，对于每个数字，往前追溯，
		// 如果前面的数字比他小，那么前面数字的nextGreater就是当前数字
		// 已经记录了nextGreater的，不能覆盖
		for( int i=0; i<nums2.length; i++ )
		{
			for( int j=i-1; j>=0; j-- )
			{
				if( greateMap.containsKey(nums2[j]) || nums2[j]>nums2[i] )
				{
					// 注意这里要用continue，不能用break，因为前面可能还有没判断过的，必须一直遍历到头
					// 这也是为什么使用stack更好的原因，stack在满足同样需求的同时，及时丢弃了无效数据，免除很多不必要的遍历
					continue;
				}
				greateMap.put(nums2[j], nums2[i]);
			}
		}
		
		// 遍历nums1，填充返回结果
		int[] result = new int[nums1.length];
		for( int i=0; i<nums1.length; i++ )
		{
			// 如果是JDK8，可以直接使用greateMap.getOrDefault(nums1[i], -1)，更为简洁
			if( greateMap.containsKey(nums1[i]) )
			{
				result[i] = greateMap.get(nums1[i]);
			}else
			{
				result[i] = -1;
			}
		}
		 
		return result; 
	}
	
	//===============================================//
	
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    	int[] result = new int[nums1.length];
    	// 最直接的做法，在nums2里面找到num的位置，然后继续向后遍历找到更大的值
    	boolean findIt;
    	boolean findGreater;
    	for( int i=0; i<nums1.length; i++ )
    	{
    		findIt = false;
    		findGreater = false;
    		for( int num2 : nums2 )
    		{
    			// 先找到对应的数字
    			if( nums1[i] == num2 )
    			{
    				findIt = true;
    			}
    			// 找到之后开始找第一个比他大的
    			if( findIt && num2>nums1[i] )
    			{
    				result[i] = num2;
    				findGreater = true;
    				break;
    			}
    		}
    		if( !findGreater )
    		{
    			result[i] = -1;
    		}
    	}
    	return result;
    }	
}
