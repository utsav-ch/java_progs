package pack_age;
import java.io.*;

public class LinkedList {
	String data;
	LinkedList ptr;
	LinkedList nodeptr;//pointer to the last node
	LinkedList newnode;//pointer to the new node
	LinkedList start;//pointer to the first node
	int nodecount;//to keep the count of nodes
	
	void createNode(String str) {
		newnode=new LinkedList();
		newnode.data=str;//initializing data in the node
		if(nodeptr==null) {//if the new node is the first node
			start=newnode;//pointing the start reference variable to the first node
			nodeptr=newnode;//pointing the nodeptr reference variable to the only node on the list
		}
		System.out.println("New Node Created\n");
	}
	void insterAtEnd() {
		if(newnode!=start) {//if the newnode is the only node of the list , no action required
			nodeptr.ptr=newnode;//the second last node points to the last node
			nodeptr=newnode;//nodeptr points to the last node
			System.out.println("\nNew Node Inserted At The End\n");
		}
	}
	void insterAtFront() {
		if(newnode!=start) {//if the newnode is the only node of the list , no action required
			newnode.ptr=start;//the newnode points to the second node
			start=newnode;//the start points to the newnode now
			System.out.println("\nNew Node Inserted At The Front\n");
		}
	}
	void nodeCount()
	{
		nodecount=0;
		LinkedList temptr=start;
		if(nodeptr!=null) {//if the list is not empty
			while(temptr!=null) {
				nodecount++;
				temptr=temptr.ptr;
			}
		}
	}
	
	void displayNodes() {
		LinkedList temptr=start;
		int c=0;
		if(nodeptr!=null) {//if the list is noe empty
			while(temptr!=null) {
				System.out.println("Node "+ ++c +"  Data : "+temptr.data);
				temptr=temptr.ptr;
			}
		}
		else
			System.out.println("The List IS Empty,Please Enter Some Data First To DIsplay");
	}
		
	void insertAtPos(int pos) {
		
		if(pos>=1 && pos<=(nodecount+1)) {// checking if the requested position is valid
			if(pos==1) {
				System.out.println("Node Insertion At The Front Requested");
				insterAtFront();
			}
			else if(pos==(nodecount+1)) {
				System.out.println("Node Insertion At The End Is Requested");
				insterAtEnd();
			}
			else {
				LinkedList temptr=start;
				for(int i=1;i<pos-1;i++) //moving the pointer to the node after which instertion needs to be done
					temptr=temptr.ptr;
				
				newnode.ptr=temptr.ptr;//newnode points to the next node
				temptr.ptr=newnode;//establishing link between the previous node and the newnode
				
				System.out.println("Node Insrted at Position "+pos);
			}
		}
		else
			System.out.println("Invalid Position Of Insertion Requested\n"
					+ "Kindly Slect A Position Between 1 and "+(nodecount+1));
	}
		
	

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		LinkedList obj=new LinkedList();
		int choice=1;//default value
		 do{
			
			System.out.println("\n\nEnter 1 to Insert The Node At The End");
			System.out.println("Enter 2 to Insert The Node At The Front");
			System.out.println("Enter 3 For Node Count");
			System.out.println("Enter 4 to Display Data of All the Nodes");
			System.out.println("Enter 5 to Insert the node at A Given Position");
			System.out.println("Enter 0 to Quit\n");
			System.out.print("Enter Choice : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice=Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1: System.out.println("Creating A New Node");
			System.out.print("Enter Data for the node : ");
			String str=br.readLine();
			obj.createNode(str);
			obj.insterAtEnd();
			break;
			
			case 2:System.out.println("Creating A New Node");
			System.out.print("Enter Data for the node : ");
			str=br.readLine();
			obj.createNode(str);
			obj.insterAtFront();
			break;
			
			case 3:obj.nodeCount();
			System.out.println("\nNo. of Nodes : "+obj.nodecount);
			break;
			
			case 4:System.out.println("The Entered Data Is :\n\n");
			obj.displayNodes();
			break;
			
			case 5:System.out.println("Creating A New Node To Be Inserted\n");
			System.out.print("Enter Data for the node : ");
			str=br.readLine();
			obj.createNode(str);
			obj.nodeCount();
			System.out.print("\nEnter Position To Enter The Node(1 to "+(obj.nodecount+1)+") : ");
			int pos=Integer.parseInt(br.readLine());
			
			obj.insertAtPos(pos);
			break;
			
			default:if(choice!=0)
				System.out.println("Invalid Entry , Try Again");
			}
			
		}while(choice!=0);
		
		
		
		
		
		

	}

}
