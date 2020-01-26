import java.util.Stack;

public class HeightOfTree{
    static int sum = 0;
    Node root;
    HeightOfTree(){
        root = null;
    }
    HeightOfTree(int value){
        root = new Node(value);
    }
    public static void main(String[] args) {
        HeightOfTree tree = new HeightOfTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int _out = findHeightAndSumOfHeightOfIndividualNodes(tree.root);

        System.out.println("Height of Tree is - " + _out + " Sum of Tree is " + sum);

        System.out.println("Inorder Traversal - ");
        inOrderTraversal(tree.root);

        System.out.println("PreOrder Traversal - ");
        preOrderTraversal(tree.root);

        System.out.println("Trying Mirror of Tree - ");
        inOrderTraversal(mirrorOfTree(tree.root));
    }

    static int findHeightAndSumOfHeightOfIndividualNodes(Node root){
        if(root == null)
            return 0;
        int left = finfHeightAndSumOfHeightOfIndividualNodes(root.left);
        int right = finfHeightAndSumOfHeightOfIndividualNodes(root.right);
        if(left>right){
            sum += left+1;
            return left+1;
        }else{
            sum += right+1;
            return right+1;
        }
    }
    /**
     * Iterative Approach for Inorder
     * @param root
     */
    static void inOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        if(null == root)
            return;
        //System.out.println(root.right.value)

        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            root = stack.pop();
            System.out.print(root.value + " ");
            root = root.right;
        }
        
        System.out.println("");
    }

    static void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.value + " ");
        inOrder(root.right);
    }
    /**
     * PreOrderTraversal -- 
     * @param root
     */
    static void preOrderTraversal(Node root){
        if(null == root)
            return;
        Stack<Node> stack = new Stack<>();
        while(true){
            while(root != null){
                System.out.print(root.value + " ");
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            root = stack.pop();
            root = root.right;
        }
        
        System.out.println("");
    }

    static Node mirrorOfTree(Node root){
        if(null == root)
            return root;
        Node left = mirrorOfTree(root.left);
        Node right = mirrorOfTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}