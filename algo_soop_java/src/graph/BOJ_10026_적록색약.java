package graph;

// https://www.acmicpc.net/problem/10026

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static char[][] field;
	static int N;
	static Queue<int[]> queue;
	static int[] answer = new int[2];
	
	public static void main(String[] args) throws IOException {
		setting();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, true);
					answer[1]++;
				}
			}
		}
		
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, false);
					answer[0]++;
				}
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N][N];
		field = new char[N][N];
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			field[i] = br.readLine().toCharArray();
		}
	}
	
	static void bfs(int x, int y, boolean check) {
		queue.add(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			visited[now[0]][now[1]] = true;	// 방문 체크 
			
			for (int i = 0; i < 4; i++) {
				int x_ = now[0] + dx[i];
				int y_ = now[1] + dy[i];
				
				if (x_ < 0 || y_ < 0 || x_ >= N || y_ >= N || visited[x_][y_]) continue;	// 범위를 벗어나거나, 방문했던 곳이면 continue
				
				if (check) {	// 적록색맹인 경우 
					if (field[x][y] == 'B' && field[x_][y_] == 'B') {
						queue.add(new int[] {x_, y_});
						visited[x_][y_] = true;
					}
					else if (field[x][y] != 'B' && field[x_][y_] != 'B') {
						queue.add(new int[] {x_, y_});
						visited[x_][y_] = true;
					}
				} else {		// 아닌 경우 
					if (field[x][y] == field[x_][y_]) {
						queue.add(new int[] {x_, y_});
						visited[x_][y_] = true;
					}
				}
			}
		}
		
		return;
	}
}
