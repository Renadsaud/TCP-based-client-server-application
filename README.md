# TCP-based-client-server-application
A project that develops a simple TCP-based client-server application, using Java Programming Language.(Project For The Network Course).

## What is a Socket?
The communication between different processes on the same nodes or different nodes is done using the concept of a socket. A socket is a structure that allows communication between processes i.e. sending and receiving data over a network.
A socket can be defined as an endpoint present in a two-way communication link (present between two processes running on the network).
<div>
  <img scr="![64FE2638-5124-4894-9D29-D15BED4069B0_1_201_a](https://github.com/NeehalSaleh/NFA-DFA-LL-1-parser/assets/95434316/f204e1e3-ac42-4fb5-b028-6d707408e2a5)
" width="400" height="200">
<div>
  
## What is TCP?
The transmission control protocol is a transport layer connection-oriented protocol that defined the standard of establishing and maintaining the conversation (or sockets) that will be used by the applications to exchange the data.

## What is Client-server Model or Architecture?
The client-server network model or architecture is one of the most widely used networking models. In the client-server network, the files are not stored on the hard drive of each computer system.

In a client-server network, there is a specific server and specific clients connected to the server. A server is always ON so client machines can access the files and resources without caring whether the server computer system is ON or not.

## Why did we use the TCP protocol?
One of the prime reasons for using the transmission control protocol over other protocol(s) like UDP is that the TCP ensures the reliable transmission and delivery of our data packets.

## The programming language used

We used Java socket programming to implement the client-server communication over TCP protocol.

## Implementation

The server will create a new ServerSocket object to listen to a specific port. While running the server, it will choose a port that is not used. If the server successfully binds to its port, then the ServerSocket object is successfully created, and the server will go to the next step accepting a connection from a client.
And when the client is connected we start the communication and wait for till the client sends input.

The client will be Creating a stream socket and connect it to the specific port number at the IP address and then start the communication and sending input.

For the steps of setting up the network, we set up two hosts by using two laptops one for a client and one for a server. We used wireless technology, we connect two Computers using the same wireless access point. After, We got the IP address for the server. finally, We put the IP in the client code, and then will the connection will complete successfully.
