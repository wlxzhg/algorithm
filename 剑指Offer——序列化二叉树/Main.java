public class Main {
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);

		r1.left = r2;
		r1.right = r3;

		r2.left = r4;
		r3.left = r5;
		r3.right = r6;

		String str  = (new Main()).Serialize(r1);

		System.out.println(str);

		TreeNode root = (new Main()).Deserialize(str);
		System.out.println((new Main()).Serialize(root));



	}

	String Serialize(TreeNode root) {
		if(root == null)
			return "";
    	StringBuilder sb = new StringBuilder();

    	Serialize(root,sb);

    	return sb.toString().substring(1);    
  	}

  	void Serialize(TreeNode root,StringBuilder sb) {
  		if(root == null) {
  			sb.append(",$");
  			return;
  		}
  		sb.append(",");
  		sb.append(root.val);
  		Serialize(root.left,sb);
		Serialize(root.right,sb);
  	}
    
    TreeNode Deserialize(String str) {
    	if(str == null || str.equals(""))
    		return null;
    	String[] arr = str.split(",");
       	return Deserialize(arr,new int[] {0});
  	}

  	TreeNode Deserialize(String[] arr,int[] flag) {
  		int index = flag[0];
  		if(arr[index].equals("$")) {
  			flag[0]++;
  			return null;
  		}

  		TreeNode root = new TreeNode(Integer.valueOf(arr[index]));
  		flag[0]++;

  		root.left = Deserialize(arr,flag);

  		root.right = Deserialize(arr,flag);

  		return root;
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