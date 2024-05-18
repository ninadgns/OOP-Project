package org.example.chat;

import org.example.database.DatabaseClient;
import org.example.demo1.otherClasses.Account;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Chat {
    int receiver_id = Account.loggedIn.id;
    int sender_id;
    int last_message_id = 0;

    public Chat(int sender_id) {
        this.sender_id = sender_id;
    }

    public ArrayList<Message> getNewMessages() {
        ResultSet rs = DatabaseClient
                .runSQL("SELECT * FROM messages WHERE (sender_id = " + sender_id + " AND receiver_id = " + receiver_id
                        + ") OR (sender_id = " + receiver_id + " AND receiver_id = " + sender_id + ") AND id > "
                        + last_message_id + " ORDER BY id;");
        ArrayList<Message> messages = new ArrayList<Message>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                messages.add(new Message(id, sender_id, receiver_id, content));
                last_message_id = id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

}
