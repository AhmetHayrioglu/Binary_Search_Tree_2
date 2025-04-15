package Binary_Search_Tree_2;

public class BST {
	private BSTNode root;
	
	public BST(BSTNode root) {
		this.root = root;
	}
	public BST(int value) {
		this.root = new BSTNode(value);
	}
	public BST() {
		this.root = null;
	}
	
	public void insert(int value){
		BSTNode newNode = new BSTNode(value);
		insert(newNode);
	}
	
	private void insert(BSTNode newNode)
	{
		if(this.root == null) //special case insertion at the root (first insert in an empty tree)
		{
			this.root = newNode;
			return;		//exit method, insertion is completed
		}
		
		int newVal = newNode.getValue();
		BSTNode currentNode = this.root;
		BSTNode parentNode = this.root;
		int currentVal;
		
		//in the loop : tree traversal until we reach the correct node for insertion of the new value
		//After the loop terminates normally we expect parentNode to be the node at which we will insert newNode as a new child
		while(currentNode != null)
		{
			currentVal = currentNode.getValue();
			
			if(newVal > currentVal)
			{
				//we go to the right subtree keeping track of the parent node
				parentNode = currentNode;
				currentNode = currentNode.getRight();
			}
			
			else if(newVal < currentVal) 	
			{
				// we go to the left subtree keeping reference of the parent node
				parentNode = currentNode;
				currentNode = currentNode.getLeft();
			}
			
			else
			{
				System.out.printf("Value %d already exists ", currentVal);
				return; // exit method early
			}
		}
		
		currentVal = parentNode.getValue();
		
		//insertion process:
			if(newVal > currentVal)
			{
				parentNode.setRight(newNode);
			}
			else if(newVal < currentVal)
			{
				parentNode.setLeft(newNode);
			}
		
	}

//InOrder traversal in binary search trees prints out the values in order , this is useful to test the insert() method
	private void InOrder(BSTNode node)
	{
		if(node == null)
			return;
		
		ChildStatus nodeStatus = node.getChildStatus();
		if(nodeStatus == ChildStatus.LEAF)
		{
			//Base case: if a node is a leaf(has no children) print its content
			System.out.printf(", %d", node.getValue());
			return;
		}
		
		//Recursive case: print left subtree , print current node value , print right subtree
		InOrder(node.getLeft());
		System.out.printf(", %d", node.getValue());
		InOrder(node.getRight());
		return;
	}
	
	public void InOrder(){
		InOrder(this.root);
	}
	
	
	public BSTNode delete(int value){
		return delete(this.root, this.root, value);
	}
	
	private BSTNode delete(BSTNode current, BSTNode parent, int value) {
		
		
		
		return null;
	}
}
