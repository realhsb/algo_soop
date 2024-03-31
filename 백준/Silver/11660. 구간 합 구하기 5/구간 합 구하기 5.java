import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int[][] xy;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		setting();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			sb.append(dp(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int dp(int m) {
		int x1 = xy[m][0];
		int y1 = xy[m][1];
		int x2 = xy[m][2];
		int y2 = xy[m][3];
		
		int answer = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
		return answer;
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		xy = new int[M][4];
		
		// 표에 값 채우기 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 계산할 x, y 좌표 담기 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				xy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적합 구하기 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
			}
		}
	}
}