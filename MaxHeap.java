package pack_age;

import java.io.*;

public class MaxHeap {
	int data;
	MaxHeap ltree;
	MaxHeap rtree;
	MaxHeap lsib;//left sibling
	MaxHeap rsib;//right sibling
	MaxHeap node;//temporary pointer to the current node
	MaxHeap root;
	
	void swap(MaxHeap newnode) {
		int temp;
		if(newnode.data>node.data) {
			temp=newnode.data;
			newnode.data=node.data;
			node.data=temp;
		}
	}
	
	void insertNode(MaxHeap newnode) {
		if(root==null) {//when the tree is empty,newnode becomes the root node
			root=newnode;
			node=root;
			System.out.println("\nNewnode Inserted As The Root Node");
			return;
		}
		if(node.ltree==null) {//inserting the new node as the lest child 
			node.ltree=newnode;
			System.out.println("\nNewnode Inserted");
			swap(newnode);//if the newnode data is greater than the parent
			if(node.lsib!=null) {//if the parent node has a left sibling
				//establishing the relationship between the child of diff. parents
				newnode.lsib=node.lsib.rtree;
				node.lsib.rtree.rsib=newnode;
			}
		}
		else if(node.rtree==null) {
			//inserting the newnode
			node.rtree=newnode;
			System.out.println("\nNewnode Inserted");
			swap(newnode);
			//establishing the relationships between the siblings
			newnode.lsib=node.ltree;
			node.ltree.rsib=newnode;
		}
		if(node.rsib!=null && node.ltree!=null && node.rtree!=null)
			node=node.rsib;//shifting to the right sibling
		
		if(node.rsib==null && node.ltree!=null && node.rtree!=null)//we are at the rightmost sibling
		{
			while(node.lsib!=null)
				node=node.lsib;//traversing back to the lestmost sibling
			node=node.ltree;//moving one level below
		}
	}
	
	void preOrder(MaxHeap nnode) {
		System.out.println("Node Data : "+nnode.data);
		if(nnode.ltree!=null)
			preOrder(nnode.ltree);
		if(nnode.rtree!=null)
			preOrder(nnode.rtree);	
	}
	void inOrder(MaxHeap nnode) {
		if(nnode.ltree!=null)
			inOrder(nnode.ltree);
		System.out.println("Node Data : "+nnode.data);
		if(nnode.rtree!=null)
			inOrder(nnode.rtree);	
	}
	void postOrder(MaxHeap nnode) {
		if(nnode.ltree!=null)
			postOrder(nnode.ltree);
		if(nnode.rtree!=null)
			postOrder(nnode.rtree);
		System.out.println("Node Data : "+nnode.data);
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		MaxHeap obj=new MaxHeap();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char ch;
		
		//creating new node 
		do {
			MaxHeap newnode=new MaxHeap();
			System.out.print("\nEnter Data : ");
			newnode.data=Integer.parseInt(br.readLine());
			obj.insertNode(newnode);
			System.out.print("\nPress Y to enter another node else N to Quit : ");
			ch=br.readLine().charAt(0);
		}while(ch=='y' || ch=='Y');
		System.out.println("\nPreorder Traversal");
		obj.preOrder(obj.root);
		System.out.println("\nInorder Traversal");
		obj.inOrder(obj.root);
		System.out.println("\nPostorder Traversal");
		obj.postOrder(obj.root);

	}

}
