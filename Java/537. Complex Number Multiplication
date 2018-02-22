class Solution {
    public String complexNumberMultiply(String a, String b) {
        P x = getAB( a );
        P y = getAB( b );
        
        //没什么特别的：(a+bi)(c+di)=(ac-bd)+(bc+ad)i
        int i = x.a * y.a - x.b * y.b;
        int j = x.b * y.a + x.a * y.b;
        
        return i + "+" + j + "i";
    }
    
    private P getAB( String s )
    {
        int index = s.indexOf("+");
        P tmp = new P();
        tmp.a = Integer.parseInt(s.substring( 0, index ));
        tmp.b = Integer.parseInt(s.substring( index+1, s.length()-1 ));
        
        return tmp;
    }
    
    public static class P
    {
        int a;
        int b;
    }
        
        
}
