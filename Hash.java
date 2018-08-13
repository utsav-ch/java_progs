package pack_age;

import java.io.*;

public class Hash {
	
	int hash;//storing the hash value
	String key;//for holding the key
	String value;//for holding the value
	Hash ptr;//pointer to the next node
	
	Hash(){}//default constructor
	
	Hash(BufferedReader br)throws IOException {//Parameterized constructor
		System.out.print("\nEnter Key : ");
		key=br.readLine();
		System.out.print("\nEnter Value : ");
		value=br.readLine();
	}
	
	void funhash() {
		hash=0;
		int i=0;
		try {
			while(true) {
				hash=hash+key.charAt(i)+i;
				i++;
			}	
		}
		catch(StringIndexOutOfBoundsException ex) {}
	}
	
	void insertRecord(int rec,Hash hashArr[],BufferedReader br)throws IOException {
		for(int i=0;i<rec;i++) {
			System.out.println("\nEnter Data For Record "+(i+1));
			Hash newrec=new Hash(br);//initializing the object to be inserted in the hash map
			newrec.funhash();//calculating hash
			int indx=newrec.hash%rec;//calculating index
			//System.out.println("\n hash/index : "+newrec.hash+"/"+indx);
			if(hashArr[indx]==null) {//if the location is empty
				//inserting the record directly
				hashArr[indx]=newrec;
				System.out.println("\nRecord Inserted At Index "+indx);
			}
			else {
					int flag=0;
					Hash temptr=new Hash();
					temptr=hashArr[indx];
					while(true) {//finding the last node after which insertion can be done
						if((temptr.hash==newrec.hash) && (temptr.key.equals(newrec.key))) {
							//if its the same record no need to perform any insertion again
							System.out.println("\nRecord Alredy there,No need Of Insertion");
							flag=1;
							break;
						}
						else if(temptr.ptr==null) {
							//if its the last node
							break;
						}
						else
							temptr=temptr.ptr;//traversing to the next node
					}
					if(flag==0) {//if we are at the last node
					temptr.ptr=newrec;//new record inserted at the end of the linked list	
					System.out.println("\nRecord Inserted At Index"+indx);
					}
			}
		}
	}
	
	void searchRecord(int rec,Hash hashArr[],BufferedReader br)throws IOException {
		//searching element
				//Hash searchobj=new Hash();
				System.out.print("\nEnter The Key For Searching :");
				key=br.readLine();
				funhash();
				int searchindx=hash%rec;
				Hash tempsearch=hashArr[searchindx];
				//System.out.println(key+" "+hash+" "+searchindx);
				try {
					while(true) {
						if((tempsearch.hash==this.hash) && (tempsearch.key.equals(this.key))) {
							//if its the same record
							System.out.println("\nRecord Found , Value : "+tempsearch.value);
							break;
						}
						else if(tempsearch.ptr==null) {
							//if its the last node
							System.out.println("\nRecord Not Found,Invalid Entry ,Try Again");
							break;
						}
						else
							tempsearch=tempsearch.ptr;//traversing to the next node
					}
				}
				catch(NullPointerException ex) {
					System.out.println("\nRecord Not Found,Invalid Entry ,Try Again");
				}
				
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter The No. Of Records To Be Stored : ");
		int rec=Integer.parseInt(br.readLine());
		//creating array of object references of length rec
		Hash hasharr[]=new Hash[rec];
		
		Hash callingObj=new Hash();
		
		callingObj.insertRecord(rec, hasharr, br);//inserting records
		
		callingObj.searchRecord(rec, hasharr, br);//seraching Record
		
		
		

	}

}
