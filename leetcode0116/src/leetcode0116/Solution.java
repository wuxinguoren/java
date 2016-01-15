package leetcode0116;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		System.out.print(wordPattern("a","cddc"));
	}
	
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            }
            else{
                nums1[s - '0']++;
                nums2[g - '0']++;
            }
        }
        int cows = 0;
        for(int i = 0; i < 10; i++){
            cows += Math.min(nums1[i], nums2[i]);
        }
        return bulls + "A" + cows + "B";              
    }
    
    public static boolean wordPattern(String pattern, String str) {
    	HashMap<String, Integer> hm = new HashMap<>();
    	HashMap<Character, Integer> hm1 = new HashMap<>();
    	String[] s = str.split(" ");
    	char[] pa = pattern.toCharArray();
    	int len = s.length;
    	if(len!=pa.length)return false;
    	int cur=0;
    	for(int i=0;i<len;i++){
    		if(hm.containsKey(s[i])&&hm1.containsKey(pa[i])){
        		if(hm.get(s[i]) != hm1.get(pa[i]))return false;
    		}else{
    			if(hm.containsKey(s[i])||hm1.containsKey(pa[i]))return false;
    			hm.put(s[i], cur);
    			hm1.put(pa[i], cur);
    			cur++;
    		}
    	}
    	return true;
    }
}
