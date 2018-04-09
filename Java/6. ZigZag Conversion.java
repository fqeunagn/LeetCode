class Solution {
	/*
	 * 测试思路：
	 * 	字符串为null、空
	 * 	数字大于字符串长度
	 * 	数字小于字符串长度
	 * 	数字为1
	 * 	数字为0
	 * @param s
	 * @param numRows
	 * @return
	 */
    public String convert(String s, int numRows) {
    	if( s==null || s.isEmpty() || numRows<=1 )
    	{
    		return s;
    	}
    	
    	char[] str = s.toCharArray();
    	
    	// 模拟的办法比较简单，但是性能较慢，换成直接操作数组下标
    	// 整个锯齿的下标变化情况如下
		//-------------------------------------------------------------numRows：i---差异值1-----差异值1-------差异值2-----差异值2
		//0                        2n-2                       4n-4        i=0       2n-2     2(n-1)        0       2(0)
		//1                  2n-3  2n-1                 4n-5  4n-3        i=1       2n-4     2(n-2)        2       2(1)
		//2              2n-4      2n               4n-6      4n-2        i=2       2n-6     2(n-3)        4       2(2)
		//…           …            …             …            …           i         ----    2(n-i-1)     ----      2(i)
		//n-3     n+1              3n-5      3n-1             5n-7        i=n-3       4    2(n-(n-3)+1)  2n-6     2(n-3)
		//n-2  n                   3n-4  3n-2                 5n-6        i=n-2       2    2(n-(n-2)+1)  2n-4     2(n-2)
		//n-1                      3n-3                       5n-5        i=n-1       0    2(n-(n-1)+1)  2n-2     2(n-1) 
	    
    	// 直接按照结果逐行输出，一共会输出numRows行
    	int next1, next2;
    	int index;
    	StringBuilder result = new StringBuilder();;
    	for( int i=0; i<numRows; i++ )
    	{
    		next1 = 2 * ( numRows - i - 1 );
    		next2 = 2 * i;
    		//每行的第一个字符
    		index = i;
    		if( index < str.length )
    		{
        		result.append( str[index] );
    		}
    		//每行按照next1和next2累加下去
    		while( true )
    		{
    			// 跳第一个间隔
    			index += next1;
    			if( index >= str.length )
    			{
    				break;
    			}
    			// 如果第一个间隔没有实际移动，表示在最后一行，是不需要再次添加的；
    			if( next1 != 0 )
    			{
    				result.append( str[index] );
    			}
    			
    			// 跳第二个间隔
    			index += next2;
    			if( index >= str.length )
    			{
    				break;
    			}
    			// 如果第2个间隔没有实际移动，表示在第一行，是不需要再次添加的；
    			if( next2 != 0 )
    			{
    				result.append( str[index] );
    			}
    		}
    	}
    	
    	return result.toString(); 
	}

	//===================================================================//
	
    public String convert2(String s, int numRows) {
    	if( s==null || s.isEmpty() || numRows<=1 )
    	{
    		return s;
    	}
    	
    	// 将字符串锯齿化，锯齿边长可变，输出变化后的字符串
    	// 找规律好复杂，试试直接模拟操作看看，简单一点
    	// 通过一个数组生成锯齿，用String其实比较慢，可以换成StringBuilder
    	String[] tmp = new String[ numRows ];
    	for( int i=0; i<tmp.length; i++ )
    	{
    		tmp[i] = "";
    	}
    	
    	int i = 0, k=0;
    	int next = 1;
    	while( i < s.length() )
    	{
    		tmp[k] = tmp[k]+s.charAt(i++);
    		
    		// 通过next让下标进行往返
    		if( k == numRows-1 )
    		{
    			next = -1;
    		}else if( k == 0 )
    		{
    			next = 1;
    		}
    		
    		k += next;
    	}
    	
    	// 直接把模拟的结果拼凑起来
    	String result = "";
    	for( String one : tmp )
    	{
    		result += one;
    	}
    	
        return result;
    }
}
