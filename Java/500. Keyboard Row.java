class Solution {
	public String[] findWords(String[] words) {
		 // 用正则表达式匹配，更为简洁，但是运行较慢，runtime=8ms
		String regex = "[qwertyuiopQWERTYUIOP]*|[asdfghjklASDFGHJKL]*|[zxcvbnmZXCVBNM]*";
		List<String> resultList = new ArrayList<String>();
		for( String word : words )
		{
			if( word.matches(regex) )
			{
				resultList.add(word);
			}
		}
		
		return resultList.toArray(new String[0]);
	}
	
	//==============================================//
	
    public String[] findWords2(String[] words) {
    	// 用一个数组把每一行的信息存下来并赋值，runtime=2ms
        int[] w = new int['z'+1];
        w['q']=w['Q']=w['w']=w['W']=w['e']=w['E']=w['r']=w['R']=w['t']=w['T']=w['y']=w['Y']=w['u']=w['U']=w['i']=w['I']=w['o']=w['O']=w['p']=w['P']=1;
        w['a']=w['A']=w['s']=w['S']=w['d']=w['D']=w['f']=w['F']=w['g']=w['G']=w['h']=w['H']=w['j']=w['J']=w['k']=w['K']=w['l']=w['L']=10;
        w['z']=w['Z']=w['x']=w['X']=w['c']=w['C']=w['v']=w['V']=w['b']=w['B']=w['n']=w['N']=w['m']=w['M']=100;
        
        // 遍历所有String，逐个校验
        List<String> resultList = new ArrayList<String>();
        for( String word : words )
        {
        	int check = w[ word.charAt(0) ];
        	for( char c : word.toCharArray() )
        	{
        		if( w[c] != check )
        		{
        			check = -1;
        			break;
        		}
        	}
        	if( check != -1 )
        	{
        		resultList.add(word);
        	}
        }
        
        String[] result = resultList.toArray(new String[0]);
        return result;
    }
}
