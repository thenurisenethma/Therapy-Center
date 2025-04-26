module org.example.therapycenter {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;

    opens org.example.therapycenter.controller to javafx.fxml;
    opens org.example.therapycenter to javafx.fxml;
    opens org.example.therapycenter.entity to org.hibernate.orm.core;
    exports org.example.therapycenter;
}