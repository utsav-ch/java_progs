import java.io.*;//for taking user input into the string

class MyClass
{
	public static void main(String args[])throws IOException
	{
		//creating a stream to accpt input from the keyboard
		InputStreamReader obj=new InputStreamReader(System.in);

		//creating buffred reader stream
		BufferedReader br =new BufferedReader(obj);

		//input string
		System.out.print("Enter String :");
		String str= br.readLine();

		//converting string to character array
		char arr[]=str.toCharArray();

		//calculating length
		int len=0;
		for(char ch:arr)
		len++;

		System.out.println("String/length : "+str+"/"+len);
	
	}
}