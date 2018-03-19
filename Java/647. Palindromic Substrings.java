class Solution {
	public int countSubstrings(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return 0;
    	}
		
    	//换个不一样的思路
    	//从前到后，逐个遍历字母，包括两个场景
    	int result = 0;
    	for( int i=0; i<s.length(); i++ )
    	{
    		//1、以这个字母为中心，向左右扩张到底，符合要求的有多少（子串字符数量是奇数）
    		result += count( s, i, i );
    		//2、以这个字母和下个字母共同为中心，向左右扩张到底，符合要求的有多少（子串字符数量为偶数）
    		result += count( s, i, i+1 );
    	}
		
		return result;
	}
	
	// 从中心向外扩散，统计一共有多少个回文子串
	private int count( String s, int l, int r )
	{
		int tmp = 0;
		//一旦一个子串不符合要求，以他为中心扩张的子串也肯定不符合要求
		while( l>=0 && r<s.length() && s.charAt(l)==s.charAt(r) )
		{
			tmp++;
			l--;
			r++;
		}
		return tmp;
	}
	
	//====================================================//
	
    public int countSubstrings3(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return 0;
    	}
    	
    	// 和前一个方法相比，做了微调，不需要数组缓存了，直接加结果
    	char[] c = s.toCharArray();
    	int result = 0;
    	
    	// 从前到后开始判断
    	for( int i=0; i<s.length(); i++ )
    	{
    		//对于每个判断点，需要判断从第一位到判断点的所有字符串是否是回文子串
    		for( int j=0; j<=i; j++ )
    		{
    			if( isPal( c, j, i ) )
    			{
    				result++;
    			}
    		}
    	}
    	
        return result;
    }
	
	//====================================================//
	
    public int countSubstrings2(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return 0;
    	}
    	
    	// 对动态规划非常不擅长，但总得有个开始
    	// 从第一位开始，每一位都记住它对应的具体回文子串的数量，从前到后，在最后一位的时候，就可以知道所有存在的回文子串了
    	char[] c = s.toCharArray();
    	// 数组每一位存储的，是必定包含这一位的所有子串中，符合要求的子串的数量
    	// 数组每一位之前所有数量的和，就是这一位对应的所有回文子串的数量
    	int[] count = new int[s.length()];

    	// 从前到后开始判断
    	for( int i=0; i<s.length(); i++ )
    	{
    		int tmp = 0;
    		//对于每个判断点，需要判断从第一位到判断点的所有字符串是否是回文子串
    		for( int j=0; j<=i; j++ )
    		{
    			if( isPal( c, j, i ) )
    			{
    				tmp++;
    			}
    		}
    		count[i] = tmp;
    	}
    	
    	//最后统计总数，只要把每一位数量全部加上即可
    	int result = 0;
    	for( int tmp : count )
    	{
    		result += tmp;
    	}
    	
        return result;
    }	
    
    // 判断起点到终点是否回文子串
    private boolean isPal( char[] c, int l, int r )
    {
    	for( ; l<r; l++,r-- )
    	{
    		if( c[l] != c[r] )
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
