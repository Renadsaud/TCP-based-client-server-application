
// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
    //initialize socket and input stream
    private Socket		 socket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;
    private DataOutputStream out =null;
    private PrintWriter writer = null;
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            // Send input to the client socket

             
            writer = new PrintWriter(socket.getOutputStream(), true);

            String line = "";

            {
                try
                {
                    // Getting Data from client 
                    line = in.readUTF();
                    // Checking if Client send me 1 then open the program in open mode
                    if(line.equals("1")){
                        // Getting Data from client 
                        line = in.readUTF();
                        // And printing it on the console.
                        System.out.println("Open Mode :\n ");
                        System.out.println("Client  = "+line);
                         try{

                    // Sending copy to Client 
                      DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                      dout.writeUTF(line);
                      dout.close();

                    }
                    catch(IOException i)
                    {
                        System.out.println(i);
                    }            

                    }
                    // Checking if Client send me 2 then open the program in Secure mode
                    if(line.equals("2")){
                        // Getting Data from client 
                        line = in.readUTF();
                        System.out.println("Encrpyted Mode :\n ");
                        // And printing it on the console.

                        System.out.println("Client  = "+line);
                        // Decrpyting the data  
                        int key=2;
                        String decrpt="";
                        for(int i=0; i<line.length(); i++){
                            decrpt+= (char)(line.charAt(i)-key);
                        }
                        // And printing it on the console.
                        System.out.println("Decrypted stirng  = "+decrpt);
                         try{

                    // Sending copy to Client 
                      DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                      dout.writeUTF(line);
                      dout.close();

                    }
                    catch(IOException i)
                    {
                        System.out.println(i);
                    }            

                    }
                          

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}
