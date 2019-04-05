import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(10);
		TreeNode r2 = new TreeNode(5);
		TreeNode r3 = new TreeNode(12);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(7);

		r1.left = r2; r1.right = r3;
		r2.left = r4; r2.right = r5;

	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

    	if(root == null)
    		return answer;
    	ArrayList<Integer> oneAnswer = new ArrayList<Integer>();

    	FindPath(root,target,oneAnswer,answer);    
    }

    public void FindPath(TreeNode root,int target,ArrayList<Integer> oneAnswer,ArrayList<ArrayList<Integer>> answer) {
    	oneAnswer.add(root.val);

    	if(root.left == null && root.right == null) {
    		if(target == root.val) {
    			answer.add(new ArrayList(oneAnswer));
    		}
    	} else if(root.left != null) {
    		FindPath(root.left,target - root.val,oneAnswer,answer);
    	} else if(root.right != null) {
    		FindPath(root.right,target - root.val,oneAnswer,answer);
    	}

    	oneAnswer.remove(oneAnswer.size() - 1);
    }
}