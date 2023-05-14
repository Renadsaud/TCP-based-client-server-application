// A Java program for a Client
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client
{
    // initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;
    private DataInputStream in = null;
    // constructor to put ip address and port
    public Client(String address, int port) throws IOException {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
            // sends Input to the socket
            in = new DataInputStream(socket.getInputStream());

        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";
        // Menu printing and taking the input
        System.out.println("Press 1 for Open Mode");
        System.out.println("Press 2 for secure Mode");
        System.out.println("Press 3 for Quit Application");
        int choice=0;
        // Taking input from user
        Scanner myObj = new Scanner(System.in);
        int userinput = myObj.nextInt();

        // Sending input to client it means server have to open program in open mode or secure mode
        out.writeUTF(String.valueOf(userinput));

        // Checking if the input is 1 then open the program in open mode
        if(userinput==1){
            // Error handling
            try
            {
                System.out.println("Enter Input");
                // Taking input from user and sending to Server 
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
             try {
        // Getting copy from Server
          
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String copydata = (String) dis.readUTF();
            System.out.println("Copy Got from Server : " + copydata);

            dis.close();
          

        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        }
        // Checking if the input is 2 then open the program in secure mode

        else if(userinput==2){
            // Encrpytion Key
            int key = 2;
            // Taking input from user
            System.out.println("Enter Input");
            line = input.readLine();
            // Encrpyting the string using key
            String encrpyt="";
            for(int i =0; i<line.length(); i++){
                encrpyt+= (char) (line.charAt(i)+key);
            }
            // Error Handling

            try
            {
                // Sending input to server and server will decode their.
                out.writeUTF(encrpyt);

            }
            catch(IOException i)
            {
                System.out.println(i);
            }
 try {
        // Getting copy from Server
          
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String copydata = (String) dis.readUTF();
            System.out.println("Copy Got from Server : " + copydata);

            dis.close();
          

        }
        catch(IOException i)
        {
            System.out.println(i);
        }


        }
       
        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[]) throws IOException {
        Client client = new Client("127.0.0.1", 5000);
    }
}
