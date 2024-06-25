package backtracking;

import java.util.Scanner;

public class BOJ_1174_줄어드는수_retry {
	
	static int N;	// N은 1,000,000보다 작거나 같은 자연수 (0아님 )
	static int count;
	static int[] arr;
	static boolean[] isVisited;
	static int[] answer;
	
	public static void main(String[] args) {
		setting();
		
		for (int i = 1; i <= 10; i++) {	// 뽑는 숫자 개수 
			isVisited = new boolean[10];
			if (i == 0) {
				combination(isVisited, 1, i);
			} else {
				combination(isVisited, 0, i);
			}
		}
	}
	
	static void setting() {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();	
		count = 0;
		answer = new int[10];	// 정답 숫자 
		arr = new int[N];
		isVisited = new boolean[10]; // 0 ~ 9
	}
	
	static void combination(boolean[] isVisited, int start, int r) {	// 방문여부, 마지막 숫자, 뽑은 개수, 뽑을 개수 
		if (r == 0) {
			count++;
			System.out.println(count);
			return;
		}
		
		for (int i = start - 1; i > 0; i--) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				combination(isVisited, start + 1, r--);
				isVisited[i] = false;
			}
		}
	}
}
