package cs151_h1w;

public class Strings {
	 public String uniqueLetters(String str)
	   {
	      String theNew = str;
	      int l = theNew.length();
	      for(int i = 0; i < l; i++)
	      {
	    	  String char1 = theNew.substring(i, i+1);
	    	 for(int j = i + 1; j < l; j++)
	    	 {
	    		 String char2 = theNew.substring(j, j+1);
	    		 if(char1.equals(char2))
		    	 {
		    		 theNew = theNew.replaceAll(char1, "");
		    		 l = theNew.length();
		    		 i=0;
		    		 j = l;
		    	 }
	    	 }
	    	
	      }
	      return theNew;
	   }
	 
	 public static void main(String[] args)
	 {
		Strings uh = new Strings();
		System.out.println(uh.uniqueLetters("harrasses"));
		System.out.println(uh.uniqueLetters("mississippi"));
		System.out.println(uh.uniqueLetters("missouri"));
		System.out.println(uh.uniqueLetters("orinoco"));
		System.out.println(uh.uniqueLetters("barbara"));
	 }
}
