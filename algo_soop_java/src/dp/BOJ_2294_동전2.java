package dp;

// BOJ 2294 동전2

/*
 * 점화식 
 * dp[j] = MIN(dp[j], dp[j - coins[i]]
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2294_동전2 {
	
	static int N, K, answer;	// 동전 종류 N, 동전의 가치 합 K
	static int[] coins;	// 동전 가치 배열 
	static int[] dp;
	static int MAX_VALUE = 10001;
	
	public static void main(String args[]) throws IOException {
		setting();
		
		for (int i = 0; i < N; i++) {	// 동전마다 배열을 돌면서 가치를 만들 수 있는 코인의 개수 
			for (int j = coins[i]; j < K + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
			}
		}
		
		if (dp[K] == 10001) answer = -1;
		else answer = dp[K];
		
		System.out.println(answer);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		
		coins = new int[N];
		dp = new int[K + 1];
		
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= K; i++) {
			dp[i] = MAX_VALUE;
		}
		
		dp[0] = 0; // 0원 가치를 만드는 방법은 0가지 
	}
}
