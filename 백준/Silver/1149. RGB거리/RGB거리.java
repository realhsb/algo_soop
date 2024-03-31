import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.*;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dp;
	static int MAX_VALUE = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		setting();
		dp();
		System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
	}
	
	static void dp() {
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + map[i][j];
			}
		}
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][3];
		dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = MAX_VALUE;
			}
		}
	}
}
