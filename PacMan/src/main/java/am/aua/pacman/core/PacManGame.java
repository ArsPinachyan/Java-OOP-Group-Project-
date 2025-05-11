package am.aua.pacman.core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PacManGame {
    private GraphicsContext gc;
    private Scene scene;
    private SpriteController sc;

    private PacMan pacman;
    private Dots dots;
    private boolean pause;

    private Ghost red_ghost;
    private Ghost pink_ghost;
    private Ghost blue_ghost;
    private Ghost orange_ghost;

    private Image map = new Image(getClass().getResourceAsStream("/am/aua/pacman/Sprites/map.png"));


    public PacManGame(GraphicsContext gc, Scene scene){
        this.gc = gc;
        this.scene = scene;
        this.scene.setOnKeyPressed(this::handleKeyPress);

        sc = new SpriteController();
        pacman = new PacMan(sc.GetPacManIMG(), 352, 609);

        red_ghost = new Ghost(sc.GetRedGhostIMG(), 245, 320);
        pink_ghost = new Ghost(sc.GetPinkGhostIMG(), 317, 320);
        blue_ghost = new Ghost(sc.GetBlueGhostIMG(), 388, 320);
        orange_ghost = new Ghost(sc.GetOrangeGhostIMG(), 461, 320);

        dots = new Dots(sc.GetDotIMG());
    }

    public void GameLoop(){
        if (!pause){
            gc.clearRect(0, 0, 750, 850);
            gc.drawImage(map, 0, 64);

            pacman.Play();
            dots.СheckСonsumedDots(pacman.GetX(), pacman.GetY(), pacman.GetDirection());
            red_ghost.Play();
            pink_ghost.Play();
            blue_ghost.Play();
            orange_ghost.Play();

            pacman.Render(gc);
            dots.Render(gc);
            red_ghost.Render(gc);
            pink_ghost.Render(gc);
            blue_ghost.Render(gc);
            orange_ghost.Render(gc);

            gc.fillText("score:" + dots.getScore(), 30, 50);

            if (dots.getScore() >= 2440){
                pause = true;

                gc.setFill(javafx.scene.paint.Color.GREEN);
                gc.fillText("you won!", 280, 500);

                gc.setFill(Color.WHITE);
                gc.fillText("space to restart", 325, 50);
            }

            else if (red_ghost.TouchedPacMan(pacman.GetX(), pacman.GetY(), pacman.GetDirection())    ||
                     pink_ghost.TouchedPacMan(pacman.GetX(), pacman.GetY(), pacman.GetDirection())   ||
                     orange_ghost.TouchedPacMan(pacman.GetX(), pacman.GetY(), pacman.GetDirection()) ||
                     blue_ghost.TouchedPacMan(pacman.GetX(), pacman.GetY(), pacman.GetDirection())     )
            {
                pause = true;

                gc.setFill(javafx.scene.paint.Color.DARKRED);
                gc.fillText("you lost", 280, 500);

                gc.setFill(Color.WHITE);
                gc.fillText("space to restart", 325, 50);
            }
        }
    }

    public void StartGameLoop(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(30), e -> GameLoop())
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                pacman.SetNewDirection(2);
                break;
            case DOWN:
                pacman.SetNewDirection(3);
                break;
            case LEFT:
                pacman.SetNewDirection(1);
                break;
            case RIGHT:
                pacman.SetNewDirection(0);
                break;
            case W:
                pacman.SetNewDirection(2);
                break;
            case S:
                pacman.SetNewDirection(3);
                break;
            case A:
                pacman.SetNewDirection(1);
                break;
            case D:
                pacman.SetNewDirection(0);
                break;
            case SPACE:
                if (pause){
                    PacManGame pacman_game = new PacManGame(gc, scene);
                    pacman_game.StartGameLoop();
                }
                break;
        }
    }
}
