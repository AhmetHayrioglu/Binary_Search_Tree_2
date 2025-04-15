package Binary_Search_Tree_2;

public enum ChildStatus {
	LEAF, 			//if the node has no children
	ONLY_RIGHT,		//if the node has only a right child
	ONLY_LEFT,		//if the node has only a left child
	BOTH			//if the node has both a right and a left child
}
