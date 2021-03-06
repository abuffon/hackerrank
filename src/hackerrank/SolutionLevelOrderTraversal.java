package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class SolutionLevelOrderTraversal {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
		if (root != null) {
			List<Node> list = new ArrayList<Node>();
			list.add(root);
			
			while (!list.isEmpty()) {
				Node n = list.remove(0);
				
				if (n.left != null)
					list.add(n.left);
				
				if (n.right != null)
					list.add(n.right);
				
				System.out.print(n.data + " ");
			}
		}
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
        levelOrder(root);
    }	
}