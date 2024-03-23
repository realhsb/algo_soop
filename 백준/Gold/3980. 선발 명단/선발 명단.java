// BOJ 3980 선발명단

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.*;

public class Main {
	
	static int C, sum;
	static int max = 0;
	static int[][] map = new int[11][11];
	static boolean[] isVisited = new boolean[11];
	static int[] output = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());

		
		for (int c = 0; c < C; c++) {
			max = 0;
			sum = 0;
			isVisited = new boolean[11];
			output = new int[11];
			for (int i = 0; i < 11; i++) {
				map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			solution(isVisited, output, 0, 0);
			System.out.println(max);
		}
	}
	
	static void solution(boolean[] visited, int[] output, int depth, int j) {
		if (depth == 11) {
			sum = 0;
			for (int o : output) sum += o;
			max = Math.max(max, sum);
			return;
		}
		
		for (int a = 0; a < 11; a++) {
			if (map[depth][a] == 0) continue;
			if (!visited[a]) {
				visited[a] = true;
				output[depth] = map[depth][a];
				solution(visited, output, depth + 1, a);
				visited[a] = false;
			}
		}
	}
}
