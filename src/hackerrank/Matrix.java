package hackerrank;

public class Matrix {

	public static void main(String[] args) {
		//printMatrix(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } }));
		//printMatrix(updateMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }));
		printMatrix(updateMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } }));
	}

	public static int[][] updateMatrix(int[][] mat) {
		int[][] distances = new int[mat.length][mat[0].length];
		//fill with -1
		for (int m = 0; m < distances.length; m++) {
			for (int n = 0; n < distances[m].length; n++) {
				if (mat[m][n] == 0) 
					distances[m][n] = 0;
				else
					distances[m][n] = -1;
			}
		}
		
		//first step
		for (int m = 0; m < mat.length; m++) {
			for (int n = 0; n < mat[m].length; n++) {
				if (mat[m][n] == 0) {
					fillNext(mat, distances, m, n, 1);
				}
			}
		}
		
		/*for (int m = 0; m < distances.length; m++) {
			for (int n = 0; n < distances[m].length; n++) {
				if (distances[m][n] == 1) {
					fillNext(mat, distances, m, n, 2);
				}
			}
		}
		
		for (int m = 0; m < distances.length; m++) {
			for (int n = 0; n < distances[m].length; n++) {
				if (distances[m][n] == 2) {
					fillNext(mat, distances, m, n, 3);
				}
			}
		}
		
		for (int m = 0; m < distances.length; m++) {
			for (int n = 0; n < distances[m].length; n++) {
				if (distances[m][n] == 3) {
					fillNext(mat, distances, m, n, 4);
				}
			}
		}*/
		
		return distances;
	}
	
	public static void fillNext(int[][] mat, int[][] distance, int m, int n, int d) {
		if (m==1 && n==2)
			System.out.println();
		
		if ((m-1) >= 0 && mat[m-1][n] == 1 && distance[m-1][n] == -1) { 
			distance[m-1][n] = d;
			//fillNext(mat, distance, m-1, n, d+1);
		}
		if ((m+1) < mat.length && mat[m+1][n] == 1 && distance[m+1][n] == -1) {
			distance[m+1][n] = d;
			//fillNext(mat, distance, m+1, n, d+1);
		}
		if ((n-1) >= 0 && mat[m][n-1] == 1 && distance[m][n-1] == -1) {
			distance[m][n-1] = d;
			//fillNext(mat, distance, m, n-1, d+1);
		}
		if ((n+1) < mat[m].length && mat[m][n+1] == 1 && distance[m][n+1] == -1) {
			distance[m][n+1] = d;
			//fillNext(mat, distance, m, n+1, d+1);
		}
		
		if ((m-1) >= 0 && distance[m-1][n] == -1) { 
			fillNext(mat, distance, m-1, n, d+1);
		}
		if ((m+1) < mat.length && distance[m+1][n] == -1) {
			fillNext(mat, distance, m+1, n, d+1);
		}
		if ((n-1) >= 0 && distance[m][n-1] == -1) {
			fillNext(mat, distance, m, n-1, d+1);
		}
		if ((n+1) < mat[m].length && distance[m][n+1] == -1) {
			fillNext(mat, distance, m, n+1, d+1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static int distance(int[][] mat, int[][] distance, int m, int n) {
		//System.out.println(mat[m][n]);
		if (mat[m][n] == 0)
			return 1;
		
		if (((m-1) > 0 && mat[m-1][n] == 0)
				|| ((m+1) < mat.length && mat[m+1][n] == 0)
				|| ((n-1) > 0 && mat[m][n-1] == 0)
				|| ((n+1) < mat[m].length && mat[m][n+1] == 0)
				) {
			return 1;
		}
		
		//up
		if ((m-1) > 0) {
			if (distance[m-1][n] != -1) {
				return distance[m-1][n] + 1;
			} else {
				return distance(mat, distance, m-1, n) + 1;
			}
		}
		
		//bottom
		if ((m+1) < mat.length) {
			if (distance[m+1][n] != -1) {
				return distance[m+1][n] + 1;
			} else {
				return distance(mat, distance, m+1, n) + 1;
			}
		}
		
		//left
		if ((n-1) > 0) {
			if (distance[m][n-1] != -1) {
				return distance[m][n-1] + 1;
			} else {
				return distance(mat, distance, m, n-1) + 1;
			}
		}
		
		//right
		if ((n+1 < mat[m].length)) {
			if (distance[m][n+1] != -1) {
				return distance[m][n+1] + 1;
			} else {
				return distance(mat, distance, m, n+1);
			}
		}
		
		return -2;
	}
	
	private static void printMatrix(int [][] mat) {
		System.out.println();
		for (int m = 0; m < mat.length; m++) {
			for (int n = 0; n < mat[m].length; n++) {
				System.out.print(mat[m][n] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] updateMatrix2(int[][] mat) {
		int[][] distances = new int[mat.length][mat[0].length];
		boolean[][] b = new boolean[mat.length][mat[0].length];

		for (int m = 0; m < mat.length; m++) {
			for (int n = 0; n < mat[m].length; n++) {
				if (mat[m][n] != 0) {
					System.out.println("entrou " + m + " " + n);
					distanceTo0(mat, m, n, distances, b);

					System.out.println("------");
					for (int m1 = 0; m1 < distances.length; m1++) {
						System.out.println();
						for (int n1 = 0; n1 < distances[m1].length; n1++) {
							System.out.print(distances[m1][n1] + " ");
						}
					}

					System.out.println("voltou " + m + " " + n);
				}
			}
		}

		System.out.println("FINAL");
		for (int m = 0; m < distances.length; m++) {
			System.out.println();
			for (int n = 0; n < distances[m].length; n++) {
				System.out.print(distances[m][n] + " ");
			}
		}

		return distances;
	}

	private static int distanceTo0(int[][] mat, int m, int n, int[][] distances, boolean[][] b2) {
		if (m < 0 || m >= mat.length || n < 0 || n >= mat[m].length)
			return -1;

		if (distances[m][n] > 0) {
			System.out.println("AQUI FDPm:" + m + " n-1: " + (n));
			return distances[m][n];
		}

		System.out.println("m:" + m + " n: " + n);
		/*
		 * System.out.println("mat["+m+"]["+(n-1)+"]: "+mat[m][n - 1]);
		 * System.out.println("mat["+m+"]["+(n+1)+"]: "+mat[m][n + 1]);
		 * System.out.println("mat["+(m-1)+"]["+n+"]: "+mat[m - 1][n]);
		 * System.out.println("mat["+(m+1)+"]["+n+"]: "+mat[m + 1][n]);
		 */

		int distance = 1;
		if (((n - 1) >= 0 && mat[m][n - 1] == 0) || ((n + 1) < mat[m].length && mat[m][n + 1] == 0)
				|| ((m - 1) >= 0 && mat[m - 1][n] == 0) || ((m + 1) < mat.length && mat[m + 1][n] == 0)) {

			distances[m][n] = 1;
			return 1;
		} else {
			if (!b2[m][n]) {
				b2[m][n] = true;
				int l = 0, r = 0, u = 0, b = 0, d = 0;

				l = distanceTo0(mat, m, n - 1, distances, b2);
				if (l > -1) {
					d = l;
				}
				r = distanceTo0(mat, m, n + 1, distances, b2);
				if (r > -1) {
					d = Math.min(d, r);
				}
				u = distanceTo0(mat, m - 1, n, distances, b2);
				if (u > -1) {
					d = Math.min(d, u);
				}
				b = distanceTo0(mat, m + 1, n, distances, b2);
				if (b > -1) {
					d = Math.min(d, b);
				}

				distance += d;

				System.out.println("m:" + m + " n: " + n);
				System.out.println("l:" + l + " r: " + r + " u: " + u + " b: " + b);
			}

		}

		distances[m][n] = distance;
		return distance;
	}
}