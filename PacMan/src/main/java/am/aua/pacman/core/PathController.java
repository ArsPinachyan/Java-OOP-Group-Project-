package am.aua.pacman.core;

public class PathController {
    private int[][] dirX_up;
    private int[][] dirX_down;
    private int[][] dirY_left;
    private int[][] dirY_right;

    private int[][] paths_X;
    private int[][] paths_Y;
    private int [][] intersection_points_X;
    private int [][] intersection_points_Y;

    private int newX;
    private int newY;

    public PathController() {
        dirX_up = new int[][]{
                {176, 53, 173, 317, 388, 533, 653},
                {248, 53, 173, 245, 461, 533, 653},
                {320, 317, 388},
                {392, 173, 245, 461, 533},
                {465, 173, 245, 461, 533},
                {537, 173, 245, 461, 533},
                {609, 53, 173, 317, 388, 533, 653},
                {681, 100, 173, 245, 461, 533, 605},
                {753, 53, 317, 388, 653}
        };

        dirX_down = new int[][]{
                {81, 53, 173, 317, 388, 533, 653},
                {176, 53, 173, 245, 461, 533, 653},
                {248, 173, 317, 388, 533},
                {320, 245, 461},
                {392, 173, 245, 461, 533},
                {465, 245, 461},
                {537, 53, 173, 317, 388, 533, 653},
                {609, 100, 173, 245, 461, 533, 605},
                {681, 53, 317, 388, 653}
        };

        dirY_left = new int[][]{
                {100, 609, 681},
                {173, 81, 176, 248, 392, 537, 681},
                {245, 176, 392, 537, 609},
                {317, 81, 176, 248, 320, 537, 609, 681, 753},
                {388, 176, 320, 609, 753},
                {461, 248, 176, 320, 465, 537, 609, 681},
                {533, 81, 176, 392, 537, 609},
                {605, 681},
                {653, 81, 176, 248, 537, 609, 681, 753}
        };

        dirY_right = new int[][]{
                {53, 81, 176, 248, 537, 609, 681, 753},
                {100, 681},
                {173, 81, 176, 392, 537, 609},
                {245, 176, 248, 320, 465, 537, 609, 681},
                {317, 176, 320, 609, 753},
                {388, 81, 176, 248, 320, 537, 609, 681, 753},
                {461, 176, 392, 537, 609,},
                {533, 81, 176, 248, 392, 537, 681},
                {605, 609, 681}
        };

        paths_X = new int[][]{
                {81, 53, 317, 388, 653},
                {176, 53, 653},
                {248, 53, 173, 245, 317, 388, 461, 533, 653},
                {320, 245, 461},
                {392, 20, 245, 461, 685},
                {465, 245, 461},
                {537, 53, 317, 388, 653},
                {609, 53, 100, 173, 533, 605, 653},
                {681, 53, 173, 245, 317, 388, 461, 533, 653},
                {753, 53, 653}
        };

        paths_Y = new int[][]{
                {53, 81, 248, 537, 609, 681, 753},
                {100, 609, 681},
                {173, 81, 681},
                {245, 176, 248, 320, 537, 609, 681},
                {317, 81, 176, 248, 320, 537, 609, 681, 753},
                {388, 81, 176, 248, 320, 537, 609, 681, 753},
                {461, 176, 248, 320, 537, 609, 681},
                {533, 81, 681},
                {605, 609, 681},
                {653, 81, 248, 537, 609, 681, 753}
        };

        intersection_points_X = new int[][]{
                {81, 53, 173, 317, 388, 533, 653},
                {176, 53, 173, 245, 317, 388, 461, 533, 653},
                {248, 53, 173, 245, 317, 388, 461, 533, 653},
                {320, 245, 317, 388, 461},
                {465, 245, 461},
                {537, 53, 173, 245, 317, 388, 461, 533, 653},
                {609, 53, 100, 173, 245, 317, 388, 461, 533, 605, 653},
                {681, 53, 100, 173, 245, 317, 388, 461, 533, 605, 653},
                {753, 53, 317, 388, 653}
        };

        intersection_points_Y = new int[][]{
                {53, 81, 176, 248, 537, 609, 681, 753},
                {100, 609, 681},
                {173, 81, 176, 248, 537, 609, 681},
                {245, 176, 248, 320, 465, 537, 609, 681},
                {317, 81, 176, 248, 320, 537, 609, 681, 753},
                {388, 81, 176, 248, 320, 537, 609, 681, 753},
                {461, 176, 248, 320, 465, 537, 609, 681},
                {533, 81, 176, 248, 537, 609, 681},
                {605, 609, 681},
                {653, 81, 176, 248, 537, 609, 681, 753}
        };
    }


    public boolean TurnValidityCheck(int current_direction, int new_direction, int x, int y){
        if (current_direction == 0 || current_direction == 1){
            if (new_direction == 2){
                for (int i = 0; i < dirX_up.length; i++){
                    if (y == dirX_up[i][0]){
                        for (int j = 1; j < dirX_up[i].length; j++){
                            if (Math.abs(dirX_up[i][j] - x) < 10){
                                newX = dirX_up[i][j];
                                newY = dirX_up[i][0];
                                return true;
                            }
                        }
                    }
                }
            }
            else if (new_direction == 3) {
                for (int i = 0; i < dirX_down.length; i++){
                    if (y == dirX_down[i][0]){
                        for (int j = 1; j < dirX_down[i].length; j++){
                            if (Math.abs(dirX_down[i][j] - x) < 10){
                                newX = dirX_down[i][j];
                                newY = dirX_down[i][0];
                                return true;
                            }
                        }
                    }
                }
            }
        }
        else {
            if (new_direction == 0){
                for (int i = 0; i < dirY_right.length; i++){
                    if (x == dirY_right[i][0]){
                        for (int j = 1; j < dirY_right[i].length; j++){
                            if (Math.abs(dirY_right[i][j] - y) < 10){
                                newX = dirY_right[i][0];
                                newY = dirY_right[i][j];
                                return true;
                            }
                        }
                    }
                }
            }
            else if (new_direction == 1) {
                for (int i = 0; i < dirY_left.length; i++){
                    if (x == dirY_left[i][0]){
                        for (int j = 1; j < dirY_left[i].length; j++){
                            if (Math.abs(dirY_left[i][j] - y) < 10){
                                newX = dirY_left[i][0];
                                newY = dirY_left[i][j];
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean MoveValidityCheck(int direction, int x, int y){
        if (direction == 0 || direction == 1){
            for (int i = 0; i < paths_X.length; i++){
                if (paths_X[i][0] == y){
                    for (int j = 1; j < paths_X[i].length; j += 2){
                        if (x >= paths_X[i][j] && x <= paths_X[i][j+1]){
                            return true;
                        }
                    }
                }
            }
        }
        else{
            for (int i = 0; i < paths_Y.length; i++){
                if (paths_Y[i][0] == x){
                    for (int j = 1; j < paths_Y[i].length; j += 2){
                        if (y >= paths_Y[i][j] && y <= paths_Y[i][j+1]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int DetermineNewPath(int direction, int x, int y){
        if (direction == 0){
            for (int i = 0; i < intersection_points_X.length; i++){
                if (intersection_points_X[i][0] == y){
                    for (int j = 1; j < intersection_points_X[i].length; j++){
                        if (intersection_points_X[i][j] == x){
                            return intersection_points_X[i][j+1];
                        }
                    }
                }
            }
        }
        else if (direction == 1){
            for (int i = 0; i < intersection_points_X.length; i++){
                if (intersection_points_X[i][0] == y){
                    for (int j = 1; j < intersection_points_X[i].length; j++){
                        if (intersection_points_X[i][j] == x){
                            return intersection_points_X[i][j-1];
                        }
                    }
                }
            }
        }
        else if (direction == 2){
            for (int i = 0; i < intersection_points_Y.length; i++){
                if (intersection_points_Y[i][0] == x){
                    for (int j = 1; j < intersection_points_Y[i].length; j++){
                        if (intersection_points_Y[i][j] == y){
                            return intersection_points_Y[i][j-1];
                        }
                    }
                }
            }
        }
        else {
            for (int i = 0; i < intersection_points_Y.length; i++){
                if (intersection_points_Y[i][0] == x){
                    for (int j = 1; j < intersection_points_Y[i].length; j++){
                        if (intersection_points_Y[i][j] == y){
                            return intersection_points_Y[i][j+1];
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int GetNewX(){ return newX; }
    public int GetNewY(){ return newY; }
}
