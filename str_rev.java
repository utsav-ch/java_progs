import java.io.*;

class MyClass
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//accepting input string
		System.out.print("Enter String : ");
		String str=br.readLine();

		int l=str.length();
		
		char rev[]=new char[l];	
		
		//reversing the string
		int i=0;
		for(int j=l-1;j>=0;j--)
		rev[i++]=str.charAt(j);
		
		//creating the reversed string
		String reverse=new String(rev);

		if(str.equals(reverse))
		System.out.println("The String "+str+" is Palindrome ");
		else
		System.out.println("Original String/Reversed String : "+str+"/"+reverse);
	}
}		
