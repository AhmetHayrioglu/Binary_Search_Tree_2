package Binary_Search_Tree_2;

public interface TreeNode {
	public int getValue();
	public void setValue(int value);
	
	public BSTNode getRight();
	public void setRight(BSTNode right);
	
	public BSTNode getLeft();
	public void setLeft(BSTNode left);
	
	public ChildStatus getChildStatus();
}
