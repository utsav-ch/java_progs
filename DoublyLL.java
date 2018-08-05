package pack_age;

import java.io.*;

public class DoublyLL {
	
	String data;
	DoublyLL rptr;//nodes right pointer
	DoublyLL lptr;//nodes left pointer
	DoublyLL start;//pointer to the first node on the list
	DoublyLL newnode;//pointer to the newly created node
	DoublyLL end;//pointer to the last node
	
	void createNode(BufferedReader br)throws IOException {
		newnode=new DoublyLL();//creating a new node
		System.out.print("\nEnter Node Data : ");
		newnode.data=br.readLine();
	}
	
	void insertAtFront() {
		if(start==null) {//if the list is empty
			//setting up the newnode as the first node
			start=newnode;
			end=newnode;
		}
		else {//if the list is not empty
			newnode.rptr=start;
			start.lptr=newnode;
			start=newnode;
		}
	}
	
	void insertAtEnd() {
		if(start==null) {//if the list is empty
			//setting up the newnode as the first node
			start=newnode;
			end=newnode;
		}
		else {//if the list is not empty
			
			//inserting newnode as the last node
			end.rptr=newnode;
			newnode.lptr=end;
			end=newnode;
		}
	}
	
	void insertAtPos(int pos,int nodec) {
		
		if(pos>=1 && pos<=(nodec+1)) {//if requested position is between 1 and lastNodePosition+1
			if(pos==1)//insertion at the Front Requested
				insertAtFront();
			else if(pos==(nodec+1))//insertion at the end requested
				insertAtEnd();
			else {
				DoublyLL ptr=start;
				for(int i=1;i<(pos-1);i++) //traversing to the node after which insertion needs to be done 
					ptr=ptr.rptr;
					
				
				newnode.lptr=ptr;
				newnode.rptr=ptr.rptr;
				ptr.rptr.lptr=newnode;
				ptr.rptr=newnode;
				//System.out.println(ptr.rptr.data);//data
				//System.out.println(newnode.lptr.data);//second
				//System.out.println(newnode.rptr.data);//third
				//System.out.println(newnode.rptr.lptr.data);//data
			}
			System.out.println("\nNode Insterted At Poistion "+pos);
		}
		else
			System.out.println("Invalid Position,Try Again");
	}
	
	int nodeCount() {
		int count=0;//counter
		DoublyLL temptr=start;
		while(temptr!=null) {
			++count;
			temptr=temptr.rptr;
		}
		return count;
	}
	
	void displayNodes(BufferedReader br)throws IOException {
		System.out.println("\nEnter F to Display The List From Front To End\n");
		System.out.println("\nEnter R to Display The List From End To Front\n");
		System.out.print("\nEnter Choice : ");
		String ch=br.readLine();
		switch(ch.charAt(0)) {
		case 'F':
		case 'f':DoublyLL temptr=start;
		int i=0;
		while(temptr!=null) {
			System.out.println("\nValue At Node "+ ++i +" : "+temptr.data);
			temptr=temptr.rptr;
		}
		break;
		
		case 'R':
		case 'r':DoublyLL temp=end;
		int j=nodeCount();
		while(temp!=null) {
			System.out.println("\nValue At Node "+ j-- +" : "+temp.data);
			temp=temp.lptr;
		}
		break;
		
		default:System.out.println("Invalid Choice,Try Again");
		}
	}
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		DoublyLL obj=new DoublyLL();
		int choice=1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("\nEnter 1 To Insert The Node At The Front");
			System.out.println("Enter 2 To Insert The Node At The End");
			System.out.println("Enter 3 To Insert The Node At A Given Position");
			System.out.println("Enter 4 To Get The Node Count");
			System.out.println("Enter 5 To Print Node Data");
			System.out.println("Enter 0 To Exit");
			System.out.print("\nEnter Choice : ");
			choice=Integer.parseInt(br.readLine());
			
			switch(choice) {
			
			case 1:System.out.println("\nCreating A Node To Be Entered At The Beginning");
			obj.createNode(br);
			obj.insertAtFront();
			System.out.println("\nThe New Node Has Been Insterted As The First Node\n");
			break;
			
			case 2:System.out.println("\nCreating A Node To Be Entered At The Beginning");
			obj.createNode(br);
			obj.insertAtEnd();
			System.out.println("\nThe New Node Has Been Insterted As The Last Node\n");
			break;
			
			case 3:System.out.println("\nCreating A Node To Be Entered At A Given Position");
			obj.createNode(br);
			int nodec=obj.nodeCount();
			System.out.print("\nEnter Poisition(1-"+(nodec+1)+") : ");
			int pos=Integer.parseInt(br.readLine());
			obj.insertAtPos(pos,nodec);
			break;
			
			case 4:System.out.println("The Total No. Of Nodes Are : "+obj.nodeCount());
			break;
			
			case 5:obj.displayNodes(br);
			break;
			
			default:if(choice!=0)
				System.out.println("\nInvalid Choice,Try Again");
			}
		}while(choice!=0);

	}

}
