module org.example.therapycenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jakarta.persistence;
    requires static lombok;

    opens org.example.therapycenter.controller to javafx.fxml;
    opens org.example.therapycenter to javafx.fxml;
    exports org.example.therapycenter;
}