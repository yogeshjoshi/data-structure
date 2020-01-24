public class DPP8{
    TreeNode root;
    static int count = 0;
    DPP8(){
        root = null;
    }
    DPP8(int value){
        root = new TreeNode(value);
    }
    public static void main(String[] args) {
        DPP8 dpp8 = new DPP8();
        dpp8.root = new TreeNode(1);
        dpp8.root.left = new TreeNode(2);
        dpp8.root.right = new TreeNode(2);
        dpp8.root.left.left = new TreeNode(2);
        dpp8.root.left.right = new TreeNode(3);
        dpp8.root.right.left = new TreeNode(2);
        dpp8.root.right.right = new TreeNode(2);


        int _out = countUnival(dpp8.root,dpp8.root.value);

        System.out.println("O(n2) Solution -> " + _out);

        countUnivalInOofN(dpp8.root);

        System.out.println("O(n) Solution -> " + count);
    }

    static int countUnival(TreeNode root, int value){
        if(root==null){
            return 0;
        }
        if(isUnival(root, root.value)){
            return 1 + countUnival(root.left, value) + countUnival(root.right, value);
        }else{
            return countUnival(root.left, value) + countUnival(root.right, value);
        }
    }

    static boolean isUnival(TreeNode root, int value){
        if(root == null){
            return true;
        }
        if(root.value == value){
            return isUnival(root.left, value) && isUnival(root.right, value);
        }
        return false;
    }


    /**
     * O(N) Approach 
     */
    static boolean countUnivalInOofN(TreeNode root){
        if(root == null)
            return true;
        
        boolean left = countUnivalInOofN(root.left);
        boolean right = countUnivalInOofN(root.right);

        if(!left || !right)
            return false;
        if(root.left != null && root.value != root.left.value)
            return false;
        if(root.right != null && root.value != root.right.value)
            return false;
        count++;
        return true;
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    TreeNode(TreeNode left,TreeNode right,int value){
        this.left = left;
        this.right = right;
        this.value = value;
    }
}