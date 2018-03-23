class Solution {
	/* 测试思路
	 * · 传入null和空串
	 * · 传入一个字符
	 * · 传入两个相同字符和两个不同字符
	 * · 传入一串相同字符
	 * · 传入一个长回文串
	 * · 混合回文串和其他字符
	 */
    public String longestPalindrome(String s) {
        if( s==null || s.isEmpty() )
        {
        	return "";
        }

        // 查找最长回文子串
        String result="";
        String tmp;
        for( int i=0; i<s.length(); i++ )
        {
        	// 处理单核
        	tmp = findOne( s, i, i );
        	result = result.length()>tmp.length() ? result : tmp;
        	// 处理双核
        	tmp = findOne( s, i, i+1 );
        	result = result.length()>tmp.length() ? result : tmp;
        }
    	a
    	return result;
    }
    
    // 找出以以i和j为核心的最大回文子串
    private String findOne( String s, int i, int j )
    {
    	while( i>=0 && j<s.length() && s.charAt(i)==s.charAt(j) )
    	{
    		i--;
    		j++;
    	}
    	return s.substring(i+1, j);
    }
}
