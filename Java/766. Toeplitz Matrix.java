class Solution {
	public boolean isToeplitzMatrix(int[][] matrix) {
		//简单一点的方式，每行都进行遍历，每行只与下一行比较
		//注意只需要便利到倒数第二行、倒数第二列
		for( int i=0; i<matrix.length-1; i++ )
		{
			for( int j=0; j<matrix[0].length-1; j++ )
			{
				if( matrix[i][j] != matrix[i+1][j+1] )
				{
					return false;
				}
			}
		}
		return true;
	}
  
  	//==================================================//
	
    public boolean isToeplitzMatrix2(int[][] matrix) {
    	// 复杂一点的方式，专门用一个方法来判断
    	// 判断左侧边
    	for( int i=0; i<matrix.length; i++ )
    	{
    		if( !checkOne( matrix, i, 0) )
    		{
    			return false;
    		}
    	}
    	// 判断上侧边
    	for( int j=1; j<matrix[0].length; j++ )
    	{
    		if( !checkOne( matrix, 0, j) )
    		{
    			return false;
    		}
    	}
    	
        return true;
    }
    
    // 验证是否相等
    private boolean checkOne( int[][] matrix, int a, int b )
    {
    	int tmp = matrix[a][b];
    	for( ; a<matrix.length&&b<matrix[0].length; a++,b++ )
    	{
    		if( tmp != matrix[a][b] )
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
