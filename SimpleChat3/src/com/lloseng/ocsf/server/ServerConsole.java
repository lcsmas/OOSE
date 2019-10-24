package com.lloseng.ocsf.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.lloseng.ocsf.client.ChatIF;


public class ServerConsole implements ChatIF{
	  EchoServer server;

	  public ServerConsole(int port) 
	  {
		  server = new EchoServer(port, this);
	  }

	  
	  //Instance methods ************************************************
	  
	  /**
	   * This method waits for input from the console.  Once it is 
	   * received, it sends it to the server message handler.
	   */
	  public void accept() 
	  {
	    try
	    {
	      BufferedReader fromConsole = 
	        new BufferedReader(new InputStreamReader(System.in));
	      String message;

	      while (true) 
	      {
	        message = fromConsole.readLine();
	        server.handleMessageFromServerConsole(message);
	      }
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println
	        ("Unexpected error while reading from console!");
	    }
	  }

	  /**
	   * This method overrides the method in the ChatIF interface.  It
	   * displays a message onto the screen.
	   *
	   * @param message The string to be displayed.
	   */
	  public void display(String message) 
	  {
	    System.out.println("Server MSG > " + message);
	  }

	  
	  //Class methods ***************************************************
	  
	  /**
	   * This method is responsible for the creation of the Client UI.
	   *
	   * @param args[0] The host to connect to.
	   */
	  public static void main(String[] args) 
	  {
		  int port = 0; //Port to listen on

		  try
		  {
			  port = Integer.parseInt(args[0]); //Get port from command line
		  }
		  catch(Throwable t)
		  {
			  port = EchoServer.DEFAULT_PORT; //Set port to 5555
		  }
		  
		  ServerConsole sc = new ServerConsole(port);


		  try 
		  {
			  sc.server.listen(); //Start listening for connections
		  } 
		  catch (Exception ex) 
		  {
			  System.out.println("ERROR - Could not listen for clients!");
		  }
		  
		  
		  
		  sc.accept();  //Wait for console data
	  }
}
