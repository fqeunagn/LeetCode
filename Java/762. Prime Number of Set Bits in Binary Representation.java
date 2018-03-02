class Solution {
    public int countPrimeSetBits(int L, int R) {
        // 直观上看需要：从L到R逐个找出每个数字的1数量，然后判断该数量是否质数，是则count++
    	int result = 0;
    	for( int i=L; i<=R; i++ )
    	{
    		if( isPrime( countSetBits( i ) ) )
    		{
    			result++;
    		}
    	}
    	return result;
    }
    
    // 检查是否质数，直接通过一个32之下的质数全集判断即可
    // 不过由于题目说明的R输入最多10^6，所以质数23、29、31其实可以不放进Set里面
    private static Set<Integer> primeNum = new HashSet<Integer>();
    {
    	// 初始化Set的第一种方法，逐个放入
    	primeNum.add(2);
    	primeNum.add(3);
    	primeNum.add(5);
    	primeNum.add(7);
    	primeNum.add(11);
    	primeNum.add(13);
    	primeNum.add(17);
    	primeNum.add(19);
    	primeNum.add(23);
    	primeNum.add(29);
    	primeNum.add(31);
    }
    {
    	// 初始化Set的第二种方法，简单多了
    	primeNum = new HashSet<Integer>( Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 , 23, 29, 31) );
    }
    private boolean isPrime( int num )
    {
    	return primeNum.contains(num);
    }
    
    // 计算1的数量
    private int countSetBits( int num )
    {
    	// 直接使用Java内建函数
    	return Integer.bitCount(num);
    }
}
