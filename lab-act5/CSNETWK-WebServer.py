#import socket module
from socket import *
import sys # In order to terminate the program

serverPort = 4000 #server port
serverSocket = socket(AF_INET, SOCK_STREAM)
#Prepare a sever socket
#Fill in start
serverSocket.bind(("", serverPort)) #wants the pair of the address and port number. just do localhost:4000/filename.file sa search bar
serverSocket.listen(1)
#Fill in end


while True:
    #Establish the connection
    print('CSNETWK Web Server is ready to serve...')
    connectionSocket, addr = serverSocket.accept()#Fill in start   #Fill in end #accepts new connection from client, in this case, the web page
    try: 
        message = connectionSocket.recv(1024).decode()#Fill in start #Fill in end #gets the path of the requested file, and makes it bytes
        filename = message.split()[1] #reads the entire filename
        f = open(filename[1:]) #opens the filename
        outputdata = f.read()#Fill in start #Fill in end #reads the contents of the file, assigns to outputdata
        f.close()
        #Send one HTTP header line into socket
        #Fill in start
        ok = "HTTP/1.1 200 OK\r\n\r\n" #assigning ok to have this string
        connectionSocket.send(ok.encode()) #connectionSocket.send only allows bytes, so we do the encode() function 
        #Fill in end

        #Send the content of the requested file to the client
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode()) #so essentially, we give the client (webpage) the contents of outputdata
       
        connectionSocket.send("\r\n".encode()) #I actually dont know what \r\n means but this is always shown sa wireshark
        connectionSocket.close()
    
    except IOError:
        #Send response message for file not found
        #Fill in start
        notFound = "HTTP/1.1 404 Not Found\r\n\r\n" # same things as sa ok string
        connectionSocket.send(notFound.encode())
        htmlNotFound = "<html><head></head><body> 404 Not Found </body></html>"
        connectionSocket.send(htmlNotFound.encode()) 
        #Fill in end
        #Close client socket
        #Fill in start
        connectionSocket.close()
        #Fill in end
        serverSocket.close()
        sys.exit()  #Terminate the program after sending the corresponding data