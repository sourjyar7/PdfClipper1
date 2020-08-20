import java.io.File;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.LinkOption;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class User {
  private String username,password;
  
  
  
  public User(String username,String password)
  {
	  this.username=username;
	  this.password=password;
	  
     
  }
  
  void save() throws Exception
  {
	 //File f=new File(System.getProperty("user.dir")); 
	 FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"\\"+"users.txt",true);
	 File file = new File(System.getProperty("user.dir")+"\\"+"users.txt");
     //setHiddenAttrib(file);

	 
	 byte []user=(this.username + "  ").getBytes();
	 this.password=new Hash().getHash(this.password);
	 byte []pass=(this.password + "\n").getBytes();
	 fout.write(user);
	 fout.write(pass);
	 fout.close();
  }

  boolean match() throws Exception
  {   
	  FileInputStream fread=new FileInputStream(System.getProperty("user.dir")+"\\"+"users.txt");
	   
	  int c; String s="";
	  while(true)
	   {
		c=fread.read();
	    if(c != -1) 
	    {
	    	if( '\n' == (char)c)
	    	{   s.trim();
	    		if(s.substring(0,s.indexOf(" ")).equals(username) && s.substring(s.lastIndexOf(" ")+1).equals(new Hash().getHash(password)))
		        { fread.close();
		    	  return true;
		        }
	    		s="";
	    	  
	    	}
	    	    else
	    	   {s = s + (char)c;
	    	   }
	    }
	    else
	    {break;
	    }
	   
	   }
	  fread.close();
	  return false;
  }

public static void setHiddenAttrib(File file) {
	try {
        // execute attrib command to set hide attribute
        Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
        // for removing hide attribute
        //Process p = Runtime.getRuntime().exec("attrib -H " + file.getPath());
        p.waitFor(); 
        if(file.isHidden()) {
            System.out.println(file.getName() + " hidden attribute is set to true");
        }else {
            System.out.println(file.getName() + " hidden attribute not set to true");
        }
    } catch (IOException | InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	
}
}

