package org.example.demo1.otherClasses;

import javafx.event.ActionEvent;
import org.example.demo1.SignInPageController;

import java.io.IOException;

public interface Client {
    Account account = new Account();
    void setPage(ActionEvent actionEvent, Class<? extends SignInPageController> aClass) throws IOException;
}
