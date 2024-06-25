package dp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	
	static int n;
	static int num;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[11];
		
		dp[1] = 1;	// 1 = 1
		dp[2] = 2;	// 2 = 1 + 1 = 2
		dp[3] = 4;	// 3 = 1 + 1 + 1 = 1 + 2 = 2 + 1
		
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			
			sb.append(dp[num]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void setting() throws IOException {

	}
}
