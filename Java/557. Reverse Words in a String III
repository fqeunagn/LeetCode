class Solution {
    public String reverseWords(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return s;
    	}
    	// 思路一模一样，但是使用了Java自带方法进行反序，速度更快
    	
    	// 按空格分割后，每个依次分割即可
    	String[] tmpList = s.split( " " );
    	StringBuilder sb = new StringBuilder();
    	for( String tmp : tmpList )
    	{
    		sb.append( new StringBuilder(tmp).reverse() ).append( " " );
    	}
    	return sb.substring( 0, sb.length()-1 );
    }	
	
	//==============================================//
	
    public String reverseWords2(String s) {
    	if( s==null || s.isEmpty() )
    	{
    		return s;
    	}
    	
    	// 按空格分割后，每个依次分割即可
    	String[] tmpList = s.split( " " );
    	StringBuilder sb = new StringBuilder();
    	for( String tmp : tmpList )
    	{
    		sb.append( reverseString(tmp) ).append( " " );
    	}
    	return sb.substring( 0, sb.length()-1 );
    }	
    
    // 单独做一个反序
    private StringBuilder reverseString( String s )
    {
    	StringBuilder sb = new StringBuilder();
    	for( int i=s.length()-1; i>=0; i-- )
    	{
    		sb.append(s.charAt(i));
    	}
    	
    	return sb;
    }
}
