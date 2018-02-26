class Solution {
    public int calPoints(String[] ops) {    
       	LinkedList<Integer> tmpStack = new LinkedList<Integer>();

    	for( String op : ops )
    	{
    		if( "D".equals(op) )
    		{
    			// D操作，取栈顶数字，乘以2再入栈
    			Integer num = tmpStack.peek();
    			if( num != null )
    			{
    				tmpStack.push( num * 2 );
    			}
    		}else if( "C".equals(op) )
    		{
    			// C操作，将最新的一个成绩删除
    			tmpStack.poll();
    		}else if( "+".equals(op) )
    		{
    			// +操作，把最新的两个成绩拿出来，和新成绩一起重新入栈
    			Integer num1 = tmpStack.poll();
    			Integer num2 = tmpStack.poll();
    			int num = 0;
    			if( num2 != null )
    			{
    				num += num2;
    				tmpStack.push(num2);
    			}
    			if( num1 != null )
    			{
    				num += num1;
    				tmpStack.push(num1);
    			}
    			tmpStack.push(num);
    		}else
    		{
    			// 如果是数字，直接入栈
    			tmpStack.push( Integer.parseInt(op) );
    		}
    	}
    	
    	// 累加
    	int result = 0;
    	for( int tmp : tmpStack )
    	{
    		result += tmp;
    	}
        return result;
    }
}
