package hackerrank;

public class PrintUtils {

	public static void printMatrix(int [][] mat) {
		System.out.println("-----");
		if (mat != null) {
			for (int m = 0; m < mat.length; m++) {
				for (int n = 0; n < mat[m].length; n++) {
					System.out.print(mat[m][n] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("null matrix");
		}
		System.out.println("-----\n");
	}
}
