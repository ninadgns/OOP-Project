package org.example.chat;

import org.example.database.DatabaseClient;
import org.example.database.Tables;
import org.example.demo1.otherClasses.Account;

public class Message {
    int id;
    int sender_id;
    int receiver_id;
    public String content;

    public Message(int sender_id, int receiver_id, String content) {
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.content = content;
    }

    public Message(int id, int sender_id, int receiver_id, String content) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.content = content;
    }

    public static Message sendMessage(int receiver_id, String content) {
        content = content.replaceAll("'", "");
        Message message = new Message(Account.loggedIn.id, receiver_id, content);
        DatabaseClient.insert(Tables.MESSAGES, "receiver_id, sender_id, content",
                receiver_id + ", " + Account.loggedIn.id + ", '" + content + "'");
        return message;
    }
}
