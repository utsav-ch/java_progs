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
	MaxHeap parent;
	
	void swap(MaxHeap newnode) {
		int temp;
		while(newnode!=root) {
			if(newnode.data>newnode.parent.data) {
				temp=newnode.data;
				newnode.data=newnode.parent.data;
				newnode.parent.data=temp;
				newnode=newnode.parent;
			}
			else
				break;
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
			newnode.parent=node;
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
			newnode.parent=node;
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
	
	void deleteNode(int d) {
		if(d==root.data) {
			System.out.println("\nNode Found,Root Node");
			MaxHeap nnode=root;
			//traversing to the left most node of the last level
			while(nnode.ltree!=null)
				nnode=nnode.ltree;
			
			//traversing to the right most node at the last level
			while(nnode.rsib!=null)
				nnode=nnode.rsib;
			
			//copying the data of the last node to the root
			root.data=nnode.data;
			
			//System.out.println("\ndata :"+root.data);
			
			//removing the last node
			if(nnode.parent.ltree==nnode)//if the last node is the left child
				nnode.parent.ltree=null;
			if(nnode.parent.rtree==nnode)//if the last node is the right child
				nnode.parent.rtree=null;

			//moving the new root node to its right place
			nnode=root;
			//System.out.println("\ndata :"+nnode.data);
			int temp;
			while(true) {
				if(nnode.ltree!=null && nnode.rtree!=null) {
					if(nnode.data>=nnode.ltree.data && nnode.data>=nnode.rtree.data) {
						System.out.println("\nMax Heap Is Balanced");
						break;
					}
					if(nnode.ltree.data>nnode.data && nnode.ltree.data>nnode.rtree.data) {
						//left node is the largest,swapping the left child with the parent
						temp=nnode.data;
						nnode.data=nnode.ltree.data;
						nnode.ltree.data=temp;
						nnode=nnode.ltree;
						
						System.out.println("\nltree "+nnode.data+"  "+nnode.parent.data);
					}
					if(nnode.rtree.data>nnode.data && nnode.rtree.data>nnode.ltree.data) {
						//right node is the largest,swapping the right child with the parent
						temp=nnode.data;
						nnode.data=nnode.rtree.data;
						nnode.rtree.data=temp;
						nnode=nnode.rtree;
						
						System.out.println("\nrtree "+nnode.data+"  "+nnode.parent.data);
					}
				}
				else {
					if(nnode.ltree==null && nnode.rtree==null) {
						//if both the left child and right child is null
						System.out.println("\nMax Heap Is Balanced");
						break;
					}
					if(nnode.ltree!=null && nnode.rtree==null) {
						//if the left child is not null and the right child is null
						if(nnode.ltree.data>nnode.data) {
							//left node is the greater,swapping the left child with the parent
							temp=nnode.data;
							nnode.data=nnode.ltree.data;
							nnode.ltree.data=temp;
							nnode=nnode.ltree;
						}
						else if(nnode.data>=nnode.ltree.data) {
							System.out.println("\nMax Heap Is Balanced");
							break;
						}
					}
				}
			}
		}
		else if(d<root.data) {
			//considering that it is the last node
			//reaching to the last node 
			MaxHeap tnode=root;
			//traversing to the left most node of the last level
			while(tnode.ltree!=null)
				tnode=tnode.ltree;
			
			//traversing to the right most node at the last level
			while(tnode.rsib!=null)
				tnode=tnode.rsib;
			
			if(tnode.data!=d) {
				System.out.println("\nInvalid Entry , Data Not Found");
				return;
			}
			
			//removing the node
			if(tnode.parent.ltree==tnode) {
				//if it is the left child
				tnode.parent.ltree=null;
			}
			if(tnode.parent.rtree==tnode) {
				//if it is the right child
				tnode.parent.rtree=null;
			}
		}
		else {
			System.out.println("\nInvalid Entry,Data is Greater Than The Root Node");
			return;
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
		
		System.out.print("\nEnter The Node Data To Delete : ");
		int d=Integer.parseInt(br.readLine());
		obj.deleteNode(d);
		
		System.out.println("\nAfter Deletion");
		System.out.println("\nPreorder Traversal");
		obj.preOrder(obj.root);
		System.out.println("\nInorder Traversal");
		obj.inOrder(obj.root);
		System.out.println("\nPostorder Traversal");
		obj.postOrder(obj.root);

	}

}
