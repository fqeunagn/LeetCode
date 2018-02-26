class Solution {
	public int[][] reconstructQueue(int[][] people) {
        // 解决思路和前面的方法一样，但是换成Java内建方法解决：
		// 1、首先按 h 从高到低排序，如果 h 相等，则按 k 从小到大排序；
		// 使用数组排序方法，直接使用匿名内部类搞定
		Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] p1, int[] p2) {
				if( p1[0] == p2[0] )
				{
					return p1[1] - p2[1];
				}
				return p2[0] - p1[0];
			}
		} );
		
		// 2、从前到后，对于每个人，他前面的人的身高都大于等于他，所以k值的人，必须站在k+1这个位置上；如果满足就不用动，否则就要往前挪到位
		List<int[]> tmp = new ArrayList<int[]>( people.length );
		for( int[] p : people )
		{
			// 逐个把人放到 K 位子上去；
			tmp.add( p[1], p );
		}
		
		// 3、转成数组并返回
		return tmp.toArray( new int[0][0] );
    }
	
	
	//================================================//
	
	public int[][] reconstructQueue2(int[][] people) {
        // 解决思路：
		// 1、首先按 h 从高到低排序，如果 h 相等，则按 k 从小到大排序；
		int[][] tmp = sort( people );
		
		// 2、从前到后，对于每个人，他前面的人的身高都大于等于他，所以k值的人，必须站在k+1这个位置上；如果满足就不用动，否则就要往前挪到位
		int[][] result = move( tmp );
		
		return result;
    }
	
	// 就用最简单的冒泡排序
	private int[][] sort( int[][] people )
	{
		for( int i=0; i<people.length; i++ )
		{
			for( int j=people.length-1; j>i; j-- )
			{
				if( people[j][0] > people[j-1][0] )
				{
					// 身高高的往前挪
					exchange( people, j, j-1 );
				}else if( people[j][0]==people[j-1][0] && people[j][1]<people[j-1][1] )
				{
					// 身高一样的，k值小的往前挪
					exchange( people, j, j-1 );
				}
			}
		}
		return people;
	}
	
	// 从前到后往前挪
	private int[][] move(int[][] people) {
		for( int i=0; i<people.length; i++ )
		{
			// 一致往前挪到k值满足要求
			int j = i;
			while( people[j][1] != j )
			{
				exchange( people, j, j-1 );
				j--;
			}
		}
		return people;
	}
	
	// 数组两个元素交换位置
	private void exchange( int[][] people, int i, int j )
	{
		int[] tmp = people[i];
		people[i] = people[j];
		people[j] = tmp;
	}
}
