package org.example.database;
// import java.io.*;
// import java.net.*;
// import java.util.*;
// public class ChatServer {
//     private static Map<String, PrintWriter> userWriters = new HashMap<>();
//     private static Map<String, Queue<String>> userQueues = new HashMap<>();
//     public static void main(String[] args) throws Exception {
//         ServerSocket serverSocket = new ServerSocket(6666);
//         while (true) {
//             new ClientHandler(serverSocket.accept()).start();
//         }
//     }
//     private static class ClientHandler extends Thread {
//         private Socket socket;
//         private String name;
//         public ClientHandler(Socket socket) {
//             this.socket = socket;
//         }
//         public void run() {
//             try {
//                 var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                 var out = new PrintWriter(socket.getOutputStream(), true);
//                 while (true) {
//                     out.println("SUBMITNAME");
//                     name = in.readLine();
//                     synchronized (userWriters) {
//                         if (name != null && !name.isEmpty() && !userWriters.containsKey(name)) {
//                             userWriters.put(name, out);
//                             out.println("NAMEACCEPTED " + name);
//                             // Fetch stored messages for the user and send them
//                             synchronized (userQueues) {
//                                 Queue<String> messageQueue = userQueues.get(name);
//                                 if (messageQueue != null) {
//                                     String message;
//                                     while ((message = messageQueue.poll()) != null) {
//                                         out.println("MESSAGE " + message);
//                                     }
//                                 }
//                             }
//                             break;
//                         }
//                     }
//                 }
//                 while (true) {
//                     String input = in.readLine();
//                     if (input == null) {
//                         return;
//                     }
//                     var parts = input.split(" ", 3);
//                     String user = parts[1];
//                     String message = parts[2];
//                     PrintWriter writer;
//                     synchronized (userWriters) {
//                         writer = userWriters.get(user);
//                     }
//                     if (writer != null) {
//                         writer.println("MESSAGE " + name + ": " + message);
//                     } else { // User not online, store the message for later
//                         synchronized (userQueues) {
//                             Queue<String> userQueue = userQueues.computeIfAbsent(user, k -> new LinkedList<>());
//                             userQueue.add(name + ": " + message);
//                         }
//                     }
//                 }
//             } catch (IOException e) {
//                 System.out.println(e.getMessage());
//             } finally {
//                 if (name != null) {
//                     synchronized (userWriters) {
//                         userWriters.remove(name);
//                     }
//                 }
//                 try {
//                     socket.close();
//                 } catch (IOException e) {
//                 }
//             }
//         }
//     }
// }

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Map<String, PrintWriter> userWriters = new HashMap<>();

    public static void start(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            new ClientHandler(serverSocket.accept()).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                var out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    // out.println("SUBMITNAME");
                    name = in.readLine();
                    synchronized (userWriters) {
                        if (name != null && !name.isEmpty() && !userWriters.containsKey(name)) {
                            userWriters.put(name, out);
                            // out.println("NAMEACCEPTED " + name);
                            // Fetch stored messages for the user from database and send them
                            // List<Pair<String, String>> messageList = DatabaseClient.fetchMessage(name);
                            // if (messageList != null) {
                            //     for (Pair<String, String> messagePair : messageList) {
                            //         String senderName = messagePair.getLeft();
                            //         String message = messagePair.getRight();
                            //         out.println("MESSAGE " + senderName + ": " + message);
                            //     }
                            // }

                            break;
                        }
                    }
                }

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    var parts = input.split(" ", 3);
                    String receiver = parts[1];
                    String messageText = parts[2];
                    PrintWriter writer;

                    // Insert the message into the database
                    DatabaseClient.insertMessage(receiver, name, messageText);

                    synchronized (userWriters) {
                        writer = userWriters.get(receiver);
                    }
// jane@example.com
// password2
                    if (writer != null) {
                        writer.println(messageText);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (name != null) {
                    synchronized (userWriters) {
                        userWriters.remove(name);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
