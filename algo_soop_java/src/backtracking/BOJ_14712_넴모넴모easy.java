package backtracking;

// BOJ 14712 넴모넴모easy

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712_넴모넴모easy {
	
	static int N, M, count; // n -> row , m -> col
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		setting();
		solution(0, 0);
		System.out.println(count);
	}
	
	static void solution(int row, int col) {
		
		if (row == N) {	// 넴모가 다 배치되었을 때, 
						// 2 x 2를 만족하는 넴모가 있는지 확인 
			for (int i = 0; i <= N - 2; i++) {	// (0, 0) ~ (n-2, m-2)
				for (int j = 0; j <= M - 2; j++) {
					// 있다면 종료 
					if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) return;
				}
			}
			
			count++;	// 2 x 2 넴모가 없으므로 count 증가 
			return;
		}
		
		int nextCol = (col + 1 == M) ? 0 : col + 1;
		int nextRow = (nextCol == 0) ? row + 1 : row;
		
		// 넴모 조합 후, 연산 
		map[row][col] = true;
		solution(nextRow, nextCol);
		
		map[row][col] = false;
		solution(nextRow, nextCol);
		
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		map = new boolean[N][M];
	}
}
