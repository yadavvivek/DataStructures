package com.vivek.problems;

public class ReplaceStr {
	
	
	public static void main(String args []) {
		ReplaceStr rs = new ReplaceStr();
	
		System.out.println("Reversed String: "+ rs.reverse("(x$l$`ek]$intly$l$ysbzatm"));
	}

	public String reverse(String str)
    {
        //complete the function here
        int aU = 'a';
        int zU = 'z';
        int AU = 'A';
        int ZU = 'Z';
        
        int i = 0, j = str.length()-1;
        
        System.out.println("aU: "+aU+", zU: "+zU+", AU: "+AU+", ZU: "+ZU+", j: "+j);
        while(i < j) {
        	System.out.println("i: "+i+ ",  j: "+j);
        	char ch_i = str.charAt(i);
            int iU = ch_i;
            System.out.println("ch_i: "+ch_i+", iU: "+iU);
            if((iU < aU || iU > zU) && (iU < AU || iU > ZU)) {
                i++;
                continue;
            }
            char ch_j = str.charAt(j);
            int jU = ch_j;
            System.out.println("J: ch_j: "+ch_j+", jU: "+jU);
            
            if((jU < aU || jU > zU) && (jU < AU || jU > ZU)) {
                j--;
                continue;
            }
            
            char temp = str.charAt(i);
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(i, str.charAt(j));
            sb.setCharAt(j, temp);
            str = sb.toString();
            i++;
            j--;
        }
        
        return str;
    }
}
