package am.aua.pacman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import am.aua.pacman.core.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 750, 850, Color.BLACK);
        Canvas canvas = new Canvas(750, 850);

        stage.setTitle("PacMan");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/am/aua/pacman/Sprites/icon.png")));
        stage.setResizable(false);
        stage.setScene(scene);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setImageSmoothing(false);
        gc.setFill(javafx.scene.paint.Color.WHITE);
        gc.setFont(Font.loadFont(getClass().getResourceAsStream("/am/aua/pacman/font.otf"), 30));

        root.getChildren().add(canvas);
        stage.show();

        PacManGame pacman = new PacManGame(gc, scene);
        pacman.StartGameLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
