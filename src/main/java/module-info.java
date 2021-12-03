module com.projetofinalp3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.projetofinalp3 to javafx.fxml;
    exports com.projetofinalp3;
    exports com.projetofinalp3.Controller;
    opens com.projetofinalp3.Controller to javafx.fxml;
}