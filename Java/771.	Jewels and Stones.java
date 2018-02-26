class Solution {
    public int numJewelsInStones(String J, String S) 
    {
        // 和上一个方法思路一样，但更为简洁
    	int[] chars = new int['z' + 1];
    	int result = 0;
    	
    	for( char i : J.toCharArray() )
    	{
    		chars[ i ] = 1;
    	}
    	
    	for( char i : S.toCharArray() )
    	{
    		result += chars[ i ]==1?1:0;
       	}
    	
        return result;
    }   
    
    //====================================================//
    
    public int numJewelsInStones2(String J, String S) {
        // 通过一个52位数组记录所有的宝石，然后再遍历进行识别
    	int[] chars = new int[26*2];
    	int result = 0;
    	
    	for( int i =0; i< J.length(); i++ )
    	{
    		chars[ getCharInt(J.charAt(i)) ] = 1;
    	}
    	
    	for( int i=0; i<S.length(); i++ )
    	{
    		result += chars[getCharInt(S.charAt(i))]==1?1:0;
       	}
    	
        return result;
    }
    
    private int getCharInt( char i )
    {
    	if( i>= 'a' )
    	{
    		return 26 + (i - 'a');
    	}else
    	{
    		return i - 'A';
    	}
    }
}
