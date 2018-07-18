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
				int sum_total=0,sum_odd=0,sum_even=0;
				System.out.println();
				System.out.println("Elements  Odd  Even");
				for(int i=0 ; i<arr_len ; i++)
				{
						sum_total=sum_total+arr[i];
						System.out.print("    "+arr[i]);
						if(arr[i]%2==0)
						{
								System.out.println("            "+arr[i]);
								sum_even=sum_even+arr[i];
						}
						else
						{
								System.out.println("      "+arr[i]);
								sum_odd=sum_odd+arr[i];
						}
				}
				System.out.print("\nTotal Sum : "+sum_total+"\n"+"Sum of All Even No.s : "+sum_even+"\n"+"Sum of all Odd No.s : "+sum_odd);
				
		}
}