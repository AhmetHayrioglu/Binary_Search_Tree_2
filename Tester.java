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
	}
	
	
}
