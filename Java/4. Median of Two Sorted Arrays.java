class Solution {
	// 由于经常提交好几次都是被特殊情况wrongAnswer，所以从今天开始加上测试思路
	// ·等长数组
	// ·等长数组，长度为1
	// ·一条长度为1，另一条分别为2、3、4，然后在反过来
	// ·一条为空，反过来
	// ·一条为null，反过来
	// ·两条都为空或null
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if( nums1 == null )
        {
        	nums1 = new int[0];
        }
        if( nums2 == null )
        {
        	nums2 = new int[0];
        }
    	
        // 思路和前面解法是一样的，只是优化代码，快了一点点，从97ms到86ms
        int[] tmp = new int[nums1.length+nums2.length];
        int indexA = tmp.length/2;
        int indexB = tmp.length%2==0 ? tmp.length/2-1 : tmp.length/2;
        
        for( int i=0, j=0, k=0; i<nums1.length||j<nums2.length; )
        {
        	if( j>=nums2.length || ( i<nums1.length && nums1[i]<nums2[j] ) )
        	{
        		tmp[k++] = nums1[i++];
        	}else
        	{
        		tmp[k++] = nums2[j++];
        	}

        	// 事实上没必要走完整个流程，只需要走到中间就好
        	if( k > indexA )
        	{
        		break;
        	}
        }
        
        // 最后处理中位数
    	return ((double)tmp[indexA] + (double)tmp[indexB]) / 2;
    }
    
    //======================================================//
    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if( nums1 == null )
        {
        	nums1 = new int[0];
        }
        if( nums2 == null )
        {
        	nums2 = new int[0];
        }
    	
        // 就是归并排序，一个循环吧两个有序数组合并
        int[] tmp = new int[nums1.length+nums2.length];
        for( int i=0, j=0, k=0; i<nums1.length||j<nums2.length; )
        {
        	if( j>=nums2.length || ( i<nums1.length && nums1[i]<nums2[j] ) )
        	{
        		tmp[k++] = nums1[i++];
        	}else
        	{
        		tmp[k++] = nums2[j++];
        	}
        }
        
        // 最后处理中位数，偶数长度数组和奇数长度数组处理不同
        double result = 0;
        if( tmp.length % 2 == 0 )
        {
        	result = ((double)tmp[tmp.length/2] + (double)tmp[tmp.length/2-1]) / 2;
        }else
        {
        	result = tmp[tmp.length/2];
        }
    	
    	return result;
    }
}
