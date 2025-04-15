package Binary_Search_Tree_2;

public class BSTNode implements TreeNode {
//Attributes:
		private int value;
		private BSTNode right;
		private BSTNode left;
		
//Constructors:
		public BSTNode(int value, BSTNode right,BSTNode left){
			this.value = value;
			this.right = right;
			this.left = left;
		}
	
		public BSTNode(int value) {
			this.value = value;
			this.right = null;
			this.left = null;
		}

//Methods: 
		@Override
		public int getValue() {
			return this.value;
		}

		@Override
		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public BSTNode getRight() {
			return this.right;
		}

		@Override
		public void setRight(BSTNode right) {
			this.right = right;
		}

		@Override
		public BSTNode getLeft() {
			return this.left;
		}

		@Override
		public void setLeft(BSTNode left) {
			this.left = left;
		}

		@Override
		public ChildStatus getChildStatus(){
			
			if(this.right == null && this.left == null)
			{
				return ChildStatus.LEAF;
			}
			else if(this.right != null && this.left == null) 
			{
				return ChildStatus.ONLY_RIGHT;
			}
			else if(this.right == null && this.left != null) 
			{
				return ChildStatus.ONLY_LEFT;
			}
			else {
				return ChildStatus.BOTH;
			}
		}
		
		
		
}
