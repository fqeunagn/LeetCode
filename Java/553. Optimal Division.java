class Solution {
    public String optimalDivision(int[] nums) {
    	// 日常防空
    	if( nums==null || nums.length==0 )
    	{
    		return "";
    	}
    	
    	// 思路：
    	// 对于 A/B/C/.../N，不论括号怎么加，在最终表达式里，A一定位于分子，B一定位于分母，所以可表达为 (A/B)*X
    	// 如果想要该值最大化，则 X 必须最大化，在该表达式中，最大的X为剩下所有数的乘积，MAX(X)=C*D*...*N
    	// 所以最大值为 (A/B)*X = (A*C*D*...*N)/B = A*( (C*D*...*N)/B ) = A/( B/(C*D*...*N) ) = A/(B/C/D/.../N)
    	// 所以直接使用括号把除了第一个数之外的其他数都括起来即可
    	StringBuilder sb = new StringBuilder();
    	StringBuilder result = new StringBuilder();
    	for( int i=1; i<nums.length; i++ )
    	{
    		sb.append(nums[i]).append('/');
    	}
    	result.append(nums[0]);
    	if( nums.length > 2 )
    	{
    		result.append( "/(" ).append( sb.substring(0, sb.length()-1) ).append( ")" );
    	}else if( nums.length == 2 )
    	{
    		result.append( "/" ).append( sb.substring(0, sb.length()-1) );
    	}
    	
    	return result.toString();
    }
}
