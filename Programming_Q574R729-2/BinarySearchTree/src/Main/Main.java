package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		BinSerTre tree = new BinSerTre();
		Scanner input = new Scanner(System.in);
		int value = 0;

		while (true) {
			Main.InputOptions();
			value = input.nextInt();

			switch (value) {
			case 1:
				System.out.println("Enter the new TreeNode to be inserted: ");
				int InputToInsert = input.nextInt();
				int TreeNodeLevel1 = 1, TreeNodeLevel = 0;
				TreeNode TreeNode = new TreeNode(InputToInsert);
				tree.insert(TreeNode);
				TreeNodeLevel1 = tree.Depth(tree.root, InputToInsert, 1);
				if (TreeNodeLevel1 != 0) {
					TreeNodeLevel = TreeNodeLevel1 - 1;
					System.out.println("The depth of the inserted TreeNode is  : " + TreeNodeLevel);
				}

				break;

			case 2:
				System.out.println("Enter the value to be searched : ");
				int searchItem, level = 1, searchLevel = 0;
				searchItem = input.nextInt();
				TreeNode s = tree.search(tree.root, searchItem);
				if (s == null) {
					System.out.println("The Given value is not available");
				} else {
					System.out.println("The Given value is available");
					level = tree.Depth(tree.root, searchItem, 1);
					if (level != 0) {
						searchLevel = level - 1;
						System.out.println("The depth of the given Value is  " + searchLevel);
					}
				}
				break;

			case 3:
				if (tree.root == null) {
					System.out.println("The tree is empty");
				} else {
					System.out.println("max value in the tree is : " + tree.max(tree.root).key);
					int maxkey = tree.max(tree.root).key;
					int maxKeyLevel, levelKeymax = 0;
					maxKeyLevel = tree.Depth(tree.root, maxkey, 1);
					if (maxKeyLevel != 0) {
						levelKeymax = maxKeyLevel - 1;
						System.out.println("The depth of the max value is : " + levelKeymax);
					}
				}
				break;
			case 4:
				if (tree.root == null) {
					System.out.println("The tree is empty");
				} else {
					System.out.println("Minimum value in the tree is: " + tree.min(tree.root).key);
					int minimumkey = tree.min(tree.root).key;
					int minimumKeyLevel, levelminimumkey = 0;
					minimumKeyLevel = tree.Depth(tree.root, minimumkey, 1);
					if (minimumKeyLevel != 0) {
						levelminimumkey = minimumKeyLevel - 1;
						System.out.println("The depth of the minimum value is : " + levelminimumkey);
					}
				}
				break;

			case 5:
				tree.traversal(); 
				break;

			case 6:
				System.out.println("Enter the value to find the predcessor of the same: ");
				TreeNode preTreeNode = tree.predecessor(tree.search(tree.root, input.nextInt()));
				System.out.println("The predecessor for given value is: " + preTreeNode.key);
				int predecessorKey = preTreeNode.key;
				int levelPredecessor, predecessorLevel = 0;
				levelPredecessor = tree.Depth(tree.root, predecessorKey, 1);
				if (levelPredecessor != 0) {
					predecessorLevel = levelPredecessor - 1;
					System.out.println("The depth of the predecessor TreeNode is : " + predecessorLevel);
				}
				break;

			case 7:
				System.out.println("Enter the value to find the successor of the same: ");
				TreeNode sucTreeNode = tree.successor(tree.search(tree.root, input.nextInt()));
				System.out.println("The successor for given value is: " + sucTreeNode.key);
				int successorKey = sucTreeNode.key;
				int levelSuccessor, successorLevel = 0;
				levelSuccessor = tree.Depth(tree.root, successorKey, 1);
				if (levelSuccessor != 0) {
					successorLevel = levelSuccessor - 1;
					System.out.println("The depth of the successor TreeNode is : " + successorLevel);
				}
				break;

			case 8:
				System.out.println("Enter the value to be deleted: ");
				int deletedItem = input.nextInt();
				int deleteLevelTreeNode = 1, levelDeleteTreeNode = 0;
				TreeNode delTreeNode = tree.search(tree.root, deletedItem);
				if (delTreeNode == null) {
					System.out.println("The TreeNode given to delete is not available in the tree");
				} else {
					deleteLevelTreeNode = tree.Depth(tree.root, deletedItem, 1);
					if (deleteLevelTreeNode != 0) {
						levelDeleteTreeNode = deleteLevelTreeNode - 1;
						System.out.println("The depth of deleted TreeNode is : " + levelDeleteTreeNode);
					}
					tree.delete(delTreeNode);
				}

				break;

			case 9:
				tree.root = null; 
				Main.InputOptions();
				break;

			default:
				break;
			}
			System.out.println("\n\n\n");

			if (value == 0) {
				System.out.println("Exiting the Input mode");
				break;
			} else if (!(value <= 9) && (value >= 0)) {
				System.out.println("Input options taken are from 0-9 please enter again");
			}
		}
		input.close();
		System.out.println("closing ");
	}

	public static void InputOptions() {
		System.out.println("1--> Insert a New TreeNode");
		System.out.println("2--> Search an Exsisting TreeNode");
		System.out.println("3--> Find Maximun TreeNode in the Tree");
		System.out.println("4--> Find Minimum TreeNode in the Tree");
		System.out.println("5--> Traversal of the tree(Pre,Post,In)");
		System.out.println("6--> Find Predecessor of a TreeNode ");
		System.out.println("7--> Find Successor of a TreeNode");
		System.out.println("8--> Delete a single TreeNode");
		System.out.println("9--> Delete all the TreeNodes");
		System.out.println("0--> To Exit");
	}
}
