import java.io.*;

class MyClass
{
		public static void main(String args[])throws IOException
		{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				//accepting string
				System.out.print("Enter String : ");
				String str=br.readLine();
				
				System.out.print("Alternate Characters : ");
				
				for(int i=0;i<str.length();i=i+2)
				System.out.print(str.charAt(i)+" ");
		}
}