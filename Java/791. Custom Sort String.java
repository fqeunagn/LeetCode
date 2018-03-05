class Solution {
    public String customSortString(String S, String T) {
    	// 换一种思路
    	// 1、由于S和T都只有小写字母，可以通过一个数组记录顺序
    	// 2、由于T里的字母，在S中不存在时，可以随意处理，带来了很大的自由度。所以我们先处理在S中存在的，然后统一处理不存在的
    	
    	// 首先遍历目标数组T，将所有字母出现的次数进行记录到一个数组中
    	int[] map = new int[26];
    	for( char t : T.toCharArray() )
    	{
    		map[t-'a']++;
    	}
    	
    	// 遍历S，根据刚才的数组进行判断，把在S中存在的所有字母按顺序列出（这个就是排序过程）
    	StringBuilder sb = new StringBuilder();
    	for( char s : S.toCharArray() )
    	{
    		// 在数组中记录了多少次，就得输出多少次；
    		while( map[s-'a']-- > 0 )
    		{
    			sb.append(s);
    		}
    	}
    	
    	// 将数组中剩下的字母全部输出，完成最后的排序
    	for( char x='a'; x<='z'; x++ )
    	{
    		while( map[x-'a']-- > 0 )
    		{
    			sb.append(x);
    		}
    	}
    	return sb.toString();
    }
	
	//============================================================//
	
	// 不搞这静态属性无法把排序信息传入sort里
	private static Map<Character, Integer> sortValue = new HashMap<Character, Integer>();
    public String customSortString2(String S, String T) {
        // 题目要求按照S给出的字母顺序进行排序
    	// 思路：首先根据S建立一个排序规则，然后直接使用Java内建函数对T进行排序
    	int i=1;
    	for( char c : S.toCharArray() )
    	{
    		sortValue.put(c, i++);
    	}
    	
    	// 使用Java内建函数对char数组排序挺麻烦的
    	Character[] cc = new Character[T.length()];
    	for( i=0; i<T.length(); i++ )
    	{
    		cc[i] = T.charAt(i);
    	}
    	/*
    	 *  在 JDK7 版本以上，Comparator 要满足自反性，传递性，对称性，不然 Arrays.sort，
    	 *  Collections.sort 会报 IllegalArgumentException 异常。
    	 *  说明：
    	 *  1） 自反性：x，y 的比较结果和 y，x 的比较结果相反。
    	 *  2） 传递性：x>y,y>z,则 x>z。
    	 *  3） 对称性：x=y,则 x,z 比较结果和 y，z 比较结果相同。
    	 * 
    	    // 例如，这种写法就会在JDK7里报错
			public int compare(Character paramT1, Character paramT2) {
				Integer n1 = sortValue.get(paramT1);
				Integer n2 = sortValue.get(paramT2);
				if( n1==null && n2==null )
				{
					return 0;
				}else if( n1==null || n2==null )
				{
					return n1==null?n2:n1;
				}
				return n1-n2;
			}
		*/
    	// 现在这种写法没问题了
    	Arrays.sort(cc, new Comparator<Character>(){
			@Override
			public int compare(Character paramT1, Character paramT2) {
				Integer n1 = sortValue.get(paramT1);
				Integer n2 = sortValue.get(paramT2);
				n1 = n1==null?0:n1;
				n2 = n2==null?0:n2;
				return n1-n2;
			}
    	});
    	
    	// 将Character数组变回String
    	StringBuilder sb = new StringBuilder(cc.length);
    	for( char c : cc )
    	{
    		sb.append(c);
    	}
    	return sb.toString();
    }
}
