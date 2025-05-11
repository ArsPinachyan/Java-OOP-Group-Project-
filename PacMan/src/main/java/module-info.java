module am.aua.pacman {
    requires javafx.controls;
    requires javafx.fxml;


    opens am.aua.pacman to javafx.fxml;
    exports am.aua.pacman;
}