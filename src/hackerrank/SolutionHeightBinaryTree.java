package hackerrank;

import java.util.Scanner;

//class Node {
//    Node left;
//    Node right;
//    int data;
//    
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}

class SolutionHeightBinaryTree {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
		if (!isLeaf(root)) {
			int hr = 0, hl = 0;
			if (isChild(root.left)) {
				hl = height(root.left);
			}
			if (isChild(root.right)) {
				hr = height(root.right);
			}
			
			if (hl > hr)
				return hl + 1;
			else
				return hr + 1;
		}
		
		return 0;
    }
	
	private static boolean isLeaf(Node n) {
        return n == null || (n.left == null && n.right == null);
    }
	
	private static boolean isChild(Node n) {
		return n != null;
	}

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}

