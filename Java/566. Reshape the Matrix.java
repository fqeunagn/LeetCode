class Solution {
	 public int[][] matrixReshape(int[][] nums, int r, int c) {
	    	// 大小不一致的直接略过
	        if( nums.length*nums[0].length != r*c )
	        {
	            return nums;
	        }
	        
	        // 看discuss说单循环会更快？试试看
	        // 结论：变得更慢了，原本的双循环是7ms，换成这个单循环要10ms
	        int[][] result = new int[r][c];
	        int n = nums[0].length;
	        for( int i=0; i<r*c; i++ )
	        {
                result[i/c][i%c] = nums[i/n][i%n];
	        }
	        
	        return result;
	    }
	 
	//===================================//
	
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
    	// 大小不一致的直接略过
        if( nums.length*nums[0].length != r*c )
        {
            return nums;
        }
        
        // 对于 r、c，一维索引 index，坐标x、y，有：x*c+y=index；
        // x = index / c
        // y = index % c
        int[][] result = new int[r][c];
        int index = 0;
        for( int i=0; i<nums.length; i++ )
        {
            for( int j=0; j<nums[0].length; j++ )
            {
                result[index/c][index%c] = nums[i][j];
                
                index++;
            }
        }
        
        return result;
    }
}
