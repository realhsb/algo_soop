package backtracking;

// BOJ 12100 2048 (Easy)
// Backtracking + Implementation


/*
 * Input 1
 * 	3	
	2 2 2
	4 4 4
	8 8 8
 * 
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.*;
import java.util.Stack;

public class BOJ_12100_2048Easy {
	
	static int n;
	static int[][] map;
	static int answer  = -1;
	
	public static void main(String[] args) throws IOException {
		
		setting();
//		combineLeft(map);
//		combineRight(map);
//		combineUp(map);
//		combineUp(map);
	}
	
	static void backtracking(int depth, int[][] map) {
		if (depth == 5) {
			answer = getMax(map);
			return;
		} else {
			
			combineUp(map);
		}
	}
	
//	static int[][] combine(int[][] map, Stack<Integer> stack, boolean check, int i) {
//		int index = 0;
//		while (!stack.isEmpty() && stack.size() > 1) {
//			int num1 = stack.pop();
//			int num2 = stack.peek();
//			
//			if (num1 == num2) {
//				map[index++][i] = num1 + num2;
//				stack.pop();
//				check = true;
//			} else {
//				map[index++][i] = num1;
//			}
//		}
//		
//		while(!stack.isEmpty()) {
//			map[index++][i] = stack.pop();
//		}
//		return map;
//	}
	 
	static boolean combineUp(int[][] map) {	// 블럭 위로 보내기 
		
		System.out.println("----- combine up -----");
		boolean check = false;
		for (int i = 0; i < n; i++) {	
			Stack<Integer> stack = new Stack<>();
			for (int j = n - 1; j >= 0; j--) {
				if (map[j][i] != 0) {
					stack.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			
			// 한 번 합치는 것을 성공했다면, 다시 위에서부터 검색 
			int index = 0;
			while (!stack.isEmpty() && stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.peek();
				
				if (num1 == num2) {
					map[index++][i] = num1 + num2;
					stack.pop();
					check = true;
				} else {
					map[index++][i] = num1;
				}
			}
			
			while(!stack.isEmpty()) {
				map[index++][i] = stack.pop();
			}
		}
		
		printMap(map);
		return check;
	}
	
	static boolean combineDown(int[][] map) {	// 블럭 아래로 보내기 
		
		System.out.println("----- combine down -----");
		boolean check = false;
		for (int i = 0; i < n; i++) {	
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < n; j++) {
				if (map[j][i] != 0) {
					stack.add(map[j][i]);
					map[j][i] = 0;
				}
			}
			
			// 한 번 합치는 것을 성공했다면, 다시 위에서부터 검색 
			int index = n - 1;
			while (!stack.isEmpty() && stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.peek();
				
				if (num1 == num2) {
					map[index--][i] = num1 + num2;
					stack.pop();
					check = true;
				} else {
					map[index--][i] = num1;
				}
			}
			
			while(!stack.isEmpty()) {
				map[index--][i] = stack.pop();
			}
		}
		
		printMap(map);
		return check;
	}
	
	static boolean combineLeft(int[][] map) {	// 블럭 위로 보내기 
		
		System.out.println("----- combine left -----");
		boolean check = false;
		for (int i = 0; i < n; i++) {	
			Stack<Integer> stack = new Stack<>();
			for (int j = n - 1; j >= 0; j--) {
				if (map[i][j] != 0) {
					stack.add(map[i][j]);
					map[i][j] = 0;
				}
			}
			
			// 한 번 합치는 것을 성공했다면, 다시 위에서부터 검색 
			int index = 0;
			while (!stack.isEmpty() && stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.peek();
				
				if (num1 == num2) {
					map[i][index++] = num1 + num2;
					stack.pop();
					check = true;
				} else {
					map[i][index++] = num1;
				}
			}
			
			while(!stack.isEmpty()) {
				map[i][index++] = stack.pop();
			}
		}
		
		printMap(map);
		return check;
	}
	
	static boolean combineRight(int[][] map) {	// 블럭 아래로 보내기 
		
		System.out.println("----- combine right -----");
		boolean check = false;
		for (int i = 0; i < n; i++) {	
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					stack.add(map[i][j]);
					map[i][j] = 0;
				}
			}
			
			// 한 번 합치는 것을 성공했다면, 다시 위에서부터 검색 
			int index = n - 1;
			while (!stack.isEmpty() && stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.peek();
				
				if (num1 == num2) {
					map[i][index--] = num1 + num2;
					stack.pop();
					check = true;
				} else {
					map[i][index--] = num1;
				}
			}
			
			while(!stack.isEmpty()) {
				map[i][index--] = stack.pop();
			}
		}
		
		printMap(map);
		return check;
	}
	
	static int getMax(int[][] map) {
		int max = -1;
		for (int[] m : map) {
			for (int a : m) {
				max = Math.max(max, a);
			}
		}
		
		return max;
	}
	
	static void printMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		
		for (int[] m : map) {
			for (int a : m) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void setting() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}
}


