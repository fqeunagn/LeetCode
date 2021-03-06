class Solution {
    public int countBattleships(char[][] board) {
        //改良版本，只需要遍历一次，从左上到右下，只有当左边和上边都不是战船的时候，才计数战船，空间复杂度O(1)，时间复杂度O(n)  
	
    	int count = 0;
    	for( int i=0; i<board.length; i++ )
    	{
    		for( int j=0; j<board[0].length; j++ )
    		{
    			//判断依据：
    			//1、本身是X
    			//2、左和上是边界，或左和上都不是X
    			if( board[i][j]=='X' && ( i==0 || board[i-1][j]=='.' ) && ( j==0 || board[i][j-1]=='.' ) )
    			{
    				count++;
    			}
    		}
    	} 
    	
    	return count;
    }
    
    //============================================//
	
    public int countBattleships(char[][] board) {
        //这是一开始的想法，相对复杂，空间使用O(n)，
    	
    	//创建一个和当前矩阵一样大的矩阵，用于判断是否已经计算过
    	int[][] check = new int[board.length][board[0].length];
    	
    	//遍历传入矩阵，进行计数，同时通过判断矩阵进行判断
    	int count = 0;
    	for( int i=0; i<board.length; i++ )
    	{
    		for( int j=0; j<board[0].length; j++ )
    		{
    			//如果不是战船，或者是已经统计过的战船，则略过
    			if( board[i][j]=='.' || check[i][j]==1 )
    			{
    				continue;
    			}
    			
    			//是战船的，统计并录入判断矩阵
    			count++;
    			countShip( board, check, i, j );
    		}
    	}
    	
    	return count;
    }

	//记录判断矩阵
	private void countShip(char[][] board, int[][] check, int i, int j) {
		for( int a=i; a<board.length; a++ )
		{
			if( board[a][j]=='X' )
			{
				check[a][j] = 1;
			}else
			{
				break;
			}
		}
		
		for( int b=j; b<board[0].length; b++ )
		{
			if( board[i][b]=='X' )
			{
				check[i][b] = 1;
			}else
			{
				break;
			}
		}
	}    
}
