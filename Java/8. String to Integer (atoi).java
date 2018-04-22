class Solution {
	/*
	 * 正数、负数
	 * 带空格的正数、负数
	 * 带前字母的正数、负数
	 * 带后字母的正数、负数
	 */
    public int myAtoi(String str) {
        if( str==null || str.isEmpty() || str.trim().isEmpty() )
        {
        	return 0;
        }
        
        // 去掉可能的空格
        str = str.trim();
        char sign = ' ';
        // 去掉+-
        if( str.charAt(0)=='+' || str.charAt(0)=='-' )
        {
        	sign = str.charAt(0);
        	str = str.substring(1, str.length());
        }
        
        // 获取有效数字
        StringBuilder sb = new StringBuilder();
        for( char c : str.toCharArray() )
        {
        	if( c<'0' || c>'9' )
        	{
        		break;
        	}
        	sb.append(c);
        }
        
        // 如果没有结果，代表并非数字为首
        if( sb.length() == 0 )
        {
        	return 0;
        }
        
        int result = 0;
        boolean overflow = false;
        // 如果数字过大，
        if( sb.length() > 10 )
        {
        	result = Integer.MAX_VALUE;
        	overflow = true;
        }else
        {
        	long longNum = Long.parseLong(sb.toString());
        	if( longNum > Integer.MAX_VALUE )
        	{
        		result = Integer.MAX_VALUE;
        		overflow = true;
        	}else
        	{
        		result = (int)longNum;
        	}
        }
        
        if( sign == '-' )
        {
        	result *= -1;
        	// 注意，如果是负向溢出，则要修补数字
        	if( overflow )
        	{
        		result--;
        	}
        }

        return result;
    }
}
