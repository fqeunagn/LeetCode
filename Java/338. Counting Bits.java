class Solution {
	public int[] countBits(int num) {
		// 使用公式1，更快
		
		int[] result = new int[num+1];
		for( int i=0; i<=num; i++ )
		{
			// 注意 & 操作必须用括号，否则运算优先级会出问题
			result[i] = result[i>>1] + (i&1);
		}
		
		return result;
	}
	
	//==================================================//
	
	public int[] countBits5(int num) {
		// 对于数字X，二进制形式为aaaaaaab，其中 b 部分 1 的数量为 X&1, a 部分 1 的数量等于 aaaaaaa（也即 X>>1） 的1的数量
		// 公式1：f[X] = f[X>>1] + X&1
		// 公式2：f[X] = f[X/2] + X%2
		// 使用公式2
		
		int[] result = new int[num+1];
		for( int i=0; i<=num; i++ )
		{
			result[i] = result[i/2] + i%2;
		}
		
		return result;
	}

	//==================================================//
	
	public int[] countBits4(int num) {
		//  从0开始，第2^n+k个数字的1数量是第k个数字的1数量加1；
		//	起始：   bits[0] = 0
		//	n=0: bits[2^0+0] = bits[1] = 1 = 0+1 = bits[0] + 1
		//	n=1: bits[2^1+0] = bits[2] = 1 = 0+1 = bits[0] + 1 
		//		 bits[2^1+1] = bits[3] = 2 = 1+1 = bits[1] + 1 
		//	n=2: bits[2^2+0] = bits[4] = 1 = 0+1 = bits[0] + 1 
		//		 bits[2^2+1] = bits[5] = 2 = 1+1 = bits[1] + 1 
		//		 bits[2^2+2] = bits[6] = 2 = 1+1 = bits[2] + 1 
		//		 bits[2^2+3] = bits[7] = 3 = 2+1 = bits[3] + 1 
		//	n=3: bits[2^3+0] = bits[8] = 1 = 0+1 = bits[0] + 1 
		//		 bits[2^3+1] = bits[9] = 2 = 1+1 = bits[1] + 1 
		//		 bits[2^3+2] = bits[10] = 2 = 1+1 = bits[2] + 1 
		//		 bits[2^3+3] = bits[11] = 3 = 2+1 = bits[3] + 1 
		//		 bits[2^3+4] = bits[12] = 2 = 1+1 = bits[4] + 1 
		//		 bits[2^3+5] = bits[13] = 3 = 1+1 = bits[5] + 1 
		//		 bits[2^3+6] = bits[14] = 3 = 2+1 = bits[6] + 1 		
		//		 bits[2^3+7] = bits[15] = 4 = 2+1 = bits[7] + 1 		

		//  公式1：bits[2^n+k] = bits[k] + 1 ( 0 <= k < 2^n)
		//  公式2：bits[x] = bits[x-2^y] + 1 ( y取满足 x>2^y 的最大值 )
		
		int[] result = new int[num+1];
		int offset = 1;
		for( int i=1; i<=num; i++ )
		{
			if( offset * 2 <= i )
			{
				offset *= 2;
			}
			result[i] = result[i-offset] + 1;
		}
		
	    return result;
	}
	
	//==================================================//
	
	public int[] countBits3(int num) {
		//每个数字算一次，比直接用Java方法更慢，Java 的 bitCount 内部没有循环，运算很快
		
		int[] result = new int[num+1];
		
		for( int i=0; i<=num; i++ )
		{
			result[i] = countOne( i );
		}
		
	    return result;
	}
	
	private int countOne( int i )
	{
		int tmp = 0;
		while( i > 0 )
		{
			tmp += i&1;
			i >>= 1;
		}
		
		return tmp;
	}
	
	//==================================================//
	
	public int[] countBits2(int num) {
		//首先作个弊
		
		int[] result = new int[num+1];
		
		for( int i=0; i<=num; i++ )
		{
			result[i] = Integer.bitCount( i );
		}
		
	    return result;
	}
}
