class Solution {
    public int findComplement(int num) {
    	// 这个的想法和前一个一样，但是使用了Java内部方法
    	
        // 间接取得前导0数量，Integer.highestOneBit(num)方法可以返回一个数字最左边的1对应的数字（负数的1就在第一位，正数看实际情况）
    	int mask = (Integer.highestOneBit(num) << 1) - 1;
        
        // num取反之后在并上前面的结果
        return ~num & mask;
    }
    
	//========================================//
	
    public int findComplement3(int num) {
    	// 这个的想法和前一个一样，但是编码更为简洁
    	
        // 间接取得前导0数量
        int tmp = ~0;
        while( (tmp&num) != 0 )
        {
        	tmp <<= 1;
        }
        
        // num取反之后在并上前面的结果
        return ~num & ~tmp;
    }
    
    //=====================================//
	
    public int findComplement2(int num) {
    	// 奇怪的是，在LeetCode的服务器运行上看，这个方法是最快的 11ms，上面的都是 13ms
        int count = 0;
        
        // 计算前导0的数量
        int tmp = num;
        while( tmp > 0 )
        {
        	tmp <<= 1;
        	count++;
        }
        
        // 取反之后，前导全都是1，要按照前面统计的数量消除
        num = ~num;
        num <<= count;
        num >>>= count;
        
        return num;
    }
}
