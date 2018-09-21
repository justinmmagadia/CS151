package mail;
import java.util.ArrayList;
import java.util.*;

/**
   A system of voice mail boxes.
*/
public class MailSystem
{
   /**
      Constructs a mail system with a given number of mailboxes
      @param mailboxCount the number of mailboxes
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList<>();
      Scanner scan = new Scanner(System.in);
      
      // Initialize mail boxes.
      
      for (int i = 0; i < mailboxCount; i++)
      {
    	 
    		  String passcode = "" + (i + 1);
    	         String greeting = "You have reached mailbox " + (i + 1)
    	        	 + (". \nPlease leave a message now, and enter H when finished");
    	        	mailboxes.add(new Mailbox(passcode, greeting));
    	        	
    	     
    	  }
        
	
      }
   

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox or null if not found
   */
   public Mailbox findMailbox(String ext)
   {
	   if(!(ext.length() == 2) && !(ext.length() == 1))
	   {
		   return null;
	   }
	   else if((("1234567890".contains(ext))))
		{
		   int i = Integer.parseInt(ext);
			  if (i <= mailboxes.size())
		         return  mailboxes.get(i - 1);
			  else return null;
		}
	    else 
	    {
	    	return null;
		}
			
	  }
	           

   private ArrayList<Mailbox> mailboxes;
}
