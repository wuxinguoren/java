package leetcode0116;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		// System.out.print(wordPattern("a","cddc"));
		Solution s = new Solution();
		ListNode a1 = s.new ListNode(1);
		ListNode a2 = s.new ListNode(2);
		ListNode a3 = s.new ListNode(3);
		ListNode a4 = s.new ListNode(4);
		ListNode a5 = s.new ListNode(5);
		ListNode a6 = s.new ListNode(6);
		ListNode a7 = s.new ListNode(7);
		ListNode a8 = s.new ListNode(8);
		ListNode a9 = s.new ListNode(9);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a9;
		int[] test = {2,1,5,6,2,3};
		largestRectangleArea(test);
	}

	public String getHint(String secret, String guess) {
		int bulls = 0;
		int[] nums1 = new int[10];
		int[] nums2 = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) {
				bulls++;
			} else {
				nums1[s - '0']++;
				nums2[g - '0']++;
			}
		}
		int cows = 0;
		for (int i = 0; i < 10; i++) {
			cows += Math.min(nums1[i], nums2[i]);
		}
		return bulls + "A" + cows + "B";
	}

	public boolean wordPattern(String pattern, String str) {
		HashMap<String, Integer> hm = new HashMap<>();
		HashMap<Character, Integer> hm1 = new HashMap<>();
		String[] s = str.split(" ");
		char[] pa = pattern.toCharArray();
		int len = s.length;
		if (len != pa.length)
			return false;
		int cur = 0;
		for (int i = 0; i < len; i++) {
			if (hm.containsKey(s[i]) && hm1.containsKey(pa[i])) {
				if (hm.get(s[i]) != hm1.get(pa[i]))
					return false;
			} else {
				if (hm.containsKey(s[i]) || hm1.containsKey(pa[i]))
					return false;
				hm.put(s[i], cur);
				hm1.put(pa[i], cur);
				cur++;
			}
		}
		return true;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode even = head;
		ListNode odd = head.next;
		ListNode oddhead = odd;
		while (odd != null && odd.next != null) {
			even.next = odd.next;
			even = even.next;
			odd.next = even.next;
			even.next = oddhead;
			odd = odd.next;

		}
		return head;
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		int sum =0;
		int len = heights.length;
		for(int i=0;i<len;i++){
			if(s.empty()||heights[i]>heights[s.peek()])s.push(i);
			else{
				int tmp = s.pop();
				sum = Math.max(sum, heights[tmp]*(s.empty()?i:i-s.peek()-1));
				i--;
			}
		}
		return sum;
	}
}
