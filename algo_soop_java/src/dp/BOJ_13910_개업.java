package dp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13910_개업 {
	
	static int[] woks;
	static int[] dp;
	static int n, m;
	static final int MAX = 10001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		woks = new int[MAX];
		dp = new int[n + 1];
		
		woks[0] = 1;
		dp[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			woks[Integer.parseInt(st.nextToken())]++;
		}
		
		for (int i = 1; i <= n; i++) {
			dp[i] = MAX;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i / 2; j++) {
				if (j == i - j && woks[j] >= 2) {	// 두 웍의 사이즈가 같고, 그 웍이 2개 이상 있을 경우 
					dp[i] = 1;
				} else if (j != i - j && woks[j] > 0 && woks[i - j] > 0) {
					dp[i] = 1;						// 종류가 다른 웍 2개로 한 번에 요리 가능한 경우 
				} else if (dp[j] != MAX && dp[i - j] != MAX) {
					dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
				}
			}
		}
		
		System.out.println(dp[n] >= MAX ? -1 : dp[n]);
	}
}
