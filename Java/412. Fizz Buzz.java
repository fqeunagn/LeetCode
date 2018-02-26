class Solution {
	public List<String> fizzBuzz(int n) {
		// 换一个思路，不用余数判断，而是递增的标记判断
		List<String> result = new ArrayList<String>(n);
        String tmp;
        int fizz=0, buzz=0, fizzbuzz=0;
        for( int i=1; i<=n; i++ )
        {
        	fizz++;
        	buzz++;
        	fizzbuzz++;
        	
        	if( fizzbuzz == 15 )
        	{
        		tmp = "FizzBuzz";
        		fizzbuzz = 0;
        		buzz = 0;
        		fizz = 0;
        	}else if( fizz == 3 )
        	{
        		tmp = "Fizz";
        		fizz = 0;
        	}else if( buzz == 5 )
        	{
        		tmp = "Buzz";
        		buzz = 0;
        	}else
        	{
        		tmp = String.valueOf(i);
        	}
        	result.add(tmp);
        }
    	
    	return result;
	}
    
	//================================================//
	
    public List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<String>(n);
        
        // 最直观的处理方式，一个个判断并赋值
        String tmp;
        for( int i=1; i<=n; i++ )
        {
        	if( i%15 == 0 )
        	{
        		tmp = "FizzBuzz";
        	}else if( i%3 == 0 )
        	{
        		tmp = "Fizz";
        	}else if( i%5 == 0 )
        	{
        		tmp = "Buzz";
        	}else
        	{
        		tmp = String.valueOf(i);
        	}
        	result.add(tmp);
        }
    	
    	return result;
    }
}
