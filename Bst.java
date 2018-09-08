package pack_age;

import java.io.*;

public class Bst {
	
	Bst ltree;//pointer to the left tree
	Bst rtree;//pointer to the right tree
	int data;
	Bst root;//pointer to the root node
	
	void insertNode(int d) throws IOException{
		//creating new node
		Bst newnode=new Bst();
		newnode.data=d;
		if(root==null) {
			//tree is empty
			root=newnode;
			System.out.println("\nNew Node Inserted As The Root Node");
		}
		else {
			Bst temproot=new Bst();
			temproot=root;
			while(true) {
				if(newnode.data<temproot.data) {
					if(temproot.ltree==null) {
						//inserting the new node
						temproot.ltree=newnode;
						System.out.println("\nNew Node Is Inserted");
						break;
					}
					else 
						temproot=temproot.ltree;
				}
				else if(newnode.data>temproot.data) {
					if(temproot.rtree==null) {
						//inserting the new node
						temproot.rtree=newnode;
						System.out.println("\nNew Node Is Inserted");
						break;
					}
					else 
						temproot=temproot.rtree;
				}
			}
		}
		
	}
	
	void preOrderTraversal(Bst node) {
		//root-left-right
		System.out.println("Node Data : "+node.data);
		if(node.ltree!=null)
			preOrderTraversal(node.ltree);
		if(node.rtree!=null)
			preOrderTraversal(node.rtree);
	}
	
	void inOrderTraversal(Bst node) {
		//left-root-right
		if(node.ltree!=null)
			inOrderTraversal(node.ltree);
		System.out.println("Node Data : "+node.data);
		if(node.rtree!=null)
			inOrderTraversal(node.rtree);
	}
	
	void postOrderTraversal(Bst node) {
		//left-right-root
		if(node.ltree!=null)
			postOrderTraversal(node.ltree);
		if(node.rtree!=null)
			postOrderTraversal(node.rtree);
		System.out.println("Node Data : "+node.data);
	}
	
	void deleteNode(int d) {
		Bst n1,n2;
		n1=root;
		n2=root;
		while(true) {//searching the node and its parent to be deleted
			if(n1.data==d) {
				System.out.println("\nNode Found,Root Node");
				break;
			}
			
			if(d<n1.data) 
				n2=n1.ltree;
				
			if(d>n1.data) 
				n2=n1.rtree;
			
			if(n2!=null) {
				if(n2.data!=d)
					n1=n2;
				else {
					System.out.println("\nNode Found");
					break;
				}
			}
			else {
				System.out.println("\nNode Not Found,Invalid Entry");
				break;
			}
					
		}
		//when the node is a leaf node,to be deleted
		if(n2.ltree==null && n2.rtree==null) {
			if(n1.ltree==n2)//if the leaf node is a left child of its parent
				n1.ltree=null;
			if(n1.rtree==n2)//if the leaf node is a right child of its parent
				n1.rtree=null;
			return;
		}
		
		//when the node to be deleted has only one children
		if(n2.ltree==null && n2.rtree!=null) {
			if(n1.ltree==n2) {
			//n2 is left child of n1 and n2 has right child
				n1.ltree=n2.rtree;
			}
			if(n1.rtree==n2) {
				//n2 is right child of n1 and n2 has right child
					n1.rtree=n2.rtree;
			}
			return;
		}
		if(n2.ltree!=null && n2.rtree==null) {
			//n2 is having a left child only
			if(n1.ltree==n2) {
			//n2 is left child of n1 and n2 has right child
				n1.ltree=n2.ltree;
			}
			if(n1.rtree==n2) {
				//n2 is right child of n1 and n2 has right child
				n1.rtree=n2.ltree;
			}	
			return;
		}
		
		//when the node to be removed has both the children
		Bst minode=n2.rtree;
		//finding the node with the min. value in the right tree of the node to be deleted
		while(minode.ltree!=null) {
			minode=minode.ltree;
		}
		//storing the value of the minimum value node in a temp varaible
		int temp=minode.data;
		
		//removing the node with the minimum value in the right tree
		deleteNode(minode.data);
		
		//replacing the value of the node to be deleted with the minimum value
		n2.data=temp;
		
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Bst obj=new Bst();
		char ch;
		do {
			//node insertion in the tree
			System.out.print("\nEnter Node Data : ");
			int d=Integer.parseInt(br.readLine());
			obj.insertNode(d);
			System.out.print("\nPress Y To Create Another Node and N To Stop  : ");
			ch=br.readLine().charAt(0);
		}while(ch=='Y'||ch=='y');
		
		System.out.println("\nPreorder Traversal Of The Tree");
		obj.preOrderTraversal(obj.root);
		
		System.out.println("\n\nInorder Traversal Of The Tree");
		obj.inOrderTraversal(obj.root);
		
		System.out.println("\n\nPostorder Traversal Of The Tree");
		obj.postOrderTraversal(obj.root);
		
		System.out.print("\nEnter Node Data To Delete : ");
		int d=Integer.parseInt(br.readLine());
		obj.deleteNode(d);
		
		System.out.println("\nAfter Deletion");
		
		System.out.println("\nPreorder Traversal Of The Tree");
		obj.preOrderTraversal(obj.root);
		
		System.out.println("\n\nInorder Traversal Of The Tree");
		obj.inOrderTraversal(obj.root);
		
		System.out.println("\n\nPostorder Traversal Of The Tree");
		obj.postOrderTraversal(obj.root);
	}

}
