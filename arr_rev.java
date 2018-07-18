import java.io.*;

class MyClass
{
		public static void main(String args[])throws IOException
		{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("\nEnter Array Length : ");
				int arr_len = Integer.parseInt(br.readLine());
				
				//creating array 
				int arr[] = new int[arr_len];
				
				//input elements
				System.out.println("\nEnter Elements");
				for(int i=0; i<arr_len;i++)
				{
						System.out.print("arr["+i+"] : ");
						arr[i]=Integer.parseInt(br.readLine());
				}
				
				//reversing the array
				int temp;
				for(int i=0,j=arr_len-1; i<j ; i++,j--)
				{
						temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
				}
				//printing the reversed array
				System.out.println("\nAfter Reversing");
				for(int i=0;i<arr_len;i++)
				System.out.println("arr["+i+"] = "+arr[i]);
		}
}