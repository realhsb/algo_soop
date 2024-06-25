package dp;

// BOJ 2133 타일채우기 

import java.util.Scanner;

public class BOJ_2133_타일채우기 {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) {
		setting();
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		
		for (int i = 4; i <= N; i += 2) { // 4, 6, 8, ...
			dp[i] = 3 * dp[i - 2];
			for (int j = i; j >= 4; j -= 2) {
				dp[i] += dp[i - j] * 2;
			}
		}
		
		for (int i: dp) {
			System.out.print(i + " ");
		}
		System.out.println(dp[N]);
	}
	
	static void setting() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
//		dp = new int[N + 1];
		dp = new int[31];
	}
}
