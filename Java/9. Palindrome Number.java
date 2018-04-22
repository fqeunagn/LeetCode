class Solution {
    public boolean isPalindrome(int x) {
        String check = String.valueOf(x);
        // 直接用两个游标从最左和最后向中间靠拢判断
        for( int i=0,j=check.length()-1; i<j; i++, j-- )
        {
        	if( check.charAt(i) != check.charAt(j) )
        	{
        		return false;
        	}
        }
    	return true;
    }
}
