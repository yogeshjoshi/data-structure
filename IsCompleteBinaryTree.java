import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree{
    Node node;
    IsCompleteBinaryTree(){
        this.node = null;
    }

    IsCompleteBinaryTree(int data){
        node = new Node(data);
    }
    public static void main(String[] args) {
        IsCompleteBinaryTree isCBT = new IsCompleteBinaryTree();
        isCBT.node = new Node(1);
        isCBT.node.left = new Node(2);
        isCBT.node.right = new Node(3);
        isCBT.node.left.left = new Node(4);
        isCBT.node.left.right = new Node(5);

        isCBT.node.left.left.left = new Node(6);


        boolean _out = isCBT(isCBT.node);

        System.out.println(_out);
    }

    /**
     * If we get any non full node than .... after onwards there should be only non full node
     * if left child is empty or null than right child should also be
     * @param root
     * @return
     */
    static boolean isCBT(Node root){
        if(root == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            Node temp_node = queue.remove();
            if(temp_node.left != null ){
                if(flag)
                    return false;
                queue.add(temp_node.left);
            }else{
                flag = true;
            }

            if(temp_node.right != null){
                if(flag)
                    return false;
                    queue.add(temp_node.right);
            }else{
                flag = true;
            }
        }
        return true;
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}