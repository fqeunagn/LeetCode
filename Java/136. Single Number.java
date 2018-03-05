class Solution {
    public int singleNumber(int[] nums) {
        // 这题最简单的做法是用一个set判断，是否重复，但题目要求不允许有额外的空间；
    	// 另外有一道题，限制要求是数组中的数字大小范围就是数组长度，那题可以通过对应位置的值设为负数来判断是否存在，但题目没有约束数字范围；
    	// 只好通过另外的思路，对于int数字n，通过异或（相同为0）处理：
    	// n XOR n == 0
    	// n XOR 0 == n
    	// n1 XOR n1 XOR n2 == n2
    	int result = 0;
    	for( int num : nums )
    	{
    		result ^= num;
    	}
    	
    	return result;
    }
}
