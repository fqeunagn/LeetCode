class Solution {
	public int islandPerimeter(int[][] grid) {
    	// 另一个思路：
		// 单独一个格子，则周长+4；两个格子相邻，则周长-2；
		// 所以总周长：Count(格子数)*4-Count(相邻边数)*2
        // 不过这个方法有够慢的，居然要186ms，前一个方法才130ms
    	int island = 0;
    	int neighbor = 0;
    	for( int i=0; i<grid.length; i++ )
    	{
    		for( int j=0; j<grid[0].length; j++ )
    		{
    			if( grid[i][j] == 1 )
    			{
    				island++;
    				// 从第二行第二列开始判断
        			if( i>0 && grid[i-1][j]==1 )
        			{
        				neighbor++;
        			}
        			if( j>0 && grid[i][j-1]==1 )
        			{
        				neighbor++;
        			}
    			}
    		}
    	}
        return island*4-neighbor*2;
    }
	
	//============================================//
	
    public int islandPerimeter2(int[][] grid) {
    	// 先用最直观的方法，逐个判断
    	int result = 0;
    	for( int i=0; i<grid.length; i++ )
    	{
    		for( int j=0; j<grid[0].length; j++ )
    		{
    			result += checkOne( grid, i, j );
    		}
    	}
        return result;
    }
    
    // 单独检查一个位置
    private int checkOne( int[][] grid, int i, int j )
    {
    	int result = 0;
    	if( grid[i][j] == 0 )
    	{
    		return result;
    	}
    	
    	if( i==0 || grid[i-1][j]==0 )
    	{
    		result++;
    	}
    	if( j==0 || grid[i][j-1]==0 )
    	{
    		result++;
    	}
    	if( i==grid.length-1 || grid[i+1][j]==0 )
    	{
    		result++;
    	}
    	if( j==grid[0].length-1 || grid[i][j+1]==0 )
    	{
    		result++;
    	}
    	return result;
    }
}
