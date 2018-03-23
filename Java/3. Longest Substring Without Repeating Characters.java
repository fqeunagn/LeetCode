class Solution {
    public int lengthOfLongestSubstring(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return 0;
    	}
    	
    	// 遍历整个字符串，保存每个字符离当前遍历点最近的位置
    	Map<Character, Integer> cPlace = new HashMap<Character, Integer>();
    	int maxLength = -1;
    	int startIndex = 0;
    	char c;
    	for( int i=0; i<s.length(); i++ )
    	{
    		c = s.charAt(i);
    		
    		// 如果在当前段内碰到了重复的字符，则开始计算长度
    		if( cPlace.containsKey(c) && cPlace.get(c)>=startIndex)
    		{
    			// 检查当前段的长度是否最长
    			maxLength = Math.max(maxLength, i-startIndex);
    			// 重置起点，放到当前重复的这个字符的位置后一位，由于map存储的是每个字符最靠近的位置，所以肯定没问题
    			startIndex = cPlace.get(c)+1;
    		}
			// 存储或刷新字符位置，确保只记录最近的那一个
			cPlace.put(c, i);
    	}
    	// 上面循环无法处理两个场景：没有任何重复、字符串最长子串在最右侧。所以这里必须做一个收尾
    	maxLength = Math.max(maxLength, s.length()-startIndex);
    	
    	return maxLength;
    }

    	
    //=================================================================//	
	
    public int lengthOfLongestSubstring_Wrong(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return 0;
    	}
    	
    	// 对于很长的测试用例超时了
    	// 最暴力的做法来试试，所有情况遍历一下
    	int result = 0;
    	int tmp = 0;
    	for( int i=0; i<s.length(); i++ )
    	{
    		for( int j=i+1; j<=s.length(); j++ )
    		{
    			tmp = check(s.substring(i, j));
    			if( result < tmp )
    			{
    				result = tmp;
    			}
    		}
    	}
    	return result;
    }
    
    private int check( String s )
    {
    	Set<Character> tmp = new HashSet<Character>();
    	for( char c : s.toCharArray() )
    	{
    		if( tmp.contains(c) )
    		{
    			return -1;
    		}
    		tmp.add(c);
    	}
    	return s.length();
    }
}
