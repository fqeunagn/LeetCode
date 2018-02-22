class Solution {
	public int hammingDistance(int x, int y) {
		//直接使用Java自带方法
		return Integer.bitCount( x ^ y );
	}
	
	//=================================================//
	
	public int hammingDistance2(int x, int y) {
		// 将两个数字生成二进制数组
	    char[] a = String.format("%32s", Integer.toString(x, 2)).replace(" ", "0").toCharArray();
	    char[] b = String.format("%32s", Integer.toString(y, 2)).replace(" ", "0").toCharArray();
	    
		// 对比两个数组
	    int result = 0;
	    for( int i=0; i<a.length; i++ )
	    {
	    	if( a[i] != b[i] )
	    	{
	    		result++;
	    	}
	    }
		
		return result;
	}
}
