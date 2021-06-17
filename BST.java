// Java program to check if a given tree is BST.

public class BST {

    static int prev = Integer.MIN_VALUE;
    /* A binary tree node has data, pointer to
    left child and a pointer to right child */
    static class Node {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    };

    // Utility function to check if Binary Tree is BST
    public static boolean checkBST(Node root)
    {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null) {
            if (!checkBST(root.left))
                return false;

            // Allows only distinct valued nodes
            if (root.data <= prev)
                return false;

            // Initialize prev to current
            prev = root.data;

            return checkBST(root.right);
        }

        return true;
    }

    // Function to check if Binary Tree is BST
    public static boolean isBST(Node root)
    {
        return checkBST(root);
    }

    /* Driver code*/
    public static void main(String[] args){

        //entering a valid BST

        /*
                         15
                       /    \
                     10      19
                    /  \     /  \
                   8   11   17   21
                  / \   \   / \  /
                 6  9   14 16 18 20

         This is the tree passed as input


         */
        Node root = null;
        root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(19);
        root.left.left = new Node(8);
        root.left.right = new Node(11);
        root.left.left.left = new Node(6);
        root.left.left.right = new Node(9);
        root.left.right.right = new Node(14);
        root.right.left = new Node(17);
        root.right.right = new Node(21);
        root.right.left.left = new Node(16);
        root.right.left.right = new Node(18);
        root.right.right.left = new Node(20);


        if (isBST(root))
            System.out.println("Is a binary search tree");
        else
            System.out.println("Not a binary search tree");
    }
}


