class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	if( A==null || A.length<3 )
    	{
    		return 0;
    	}
    	
    	// 一个等差数列，他具有的子等差数列规律如下：
    	// 长为3: 1
    	// 长为4: 3 = 1+2
    	// 长为5: 6 = 3+3
    	// 长为6: 10 = 6+4
    	// 以此类推，从第一个满足等差的序列开始，如果下一位加入后仍然满足要求，则数量需要累加；如果下一位加入后不满足要求，则数量清零
    	int tmp = 0;
    	int result = 0;
    	for( int i=2; i<A.length; i++ )
    	{
    		if( A[i]-A[i-1] == A[i-1]-A[i-2] )
    		{
    			// 从第一个满足要求的3位长度子串开始计数
    			result += (++tmp);
    		}else
    		{
    			tmp = 0;
    		}
    	}

    	return result;
    }
    
    //======================================================//
    
    public int numberOfArithmeticSlices2(int[] A) {
    	if( A==null || A.length<3 )
    	{
    		return 0;
    	}
    	
    	// 这题是让统计一个数组中符合等差数列的子数组（长度最少是3）的总数量
    	// 跟 647. Palindromic Substrings 很像，这题是找一个串里面所有回文子串 
    	// 直接使用比较快的思路，从前往后，逐个判断从每位开始，能输出多少个等差数列
    	int result = 0;
    	for( int i=0; i<A.length-2; i++ )
    	{
    		int j = i+2;
    		//从第i位开始，如果可以形成等差数列，就一直计算下去
    		while( j<A.length && A[j-1]-A[j-2] == A[j]-A[j-1] )
    		{
    			result++;
    			j++;
    		}
    	}
    	
    	return result;
    }
}
