//finding the length of the string by converting it into character array using the method toCharArray()
class MyClass
{

	public static void main(String args[])
	{
		String str="Utsav";
		int len=0;
		char arr[]=str.toCharArray();
		for(char c:arr)
		len++;
		System.out.println("Input String/String Length : "+str+"/"+len); 
	}
}
		