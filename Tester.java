package Binary_Search_Tree_2;
import java.util.*;
public class Tester {

	public static void main(String[] args) {
		BST tree = new BST(50);
		tree.insert(25);
		tree.insert(19);
		tree.insert(3);
		tree.insert(45);
		tree.insert(75);
		tree.insert(49);
		tree.insert(150);
		tree.InOrder();
		BSTNode min = tree.findMin();
		System.out.printf("minimum value of the tree is %d \n", min.getValue());
		
		tree.setDrawMethod(new BasicTreeDraw(600, 900));
		tree.draw();
	 /*//Testing delete(int value):
		//deleting value at root:
		tree.delete(50);
		tree.InOrder();
		
		//deleting a leaf:
		tree.delete(150);
		tree.InOrder();
		//deleting a node with only one child
		tree.delete(45);
		tree.InOrder();
	*/
	}
	
	
}
