package Binary_Search_Tree_2;
import java.awt.Graphics;
import java.io.*;
import javax.swing.*;

class BasicTreeDraw extends JPanel implements TreeDrawer{
	private TreeNode root;
	private JFrame frame;
	private int fHeight;
	private int fWidth;
	private int Diameter;
	
	public BasicTreeDraw(int fHeight,int fWidth)
	{
		this.fHeight = fHeight;
		this.fWidth = fWidth;
		this.Diameter = fHeight/15;
		frame = new JFrame("Binary Search Tree Visiualization");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(this.fWidth, this.fHeight);
		frame.add(this); // this JPanel
		frame.setVisible(true);
	}
	
	@Override
	public void draw(TreeNode node) {
		// TODO Auto-generated method stub
		this.root = node;
		this.repaint();
	}
	
	private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffSet)
	{
		if(node == null)
			return;

		//draw current node value: 
		drawNode(g, node.getValue(), x , y);
		
		
		if(xOffSet > 0) 
		{ //offset is positive:
			//draw line back to parent:
			g.drawLine(x , y - Diameter/2, x - (2*xOffSet) + (Diameter/2) , y - Diameter);
			drawTree(g, node.getLeft(), x - xOffSet, y + Diameter, -(xOffSet/2));
			drawTree(g, node.getRight(), x + xOffSet, y + Diameter, xOffSet/2);
		}
		else //offset is negative 
		{
			//draw line back to parent
			g.drawLine(x , y - Diameter/2, x - (2*xOffSet) - (Diameter/2) , y - Diameter);
			drawTree(g, node.getLeft(), x + xOffSet, y + Diameter, xOffSet/2);
			drawTree(g, node.getRight(), x - xOffSet, y + Diameter, -xOffSet/2);
		}
	}
	
	private void drawNode(Graphics g, int value, int x, int y)
	{
		//this function draws a circle at x,y with value in the middle
		g.drawOval(x - Diameter/2 , y - Diameter/2 , Diameter, Diameter);
		g.drawString("" + value, x , y);
	
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(this.root != null)
		{
			drawTree(g, this.root, fWidth/2, Diameter/2, fWidth/4);
		}
	}
	
	

}
