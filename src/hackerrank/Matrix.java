package hackerrank;

public class Matrix {

	public static void main(String[] args) {
		//PrintUtils.printMatrix(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } }));
		//PrintUtils.printMatrix(updateMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }));
		PrintUtils.printMatrix(updateMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } }));
	}
	
	public static int[][] updateMatrix(int[][] mat) {
        int maxResult = mat.length + mat[0].length - 2;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) continue;
                else mat[i][j] = maxResult;
            }
        }
        PrintUtils.printMatrix(mat);
        for (int i = 0; i <  mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) continue;
                if (i > 0) mat[i][j] = Math.min(mat[i - 1][j] + 1, mat[i][j]);
                if (j > 0) mat[i][j] = Math.min(mat[i][j - 1] + 1, mat[i][j]); 
            }
        }
        PrintUtils.printMatrix(mat);
        for (int i = mat.length - 1; i >= 0; i--) {        	
            for (int j = mat[0].length - 1; j >= 0; j--) {
            	//System.out.println(i + " " + j);
                if (mat[i][j] == 0) continue;
                if (i < mat.length - 1) mat[i][j] = Math.min(mat[i + 1][j] + 1, mat[i][j]);
                if (j < mat[0].length - 1) mat[i][j] = Math.min(mat[i][j + 1] + 1, mat[i][j]);
            }
        }
        return mat;
    }

	public static int[][] updateMatrix2(int[][] mat) {
		int[][] distances = new int[mat.length][mat[0].length];
		boolean b = false;

		for (int m = 0; m < distances.length; m++) {
			for (int n = 0; n < distances[m].length; n++) {
				if (mat[m][n] == 0) { 
					distances[m][n] = 0;
				} else {
					distances[m][n] = -1;
					b = true;
				}
			}
		}
		
		int d = 0;
		while (b) {
			b = false;
			for (int m = 0; m < mat.length; m++) {
				for (int n = 0; n < mat[m].length; n++) {
					if (distances[m][n] == d) {
						fillNext(mat, distances, m, n, d+1);
					} else if (distances[m][n] == -1) {
						b = true;
					}
				}
			}
			d++;
		}
		
		return distances;
	}
	
		public static void fillNext(int[][] mat, int[][] distance, int m, int n, int d) {
			if (m==1 && n==2)
				System.out.println();
			
			if ((m-1) >= 0 && mat[m-1][n] == 1 && distance[m-1][n] == -1) { 
				distance[m-1][n] = d;
			}
			if ((m+1) < mat.length && mat[m+1][n] == 1 && distance[m+1][n] == -1) {
				distance[m+1][n] = d;
			}
			if ((n-1) >= 0 && mat[m][n-1] == 1 && distance[m][n-1] == -1) {
				distance[m][n-1] = d;
			}
			if ((n+1) < mat[m].length && mat[m][n+1] == 1 && distance[m][n+1] == -1) {
				distance[m][n+1] = d;
			}
	}
}