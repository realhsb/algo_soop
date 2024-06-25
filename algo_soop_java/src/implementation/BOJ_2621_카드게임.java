package implementation;

import java.util.Arrays;

// https://www.acmicpc.net/problem/2621

import java.util.Scanner;

public class BOJ_2621_카드게임 {
	
	static int[] colors = new int[4];	// { R, G, B, Y }
	static int[] num_count = new int[10];		// { 0 ~ 9 }
	static int[] nums = new int[5];
	static int N = 5;
	static int answer = 0;
	
	public static void main(String[] args) {
		setting();
		
		if (isContinuous()) {	// 숫자 5개 연속?
			if (getMax(colors) == 5) answer = nums[4] + 900; 					// 1
			else answer = nums[4] + 500;										// 5
		} else if (getMax(num_count) == 4) answer = getNumFromCount(4) + 800;	// 2

		else if (getMax(num_count) == 3) {
			if (getMin(num_count) == 2) {	// (3장, 2장)
				answer = getNumFromCount(3) * 10 + getNumFromCount(2) + 700;	// 3
			} else {	// (3장, 1장, 1장)
				answer = getNumFromCount(3) + 400;								// 6
			}
		}
		else if (getMax(colors) == 5) answer = getMax(nums) + 600;				// 4
		else if (getMax(num_count) == 2) {
			int a = 0, b = 0;
			for (int i = 1; i < num_count.length; i++) {
				if (num_count[i] == 2) {
					if (a == 0) a = i;
					else b = i;
				}
			}
			if (b == 0) answer = a + 200;
			else if (a > b) answer = a * 10 + b + 300;
			else answer = b * 10 + a + 300;
		} else {
			answer = getMax(nums) + 100;
		}
		
		System.out.println(answer);
	}
	
	static void setting() {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			char[] arr = scan.nextLine().toCharArray();
			switch(arr[0]) {
			case 'R' :
				colors[0]++;
				break;
			case 'G' :
				colors[1]++;
				break;
			case 'B' :
				colors[2]++;
				break;
			case 'Y' :
				colors[3]++;
				break;
			}
			
			num_count[arr[2] - '0']++;
			nums[i] = arr[2]  - '0';
		}
		Arrays.sort(nums);
	}
	
	static int getMax(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}
	
	static int getMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				min = Math.min(min, arr[i]);
			}
		}
		
		return min;
	}
	
	static int getNumFromCount(int a) {
		int num = 0;
		for (int i = 1; i < num_count.length; i++) {
			if (num_count[i] == a) num = i;
		}
		return num;
	}
	
	static boolean isContinuous() {
		for (int i = 1; i < N; i++) {
			if (nums[i - 1] + 1 != nums[i]) return false;
		}
		return true;
	}
}
