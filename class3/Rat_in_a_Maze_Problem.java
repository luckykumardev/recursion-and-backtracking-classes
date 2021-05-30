package class3;

import java.util.ArrayList;
import java.util.List;

public class Rat_in_a_Maze_Problem {

	static List<String> possiblePaths = new ArrayList<>();
	static String path = "";

	static boolean isSafe(int row, int col, int m[][], int n, boolean visited[][]) {
		if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || m[row][col] == 0)
			return false;

		return true;
	}

	static void printPathHelper(int row, int col, int m[][], int n, boolean visited[][]) {
		
		if (row == n - 1 && col == n - 1) {
			possiblePaths.add(path);
			return;
		}

     	visited[row][col] = true;

		if (isSafe(row + 1, col, m, n, visited)) {
			path += 'D';
			printPathHelper(row + 1, col, m, n, visited);
			path = path.substring(0, path.length() - 1);
		}
		if (isSafe(row, col + 1, m, n, visited)) {

			path += 'R';
			printPathHelper(row, col + 1, m, n, visited);
		  	path = path.substring(0, path.length() - 1);
		}

         visited[row][col] = false;
	}

	static void printPath(int m[][], int n) {
		boolean[][] visited = new boolean[n][n];
		printPathHelper(0, 0, m, n, visited);

		for (int i = 0; i < possiblePaths.size(); i++)
			System.out.print(possiblePaths.get(i) + " ");
	}

	public static void main(String[] args) {
		int arr[][] = { 
				{ 1, 0, 0, 0, 0 }, 
				{ 1, 1, 1, 0, 1 }, 
				{ 1, 1, 1, 1, 1 }, 
				{ 0, 0, 0, 0, 1 }, 
				{ 0, 0, 0, 0, 1 } 
			    };
		int n = arr.length;
        
		printPath(arr, n);
	}
}