package hackerrank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultSwapNodes {

	/*
	 * Complete the 'swapNodes' function below.
	 *
	 * The function is expected to return a 2D_INTEGER_ARRAY. The function accepts
	 * following parameters: 1. 2D_INTEGER_ARRAY indexes 2. INTEGER_ARRAY queries
	 */

	public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
		Node root = new Node(1);
		createChildNodes(root, indexes);

		List<List<Integer>> swaped = new ArrayList<List<Integer>>();
		
		queries.forEach(k -> {
			swapNodes(root, k);
			List<Integer> listInOrderTraversal = new ArrayList<Integer>();
			inOrderTraversal(root, listInOrderTraversal);
			swaped.add(listInOrderTraversal);
		});
		
		return swaped;
	}
	
	private static void inOrderTraversal(Node root, List<Integer> listInOrderTraversal) {
		visitNode(root.left, listInOrderTraversal);
		listInOrderTraversal.add(root.data);
		visitNode(root.right, listInOrderTraversal);
	}
	
	private static void visitNode(Node root, List<Integer> listInOrderTraversal) {
		if (root.left == null && root.right == null) {
			listInOrderTraversal.add(root.data);
		} else {
			if (root.left != null) {
				visitNode(root.left, listInOrderTraversal);
			} 
			
			listInOrderTraversal.add(root.data);
			
			if (root.right != null) {
				visitNode(root.right, listInOrderTraversal);
			} 
		}
	}
	
	private static void swapNodes(Node root, Integer k) {
		if (root != null) {
			if (k.equals(1)) {
				Node tempNode = root.left;
				root.left = root.right;
				root.right = tempNode;
				swapNodes(root.left, k*2);
				swapNodes(root.right, k*2);
			} else {
				swapNodes(root.left, k - 1);
				swapNodes(root.right, k - 1);
			}
		}
	}
	
	private static void createChildNodes(Node root, List<List<Integer>> indexes) {
		List<Integer> list = indexes.get(root.data - 1);
		if (list.get(0) > -1) {
			root.left = new Node(list.get(0));
			createChildNodes(root.left, indexes);
		}
		if (list.get(1) > -1) {
			root.right = new Node(list.get(1));
			createChildNodes(root.right, indexes);
		}
	}
}

public class SolutionSwapNodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = ResultSwapNodes.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
