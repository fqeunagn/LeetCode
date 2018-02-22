class Solution {
    public boolean judgeCircle(String moves) {
        int[] result = new int[26];

        //直接统计UDLR的数量，最后直接比较其数量
        for( char m : moves.toCharArray() )  
        {
            result[ m-'A' ]++;
        }
        
        return result['U'-'A']==result['D'-'A']&&result['L'-'A']==result['R'-'A'];
    }
    
    //====================================================//
    
    public boolean judgeCircle(String moves) {
        //通过计算UDLR操作的次数，计算其是否可回到原点
        int x = 0;
        int y = 0;
        for( char m : moves.toCharArray() )  
        {
            switch (m)
            {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    break;
            }
        }
        
        return x==0&&y==0?true:false;
    }
}
