# netwk-pp
Submission for CSNETWK programming pair


## Lab Act 3
Lab Act 3 is a Command-Line Interface Java socket programming application where a Server sends a file to a connected Client.
To run the Server:
`javac FileServer.java` then
`java FileServer localhost 3000`

To run the Client:
`javac FileClient.java` then
`java FileClient 3000`

## Lab Act 4
Lab Act 4 is a Command-Line Interface Java socket programming application where a Server allows the connection of more than one client and allows messages to be sent and received by two different clients.
To run the Server:
`javac ChatServer.java` then
`java ChatServer 3000`

To run a Client named "Alice" with the message "Hi!":
`javac ChatClient.java` then
`java ChatClient localhost 3000 "Alice" "Hi` 

To run a Client named "Bob" with the message "Hello!":
`java ChatClient localhost 3000 "Bob" "Hello!"`

## Lab Act 5
Lab Act 5 is a Python web server programming application where a Server is to run and an html page and send the appropriate HTTP header, whether it is a 200 OK or a 404 Not Found.

To run the Server:
`py CSNETWK-WebServer.py`
Opening a web browser, please type:
`localhost:3000/CSNETWK.html` This should work and return an HTTP header of 200 OK. Any other server host or file to be opened should result in a 404 Not Found


