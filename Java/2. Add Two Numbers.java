/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode tmpList = result;
		
		// 将前一种方法的所有?:都换成了if判断，耗时从91ms降低到69ms
		int tmp = 0;
        int num1, num2;
		while( l1!=null || l2!=null )
		{
            num1 = num2 = 0;
            if( l1 != null )
            {
                num1 = l1.val;
                l1 = l1.next;
            }
            if( l2 != null )
            {
                num2 = l2.val;
                l2 = l2.next;
            }
			tmp = tmp + num1 + num2;

            tmpList.next = new ListNode( tmp%10 );
			tmpList = tmpList.next;
			tmp /= 10;
		}
		
        if( tmp != 0 )
        {
           tmpList.next = new ListNode(tmp); 
        }
		
		return result.next;
	}
		
	//=====================================================//
	
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		// 前一个答案写的太挫了，十分不优雅，重写
		// 后面像这种链表题目，都可以用一个头结点hold住结果，便于处理
		ListNode result = new ListNode(-1);
		ListNode tmpList = result;
		
		// 采用一个循环跑到尾的方式处理问题，这里循环的量等于两个链较长的长度
		// 这个方式可以省略很多不必要的特殊处理，比前一种优雅的多
		int tmp = 0;
		while( l1!=null || l2!=null )
		{
			// 将两个数字拿出来，一条链已经没了也没关系，直接处理为0
			int num1 = l1==null ? 0 : l1.val;
			int num2 = l2==null ? 0 : l2.val;
			tmp = tmp + num1 + num2;
			
			//处理当前位数，以及进位
			tmpList.next = new ListNode( tmp%10 );
			tmpList = tmpList.next;
			tmp /= 10;
			
			// 两条链分别向后遍历
			l1 = l1==null ? null : l1.next;
			l2 = l2==null ? null : l2.next;
		}
		
		// 最后还可能会有一个进位
		tmpList.next = tmp==0 ? null : new ListNode(tmp);
		
		return result.next;
	}
	
	//=====================================================//
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	if( l1==null || l2==null )
    	{
    		return null;
    	}
    	
    	ListNode result = null;
    	ListNode tmpList = null;
    	int tmp = 0;
    	// 特殊情况考虑：
    	// 1、长度超过int
    	// 2、两个数长度相等，相加无进位
    	// 3、两个数长度相等，相加有进位
    	// 4、两个数长度不等，最后无进位
    	// 5、两个数长度不等，最后有进位
    	
    	// 被这题搞到没脾气，链表不太擅长，这代码写的真特么烂
    	// 按照ListNode的逻辑，从前到后一点点往下加
    	while( l1!=null && l2!=null )
    	{
    		tmp = l1.val + l2.val + tmp;
    		
    		if( result == null )
    		{
    			result = tmpList = new ListNode( tmp % 10 );
    		}else
    		{
    			tmpList.next = new ListNode( tmp % 10 );
    			tmpList = tmpList.next;
    		}
    		
    		tmp /= 10;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	// 碰到最后结束的时候，把剩余的链加上
    	if( l1 == null )
    	{
    		l1 = l2;
    	}
    	
    	if( l1 != null )
		{
	    	tmpList.next = l1;
	    	// 处理其中一条链还没完的情况
	    	if( l1.next!=null )
	    	{
		    	do
		    	{
		    		l1.val += tmp;
		    		tmp = l1.val / 10;
		    		l1.val = l1.val % 10;
		    		l1 = l1.next;
		    	}
		    	while( tmp!=0 && l1.next!=null );
	    	}

	    	//处理最后的进位
	    	l1.val += tmp;
    		if( l1.val > 9 )
    		{
    			l1.next = new ListNode( l1.val / 10 );
	    		l1.val = l1.val % 10;
    		}
		}else if( tmp!=0 )
		{
			// 处理两条链都空，但仍然有进位的情况
			l1 = new ListNode( tmp );
			tmpList.next = l1;
		} 
    	
    	return result;
	}
    	
    public ListNode addTwoNumbers_Wrong(ListNode l1, ListNode l2) {
    	if( l1==null || l2==null )
    	{
    		return null;
    	}
    	
    	//这个思路是有问题的，题目并没有限制链的长度，一旦超过int的范围，就会出错
    	//输入的数组是个位数开始往上排，直观的解法是把这两个List转化为真正的数字然后相加，再转换为正确的输出格式
    	int tmp = getNum(l1) + getNum(l2);
    	ListNode result = new ListNode( tmp % 10 );
    	tmp /= 10;
    	ListNode tmpNode = result;
    	while( tmp > 0 )
    	{
    		tmpNode.next = new ListNode( tmp % 10 );
    		tmp /= 10;
    		tmpNode = tmpNode.next;
    	}
    	
        return result;
    }
    
    private int getNum( ListNode l )
    {
    	int num = 0;
    	int tmp = 1;
    	while( l != null )
    	{
    		num += l.val * tmp;
    		tmp *= 10;
    		l = l.next;
    	}
    	return num;
    }
}
