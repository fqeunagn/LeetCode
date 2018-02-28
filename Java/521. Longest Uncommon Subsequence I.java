class Solution {
    public int findLUSlength(String a, String b) {
        // 这个问题很坑，“最长的【不同】子串”，换言之，除非两个字符串相等，否则就是长的那个字符串的长度。
    	return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
