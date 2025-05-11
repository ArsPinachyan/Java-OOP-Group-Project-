package am.aua.pacman.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Dots {
    private int[][] dots_paths_X;
    private int[][] dots_paths_Y;
    private int[][] dots_intersections;
    private int score;

    private Image dot_image;

    public Dots(Image dot_image){
        this.dot_image = dot_image;
        score = 0;


        dots_paths_X = new int[][]{
                {81,  77, 100, 125, 149, 197, 221, 245, 269, 293, 412, 436, 461, 484, 508, 556, 580, 605, 628},
                {176, 77, 100, 125, 149, 197, 221, 245, 269, 293, 341, 365, 412, 436, 461, 484, 508, 556, 580, 605, 628},
                {248, 77, 100, 125, 149, 269, 293, 412, 436, 556, 580, 605, 628},
                {537, 77, 100, 125, 149, 197, 221, 269, 293, 412, 436, 484, 508, 556, 580, 605, 628},
                {609, 77, 197, 221, 269, 293, 412, 436, 484, 508, 628},
                {681, 77, 125, 149, 269, 293, 412, 436, 556, 580, 628},
                {753, 77, 100, 125, 149, 173, 197, 221, 245, 269, 293, 341, 365, 412, 436, 461, 484, 508, 533, 556, 580, 605, 628}
        };

        dots_paths_Y = new int[][]{
                {53, 105, 129, 153, 201, 225, 561, 585, 705, 729},
                {100, 633, 657},
                {173, 105, 129, 153, 201, 225, 272, 296, 320, 344, 368, 416, 440, 465, 488, 512, 561, 585, 633, 657},
                {245, 201, 225, 633, 657},
                {317, 105, 129, 153, 561, 585, 705, 729},
                {388, 105, 129, 153, 561, 585, 705, 729},
                {461, 201, 225, 633, 657},
                {533, 105, 129, 153, 201, 225, 272, 296, 320, 344, 368, 416, 440, 465, 488, 512, 561, 585, 633, 657},
                {605, 633, 657},
                {653, 105, 129, 153, 201, 225, 561, 585, 705, 729}
        };

        dots_intersections = new int[][]{
                {53, 81}, {173, 81}, {317, 81}, {388, 81}, {533, 81}, {653, 81},
                {53, 176}, {173, 176}, {317, 176}, {388, 176}, {533, 176}, {653, 176},
                {53, 248}, {173, 248}, {245, 248}, {317, 248}, {388, 248}, {461, 248}, {533, 248}, {653, 248},
                {173, 392}, {533, 392},
                {53, 537}, {173, 537}, {245, 537}, {317, 537}, {388, 537}, {461, 537}, {533, 537}, {653, 537},
                {53, 609}, {100, 609}, {173, 609}, {245, 609}, {317, 609}, {388, 609}, {461, 609}, {533, 609}, {605, 609}, {653, 609},
                {53, 681}, {100, 681}, {173, 681}, {245, 681}, {317, 681}, {388, 681}, {461, 681}, {533, 681}, {605, 681}, {653, 681},
                {53, 753}, {317, 753}, {388, 753}, {653, 753}
        };
    }

    public void Render(GraphicsContext gc){
        for (int i = 0; i < dots_paths_X.length; i++){
            for (int j = 1; j < dots_paths_X[i].length; j++){
                gc.drawImage(dot_image, dots_paths_X[i][j], dots_paths_X[i][0]);
            }
        }
        for (int i = 0; i < dots_paths_Y.length; i++){
            for (int j = 1; j < dots_paths_Y[i].length; j++){
                gc.drawImage(dot_image, dots_paths_Y[i][0], dots_paths_Y[i][j]);
            }
        }
        for (int i = 0; i < dots_intersections.length; i++){
            gc.drawImage(dot_image, dots_intersections[i][0], dots_intersections[i][1]);
        }
    }

    public void СheckСonsumedDots(int X, int Y, int dir){
        if (dir == 0 || dir == 1){
            for (int i = 0; i < dots_paths_X.length; i++){
                if (Y == dots_paths_X[i][0]){
                    for (int j = 1; j < dots_paths_X[i].length; j++){
                        if (Math.abs(X - dots_paths_X[i][j]) < 10){
                            dots_paths_X[i][j] = -50;
                            score += 10;
                        }
                    }
                }
            }
            for (int i = 0; i < dots_intersections.length; i++){
                if (dots_intersections[i][1] == Y){
                    if (Math.abs(X - dots_intersections[i][0]) < 15){
                        dots_intersections[i][0] = -50;
                        score += 10;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < dots_paths_Y.length; i++){
                if (X == dots_paths_Y[i][0]){
                    for (int j = 1; j < dots_paths_Y[i].length; j++){
                        if (Math.abs(Y - dots_paths_Y[i][j]) < 10){
                            dots_paths_Y[i][j] = -50;
                            score += 10;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < dots_intersections.length; i++){
            if (dots_intersections[i][0] == X){
                if (Math.abs(Y - dots_intersections[i][1]) < 15){
                    dots_intersections[i][1] = -50;
                    score += 10;
                }
            }
        }
    }

    public int getScore(){ return score; }
}