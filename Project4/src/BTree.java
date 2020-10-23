import java.util.Scanner;

//The minimum requirement of this class is to implement a binary tree. You
//can put all the code for binary tree implementation in this file, or you can have additional
//classes to support this class for binary tree implementation.

class BTree {
	
	class TreeNode {
		char contents;   // either an arithmetic operator or a..z
        TreeNode left;       // left child
        TreeNode right;      // right child
        
        //Constructor for TreeNode
        public TreeNode(char contents) {
        	this.contents = contents;
        	this.left = null;
        	this.right = null;
        }
    }
	
	class StackNode{
		TreeNode treeNode;
		StackNode next;
		
		//Constructor for StackNode
		public StackNode(TreeNode treeNode) {
			this.treeNode = treeNode;
			next = null;
		}
	}
	
	private static StackNode top;
	
	//Constructor for BTree
	public BTree() {
		top = null;
	}
	
	//Function to Clear Tree
	public void clear() {
		top = null;
	}
	
	//Function to push a node
	private void push(TreeNode ptree) {
		if(top == null) {
			top = new StackNode(ptree);
		}
		else {
			StackNode nptree = new StackNode(ptree);
			nptree.next = top;
			top = nptree;
		}
	}
	
	//Function to pop a node
	private TreeNode pop() {
		if(top == null) {
			throw new RuntimeException("Underflow");
		}
		else {
			TreeNode ptree = top.treeNode;
			top = top.next;
			return ptree;
		}
	}
	
	//Function to get top node
	private TreeNode peek() {
		return top.treeNode;
	}

	//Function to insert into Tree (PRE)
	private void insertPre(char val) {
		try {
			//if its an operand
			if(!isOperator(val)) {
				TreeNode nptree = new TreeNode(val);
				push(nptree);
			}
			//if its an operator
			else if (isOperator(val)) {
				TreeNode nptree = new TreeNode(val);
				nptree.left = pop();
				nptree.right = pop();
				push(nptree);
			}
		}
		catch (Exception e) {
			System.out.println("Invalid Expression");
		}
	}
	//Function to insert into Tree (POST)
	private void insertPost(char val) {
		try {
			//if its an operand
			if(!isOperator(val)) {
				TreeNode nptree = new TreeNode(val);
				push(nptree);
			}
			//if its an operator
			else if (isOperator(val)) {
				TreeNode nptree = new TreeNode(val);
				nptree.right = pop();
				nptree.left = pop();
				push(nptree);
			}
		}
		catch (Exception e) {
			System.out.println("Invalid Expression");
		}
	}
	
	
    /** function to check if operator **/
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
	
	//Function to build tree for PreFix form from input
	public void buildTreePre(String eqn) {
		for(int i = eqn.length()- 1; i>= 0; i--) {
			insertPre(eqn.charAt(i));
		}
	}
	//Function to build tree for PostFix form from input
	public void buildTreePost(String eqn) {
		for(int i = 0; i <= eqn.length() - 1; i++) {
			insertPost(eqn.charAt(i));
		}
	}

	//Function to get postfix Expression
	public void postfix() {
		postOrder(peek());
	}
	
	//PostOrder Traversal
	private void postOrder(TreeNode ptree) {
		if(ptree != null) {
			postOrder(ptree.left);
			postOrder(ptree.right);
			System.out.print(ptree.contents);
		}
	}
	
	//Function to get infix expression
	public void infix() {
		inOrder(peek());
	}
	
	//InOrder Traversal
	private void inOrder(TreeNode ptree) {
		if(ptree != null) {
			inOrder(ptree.left);
			System.out.print(ptree.contents);
			inOrder(ptree.right);
		}
	}
	
    /** function to get prefix expression */
    public void prefix()
    {
        preOrder(peek());
    }
 
    /** pre order traversal */
    private void preOrder(TreeNode ptree)
    {
        if (ptree != null)
        {
            System.out.print(ptree.contents);
            preOrder(ptree.left);
            preOrder(ptree.right);            
        }    
    }

}




