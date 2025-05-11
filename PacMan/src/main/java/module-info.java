module am.aua.pacman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens am.aua.pacman to javafx.fxml;
    exports am.aua.pacman;
}