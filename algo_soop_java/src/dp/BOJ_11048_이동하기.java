package dp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.stream.*;

public class BOJ_11048_이동하기 {
	
	static int n, m;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		setting();
		dp();
		System.out.println(dp[n][m]);
	}
	
	static void dp() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] =  Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + map[i][j];
			}	// for_j
		}	// for_i
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
