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
	}

}
