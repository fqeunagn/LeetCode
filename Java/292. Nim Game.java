class Solution {
    public boolean canWinNim(int n) {
    	// 这道题用巧妙的方法可以解决，先从少到多看看必胜情况：
    	// 1颗-3颗：先手必胜，直接拿完；
    	// 4颗：后手必胜，先手不管拿多少，后手都可以全部拿完；
    	// 5颗-7颗：先手必胜，分别拿1/2/3颗，给后手剩下4颗，然后后手陷入场景2；
    	// 8颗：后手必胜，先手不管拿多少，后手都可以控制数量留下4颗给先手，让先手进入场景2；
    	// 9颗-11颗：先手必胜，分别拿1/2/3颗，给后手剩下8颗，然后后手陷入场景4；
    	// 汇总以上分析，对于一个玩家，当他面对着4n颗石头时候必败，面对其他颗数石头时，则必胜（可以通过拿走一些石头，使对手面对4n颗石头）；
    	
        return n%4 != 0;
    }
}