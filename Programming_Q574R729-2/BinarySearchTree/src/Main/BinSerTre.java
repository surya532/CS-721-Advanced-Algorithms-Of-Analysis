package Main;

import Main.TreeNode;

public class BinSerTre {
	public TreeNode root;

	public void insert(TreeNode z) {
		TreeNode x = root;
		TreeNode y = null;

		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
			
		}
		z.parent = y;
		if (y == null)
			root = z;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
	}

	public void change(TreeNode u, TreeNode v) {
		if (u.parent == null)
			root = v;
		else if (u == u.parent.left)
			u.parent.left = v;
		else
			u.parent.right = v;
		if (v != null)
			v.parent = u.parent;
	}

	public void delete(TreeNode x) {
		if (x.left == null)
			change(x, x.right);
		else if (x.right == null)
			change(x, x.left);
		else {
			TreeNode y;
			y = min(x.right);
			if (y.parent != x) {
				change(y, y.right);
				y.right = x.right;
				y.right.parent = y;
			}
			change(x, y);
			y.left = x.left;
			y.left.parent = y;
		}
	}

	public TreeNode search(TreeNode x, int k) {
		while (x != null && k != x.key)

			if (k < x.key)
				x = x.left;
			else if (k > x.key)
				x = x.right;
			else
				x = null;
		return x;

	}

	public TreeNode min(TreeNode x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;

	}

	public TreeNode max(TreeNode x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;

	}

	public TreeNode successor(TreeNode x) {
		// function defining the successor of a TreeNode
		if (x.right != null)
			return min(x.right);
		else {
			TreeNode y = x.parent;
			while (y != null && x == y.right) {
				x = y;
				y = y.parent;
			}
			return y;
		}

	}

	public TreeNode predecessor(TreeNode x) {
		// function defining the predecessor of a TreeNode
		if (x.left != null)
			return max(x.left);
		else {
			TreeNode y = x.parent;
			while (y != null && x == y.left) {
				x = y;
				y = y.parent;
			}
			return y;
		}
	}

	
	void Preorder(TreeNode TreeNode) {
		//Function definition to get the Pre-order traversal
		if (TreeNode == null)
			return;
		System.out.print(TreeNode.key + " ");
		Preorder(TreeNode.left);
		Preorder(TreeNode.right);
	}
	void Postorder(TreeNode TreeNode) {
		//Function definition to get the post-order traversal
		if (TreeNode == null)
			return;
		Postorder(TreeNode.left);
		Postorder(TreeNode.right);
		System.out.print(TreeNode.key + " ");
	}


	void Inorder(TreeNode TreeNode) {
		//Function definition to get the in-order traversal
		if (TreeNode == null)
			return;
		Inorder(TreeNode.left);
		System.out.print(TreeNode.key + " ");
		Inorder(TreeNode.right);
	}

	public void traversal() {
		// function definition to print pre-order,in-order and post-order
		System.out.println("\nPre Order:");
		Preorder(root);
		System.out.println("\nPost Order:");
		Postorder(root);
		System.out.println("\nIn Order:");
		Inorder(root);

	}

	int Depth(TreeNode TreeNode, int data, int level) {
		// function definition to get the depth of a TreeNode
		int LevelVal = 0;
	
		if (TreeNode == null) {	return 0;}
		if (TreeNode.key == data) {	return level;}
		else {
			LevelVal = Depth(TreeNode.left, data, level + 1);
			if (LevelVal != 0) {
					return LevelVal;
			} else {
					LevelVal = Depth(TreeNode.right, data, level + 1);
				if (LevelVal != 0) {
					return LevelVal;
				}
			}
			return 0;
		}
	}

    }
		
