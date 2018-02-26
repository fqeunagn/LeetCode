class Solution {
    public String reverseString(String s) {
        if( s==null || s.isEmpty() )
        {
        	return s;
        }
        
        // 直接遍历反序输出也可以，但这里直接使用Java自带方法解决
        return new StringBuilder(s).reverse().toString();
    }
}
