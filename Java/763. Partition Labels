class Solution {
    public List<Integer> partitionLabels(String S) {
        //1、不需要记住每个字母的首尾区间，只需要记住尾部即可
        int[] area = new int[26];
        for( int i=0; i<S.length(); i++ )
        {
            area[ S.charAt(i)-'a' ] = i;
        }
            
        //2、再次遍历，遍历点就是首，遍历点字母对应的尾判断是否可作为尾，当遍历点（首）等于尾时，即认为可以间隔
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<Integer>();
        for( int i=0; i<S.length(); i++ )
        {
            right = Math.max( right, area[S.charAt(i) - 'a'] );
            if( i == right )
            {
                result.add( right - left + 1);
                left = right + 1;
            }
        }
        
        return result;
    }
    
    //==============================================//
    public List<Integer> partitionLabels(String S) {
        //1、找出每个字母的区间
        Map<Character, P> area = new HashMap<Character, P>();
        
        for( int i=0; i<S.length(); i++ )
        {
            if( area.containsKey( S.charAt(i) ) )
            {
                area.get(S.charAt(i)).y = i;
            }else
            {
                area.put( S.charAt(i), new P() );
                area.get(S.charAt(i)).x = i;
            }
        }
        
        //2、区间累加，计算结果为0的就是断点
        int[] check = new int[ S.length() ];
        
        for( P tmp : area.values() )
        {
            if( tmp.x > tmp.y )
            {
                continue;
            }
            for( int i=tmp.x; i<tmp.y; i++ )
            {
                check[i]++;
            }
        }
        
        //3、按照断点计算间隔长度
        List<Integer> result = new ArrayList<Integer>();
        int tmp = 0;
        for( int i : check )
        {
            tmp++;
            if( i == 0 )
            {
                result.add( tmp );
                tmp = 0;
            }
        }
        
        return result;
    }
    
    public static class P
    {
        public int x = -1;
        public int y = -1;
    }
    
    
}
