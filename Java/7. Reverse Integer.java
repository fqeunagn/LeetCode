class Solution {
    public int reverse(int x) {
    	int minus = 1;
    	if( x < 0 )
    	{
    		minus = -1;
    		x = -x;
    	}
    	
    	// 乘法处理
    	long result = 0;
    	while( x > 0 )
    	{
    		result = result*10 + x%10;
    		x = x / 10;
    	}
    	
    	// 注意结果处理
    	return result>Integer.MAX_VALUE ? 0 : (int)result * minus;
    }
    	
	//============================================================//
	
    public int reverse2(int x) {
        // 换成字符串，然后反过来
    	StringBuilder tmp = new StringBuilder( Integer.toString(x) );
    	
    	// 注意符号的处理
    	String minus = null;
    	if( tmp.charAt(0) == '-' )
    	{
    		minus = "-";
    		tmp.deleteCharAt(0);
    	}
    	tmp = tmp.reverse();
    	
    	if( minus != null )
    	{
    		tmp.insert(0, minus);
    	}
    	
    	// 注意题目要求，如果超出int范围，需要返回0
    	long num = Long.parseLong(tmp.toString());
    	return num>Integer.MAX_VALUE||num<Integer.MIN_VALUE ? 0 : (int)num;
    }
}
