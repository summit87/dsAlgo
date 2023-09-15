package tree;

public class InOrderSuccessor {
	
	public static void main(String[] args) {
		TreeNode tn = new TreeNode();
		TreeNode key = new TreeNode(11);
		tn = tn.createBST();
		TreeNode succ = null;
		succ = inOrderSuccessor(tn, succ, key);
		if (succ != null) {
			System.out.println(succ.getData());
		}
	}
	
	private static TreeNode inOrderSuccessor(TreeNode tn, TreeNode succ, TreeNode key) {
		
		if (tn != null && tn.getRight() != null && tn.getData() == key.getData()) {
			TreeNode temp = tn.getRight();
			while (temp != null && temp.getLeft() != null) {
				temp = temp.getLeft();
			}
			succ = temp;
		} else if (tn != null && tn.getData() > key.getData()) {
			succ = tn;
			return inOrderSuccessor(tn.getLeft(), succ, key);
		} else if (tn != null && tn.getData() < key.getData()) {
			return inOrderSuccessor(tn.getRight(), succ, key);
		}
		return succ;
	}
	
}
