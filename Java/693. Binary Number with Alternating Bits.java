class Solution {
	public boolean hasAlternatingBits(int n) {
		// 基于上一种解法，进一步缩减表达，耗时14ms
		return  ( (n ^= (n>>2)) & (n-1) ) == 0;
	}
	
	//========================================================//
	
	public boolean hasAlternatingBits7(int n) {
		// 基于和以下判断，耗时15ms
		// 判断2：如果一个二进制数x全为1，则 (x+1)&x必然为0；反之同样成立，如果 (x+1)&x==0，则x全为1；
		// 判断3：如果n符合题目要求，那么会有(n ^ (n>>2))形如1000；反之同样成立，如果(n ^ (n>>2))形如1000，那么n一定符合题目要求
		n = n ^ (n>>2);
		return  ( n & (n-1) ) == 0;
	}
	
	//========================================================//
	
	public boolean hasAlternatingBits6(int n) {
		// 基于以下判断，耗时17ms：
		// 判断1：如果n符合题目要求，那么一定有 (n + (n>>1))全为1；反之同样成立，如果(n + (n>>1))全为1，则n一定是题目要求的“1010”形式
		// 判断2：如果一个二进制数x全为1，则 (x+1)&x必然为0；反之同样成立，如果 (x+1)&x==0，则x全为1；
		return  (((n + (n>>1))+1) & (n + (n>>1))) == 0;
	}
	
	//========================================================//
	
	public boolean hasAlternatingBits5(int n) {
		// 将n转换成二进制字符串，然后通过正则表达式匹配判断，但正则表达式比较耗性能，时长25ms
		// n的第一个字符一定是1，最后一个字符可能是1或者0，正则表达式为： “(10)*1?”，任意多的“10”，最后一个可能有1
		return Integer.toBinaryString(n).matches("(10)*1?");
	}
	
	//========================================================//
	
	public boolean hasAlternatingBits4(int n) {
		// 试试最直接的方法，一位位判断，耗时15ms
		// 用一个tmp记录每个位，如果连续两个一样的，那就是有问题了
		int tmp = -1;
		while( tmp != (n&1) )
		{
			tmp = n & 1;
			n >>= 1;
		}
		
		// 如果满足题目要求，到最后n一定是0；
		return n==0;
	}
	
	//========================================================//
	
	public boolean hasAlternatingBits3(int n) {
		// 换个思路，直接把所有满足条件的数字记下来好了，反正也不多，但这个方式效率相当低，耗时22ms
		// 满足要求的最大的正整数就是这个了
		int x = 0x55555555;
		Set<Integer> check = new HashSet<Integer>();
		while( x > 0 )
		{
			check.add(x);
			x >>= 1;
		}
		
		return check.contains(n);
	}
	
	//=================================================================//
	
    public boolean hasAlternatingBits_wrong1(int n) {
    	// 【这个思路是错的】，对于那种比符合要求的数少几个1的数，会判断为真。
        // 思路：如果一个正整数的二进制表现为1010100这种样子，那拿这个数并上最大的01010101，得到的结果要么是本身要么是0，其他情况都不符合
    	// 最大的010101形式的正整数是：0x55555555
    	int x = 0x55555555;
    	int tmp = n & x;
    	if( tmp==0 || tmp==n )
    	{
    		return true;
    	}else
    	{
    		return false;
    	}
    }
}
