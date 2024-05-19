# Project README

This application is composed of a server and a client, both zipped together in separate directories: the 'Server' and 'Client' folders respectively.

The primary function of the server part of the application resides in the following file:

```
Server/src/main/java/org/example/demo1/ChatServer.java
```

You'll find the client portion contained within the 'Client' folder.

To run the application, start by executing the server file:

```
Server/src/main/java/org/example/demo1/ChatServer.java
```

Subsequently, launch the main program whose entry point is:

```
Client/src/main/java/org/example/demo1/HelloApplication.java
```

The application fetches its data from a network-hosted database, thus, a reliable network connection is recommended for optimal functionality.

Regarding the chat feature of this application, it depends on the server you've just run. By default, the chat client assumes that the chat server resides on `localhost`. Should your server be located on a different network, specify the server's IP address in the `ChatServerIP` variable found in:

```
Client/src/main/java/org/example/demo1/TelegramController.java
```

Remember to unpack the zipped 'Server' and 'Client' folders before attempting to run the server or client files.