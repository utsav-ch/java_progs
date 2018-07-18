import java.io.*;

class MyClass
{
		public static void main(String args[])throws IOException
		{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println();
				System.out.print("Enter Array Length : ");
				int arr_len=Integer.parseInt(br.readLine());
				
				//creating integer array
				int arr[] = new int[arr_len];
				
				//accepting input
				System.out.println();
				for(int i=0 ; i<arr_len ;i++)
				{
					System.out.print("arr["+i+"] : ");
					arr[i]=Integer.parseInt(br.readLine());
				}
				
				//Finding odd and even
				System.out.println();
				System.out.println("Elements  Odd  Even");
				for(int i=0 ; i<arr_len ; i++)
				{
						System.out.print("    "+arr[i]);
						if(arr[i]%2==0)
						System.out.println("            "+arr[i]);
						else
						System.out.println("      "+arr[i]);
				}
				
		}
}