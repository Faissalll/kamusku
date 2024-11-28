module org.example.kamusfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.kamusfx to javafx.fxml;
    exports org.example.kamusfx;
}