public class Main {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(14);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(8);
		TreeNode t6 = new TreeNode(12);
		TreeNode t7 = new TreeNode(16);
		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.left = t6;
		t3.right = t7;

		TreeNode head = (new Main()).Convert(t1);
		for(TreeNode p = head; p != null; p = p.right)
			System.out.print(p.val + "\t");
	}

	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode lastOfList = Convert(pRootOfTree,null);

		TreeNode p = lastOfList;
		while (p != null && p.left != null) {
			p = p.left;
		}

		return p;
	}

	public TreeNode Convert(TreeNode pRootOfTree,TreeNode lastOfList) {
		if(pRootOfTree == null)
			return null;

		if(pRootOfTree.left != null)
			lastOfList = Convert(pRootOfTree.left,lastOfList);

		if(lastOfList != null)
			lastOfList.right = pRootOfTree;
		pRootOfTree.left = lastOfList;

		lastOfList = pRootOfTree;
		if(pRootOfTree.right != null)
			lastOfList = Convert(pRootOfTree.right,lastOfList);

		return lastOfList;
	}
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
