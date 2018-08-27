package cs151_h1w;

import java.util.Set;
import java.util.TreeSet;

public class Encoding {
	public static final String x = ".";
	public static final String y = "-";
	public  String z= "";
	public static Set<String> set = new TreeSet<>();
	public static Set<String> morseCodes(int m, int n)
	{
		int u = m;
		int v = n;
		String z = "";
		for(int i = 0; i <u ; i++)
		{
			z = z + x;
		}
		for(int j = 0; j < v; j++)
		{
			z = z + y;
		}
		morseCode(z,0,z.length()-1);
		return set;
	}
	
	public static void morseCode(String z, int m, int n)
	{
		if(m== z.length())
		{
			set.add(z);
		}
		else
		{
			for(int i =1; i <= n; i++)
			{
				z= swap(z,m,i);
				morseCode(z, m+1,n);
				z= swap(z,m,i);
			}
		}
	}
	
	public static String swap(String s, int m, int n)
	{
		char temporary;
		char[] charArray = s.toCharArray();
		temporary = charArray[m];
		charArray[m] = charArray[n];
		charArray[n]= temporary;
		return String.valueOf(charArray);
	}
	public static void main(String[] args)
	{
		Encoding encoder = new Encoding();
		System.out.println(encoder.morseCodes(2, 1));
		System.out.println(encoder.morseCodes(2,3));
		System.out.println(encoder.morseCodes(4, 2));
	}
	
}
