// BOJ 14722 우유도시

/*
 * 0 -> 1 -> 2 (딸기 -> 바나나 -> 초코)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] field;
	static int[][] dp;
	static int milk = 0; // 현재 마셔야 하는 우유 종류 
	static boolean up, left;
	static int up_score, left_score;
	
	public static void main(String[] args) throws IOException {
		setting();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				
				if (dp[i][j] % 3 == field[i][j]) dp[i][j]++;
			}
		}
		System.out.println(dp[N][N]);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		field = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];		// [][][0] == 마신 우유 종류, [][][1] == 마신 우유 개수  
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
