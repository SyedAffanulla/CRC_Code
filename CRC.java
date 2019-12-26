import java.util.Scanner;

public class CRC 
{
	public static int n;
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		CRC crc= new CRC();
		String copy,code,rec,zero="0000";
		System.out.println("Enter the dataword:");
		code= sc.nextLine();
		n= code.length();
		copy= code;
		code+= zero;
		code= crc.divide(code);
		System.out.println("dataword="+copy);
		copy= copy.substring(0,n)+code.substring(n);
		System.out.println("CRC=");
		System.out.println(code.substring(n));
		System.out.println("Transmitted frame="+copy);
		System.out.println("Enter the recieved data");
		rec= sc.nextLine();
		if(zero.equals(crc.divide(rec).substring(n)))
			System.out.println("Correct bits recieved");
		else
			System.out.println("wrong");
		sc.close();
	}

	public String divide(String s)
	{
		String div="1000";
		int i,j;
		char x;
		for(i=0;i<n;i++)
		{
			x=s.charAt(i);
			for(j=0;j<4;j++)
			{
				if(x=='1')
				{
					if(s.charAt(i+j)!=div.charAt(j))
						s= s.substring(0,i+j)+"1"+s.substring(i+j+1);
					else
						s= s.substring(0,i+j)+"0"+s.substring(i+j+1);
				}
			}
		}
		return s;
	}
} 

