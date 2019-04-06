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

        ArrayList<ArrayList<Integer>> ans = (new Main()).FindPath(r1,22);

        System.out.println(ans.size());
        for(ArrayList<Integer> a : ans) {
            System.out.println(a);
        }
	}

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();

        if(root == null)
            return answers;

        ArrayList<Integer> ans = new ArrayList<Integer>();
        FindPath(root,target,ans,answers);

        return answers;
    }

    public void FindPath(TreeNode root,int target,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> answers) {
        ans.add(root.val);

        if(root.left == null && root.right == null) {
            if(target == root.val) {
                answers.add(new ArrayList<Integer>(ans));
            }
        }

        if(root.left != null) {
            FindPath(root.left,target - root.val,ans,answers);
        }

        if(root.right != null) {
            FindPath(root.right,target - root.val,ans,answers);
        }

        ans.remove(ans.size() - 1);
    }
}