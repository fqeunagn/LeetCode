class Solution {
    public int distributeCandies(int[] candies) {
        // 思路相同，但是Set貌似有点慢，换用数组
    	int[] check = new int[100000*2+1];
    	int kindCheck = 0;
    	for( int candy : candies )
    	{
    		check[candy+100000]++;
    		// 注意别统计重复了
    		if( check[candy+100000] == 1 )
    		{
    			kindCheck++;
    		}
    	}
    	
    	return Math.min( kindCheck, candies.length/2 );
    }
    
    //============================================//
	
    public int distributeCandies2(int[] candies) {
        // 总共有 L 颗糖，这些糖总共有 K 种，每个人可分得 L/2 颗；
    	// 如果 K >= L/2，则姐姐最多只能拿到 L/2 种；
    	// 如果 K < L/2，则姐姐最多只能拿到 K 种；
    	// 换言之，姐姐最多能拿到 Min( K, L/2 )
    	Set<Integer> check = new HashSet<Integer>();
    	for( int candy : candies )
    	{
    		check.add(candy);
    	}
    	
    	return Math.min( check.size(), candies.length/2 );
    }
}
