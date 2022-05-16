module com.example.boarding_pass_ticket {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.boarding_pass_ticket to javafx.fxml;
    exports com.example.boarding_pass_ticket;
}