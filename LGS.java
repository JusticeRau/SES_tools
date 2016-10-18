package SES_tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LGS 
{
	public static void main(String[]args)
	{
		int n;
		ArrayList<Double> list = new ArrayList<Double>();
		ArrayList<Double> list_multi = new ArrayList<Double>();
		int d;
		double div_value;
		double multiplier_rev;
		int z;
		double value;
		double x;
		double y;
		double multiplier;
		double element = 0.0;
		
		
//		How to enter the values:
//		
//		9x +  5y + 4z = 21  \
//		                     \
//		6x +  3y - 5z =  7    | -->  (enter after each value) 9 5 4 21 6 3 -5 7 3 -10 6 35 
//		                     /
//		3x - 10y + 6z = 35  /

		System.out.println("Pls enter the number of equations");
		n = readInt();
		
		System.out.println("Please enter the values (left to right, 'enter' after each value)");
		for (int i = 0; i <= ((n*n+n)-1); i++)
		{
			value = readDouble();
			list.add(value);
		}
		
		for (int i = 0; i < (n-1); i++)
		{
			multiplier = list.get((n+1) * (i+1));
			list_multi.add(multiplier);
		}	
		
		for (int i = 0; i < n; i++)
		{
			div_value = list.get(i*(n+2));
			for (int h = i; h <= n-2; h++)
			{
				multiplier = list.get(((n+1) * (h + 1))+i);
				list_multi.set(h, multiplier);
			}
			for (int j = (i*(n+1)+i); j <= (i*n)+n+i; j++)
			{
				list.set(j, (list.get(j) / div_value));
				z = 0;
				if ((i+1) != n)
				{
					for (int k = i; k < (n-1); k++)
					{
						multiplier = list_multi.get(k);
						element = list.get(n+1+j+(z*(n+1))) - (multiplier * list.get(j));
						list.set(n+1+j+(z*(n+1)), element);
						z++;
					}
				}
			}
		}
		
		for (int r = 0; r < (n-1); r++)
		{	
			d = -1;
			for (int i = r; i < (n-1); i++)
			{
				d++;
				multiplier_rev = list.get(r*(n+1)+i+1);
			
				for (int j = ((r*(n+1))+i+1); j <= ((r*(n+1))+(n)); j++)
				{
					element = list.get(j) - multiplier_rev * list.get((j-(r*(n+1)))+((r+1)*(n+1))+(d*(n+1)));
					list.set(j, element);
				}
			}
		}
		
		for (int i = 0; i <= n*n+(n-1); i++)
		{
			y = list.get(i)*10000;
			x = Math.round(y);
			x = x / 10000;
			list.set(i, x);
		}
		
		for (int g = 0; g < n; g++)
		{
			System.out.println(" ");
			for(int i = g*(n+1); i <= g*(n+1)+n; i++)
			{
				System.out.print(list.get(i) + "  ");
			}
		}
	}
	
	public static int readInt()
	{
		int ss_readInt = 0;
		String erfassteDaten;
		try
		{
			erfassteDaten = (new BufferedReader((new InputStreamReader(System.in)))).readLine();
			ss_readInt = Integer.parseInt(erfassteDaten);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Value");
			System.exit(0);
		}
		return ss_readInt;
		
	}
	 public static double readDouble()
	  {double ss_readDouble = 0;
	   String erfassteDaten ;
	   try{erfassteDaten = (new BufferedReader((new InputStreamReader(System.in)))).readLine();
	       ss_readDouble = Double.parseDouble(erfassteDaten);
	       }
	   catch (Exception e)
	       {System.out.println("Invalid value");
	        System.exit(0);
	       }
	   return ss_readDouble;
	  }
}
