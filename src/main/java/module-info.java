module org.example.demo1 {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens org.example.demo1 to javafx.fxml;
    exports org.example.demo1;
    exports org.example.demo1.otherClasses;
    opens org.example.demo1.otherClasses to javafx.fxml;
}