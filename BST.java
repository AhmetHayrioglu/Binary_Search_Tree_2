package Binary_Search_Tree_2;

public class BST {
	private BSTNode root;
	private TreeDrawer TD;
	public BST(BSTNode root) {
		this.root = root;
	}
	
	public BST(int value) {
		this.root = new BSTNode(value);
	}
	
	public BST() {
		this.root = null;
	}
	
	public BSTNode getRoot()
	{
		return this.root;
	}
	
	public void setRoot(int value)
	{
		if(this.root == null)
		{
			this.root = new BSTNode(value);
		}
		else
		{
			this.root.setValue(value);
		}
		
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
		System.out.println();
	}
	
	
	public BSTNode findMin(){
		return findMin(this.root);
	}
	
	private BSTNode findMin(BSTNode node) {
	    if (node == null) return null;

	    while (node.getLeft() != null) {
	        node = node.getLeft();
	    }

	    return node;
	}

	
	
	
	public BSTNode delete(int value)
	{
		if(this.root.getValue() == value) {
			return deleteRoot(this.root);
		}
		
		return delete(this.root, this.root, value);
	}
	
	private BSTNode deleteRoot(BSTNode root)
	{ //handles the special case of root deletion
		switch(root.getChildStatus())
		{
		case BOTH:
			int sValue = successorReplace(root);
			delete(root.getRight(), root, sValue);
			return this.root;
		case LEAF:
			this.root = null;
			return this.root;
			
		case ONLY_LEFT:
			this.root = root.getLeft();
			return this.root;
			
		case ONLY_RIGHT:
			this.root = root.getRight();
			return this.root;
		default:
			return null;
		}
	}
	

	private BSTNode delete(BSTNode currentNode , BSTNode parentNode, int value) {
		
		if(currentNode == null) //base case 1:value to be deleted does not exist
			return null;
		
		int currentValue = currentNode.getValue();
		int parentValue = parentNode.getValue();
		
		if(currentValue == value)//base case 2: node containing value to be deleted is found
		{
			switch(currentNode.getChildStatus())
			{
			case BOTH:
				int sValue = successorReplace(currentNode);
				return delete(currentNode.getRight(), currentNode, sValue);
				
				
			case LEAF:
				if(currentValue >= parentValue)
				{
					parentNode.setRight(null);
				}
				else if(currentValue < parentValue)
				{
					parentNode.setLeft(null);
				}
				return this.root;
	
			case ONLY_LEFT:
				if(currentValue >= parentValue)
				{
					parentNode.setRight(currentNode.getLeft());
			    }
				else if(currentValue < parentValue)
				{
					parentNode.setLeft(currentNode.getLeft());
				}
				return this.root;
				
			case ONLY_RIGHT:
				if(currentValue >= parentValue)
				{
					parentNode.setRight(currentNode.getRight());
			    }
				else if(currentValue < parentValue)
				{
					parentNode.setLeft(currentNode.getRight());
				}
				return this.root;
				
			default:
				return null;
			}
		}
		
		//recursive case goal is to traverse the tree to find node to be deleted
		if(value >= currentValue) {
			return delete(currentNode.getRight(), currentNode, value);
		}
		else if(value < currentValue)
		{
			return delete(currentNode.getLeft(), currentNode, value);
		}
		
		return null;
	}

	
	private int successorReplace(BSTNode node)
	{
		BSTNode successor = findMin(node.getRight()); //reminder: findMin() returns the parent of the minimum
		node.setValue(successor.getValue());
		return successor.getValue();
	}

	
	public static int getDepth(TreeNode node)
	{
		if(node == null) return 0;
		
		return 1 + Math.max(getDepth(node.getLeft()), getDepth(node.getRight()));
	}
	
	public int getDepth(){
		return getDepth(this.root);
	}
	public TreeDrawer getDrawMethod() {
		return TD;
	}
	

	public void setDrawMethod(TreeDrawer tD) {
		TD = tD;
	}
	
	public void draw()
	{
		if(this.TD == null)
		{
			System.out.println("TreeDraw method not initilized! set a draw method first. ");
			return;
		}
		this.TD.draw(this.root);
	}
}
