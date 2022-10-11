module com.example.helojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.helojavafx to javafx.fxml;
    exports com.example.helojavafx;
}