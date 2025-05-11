package am.aua.pacman.core;
import javafx.scene.image.WritableImage;

public class Ghost extends GameEntity{

    private int turn_coordinate;

    public Ghost(WritableImage[][] images, int x, int y) {
        super(images, x, y);
        SetDirection();
    }


    @Override
    public void Move(){
        if (direction == 0){
            x += 3;
            if (turn_coordinate <= x){
                SetDirection();
            }
        }
        else if (direction == 1) {
            x -= 3;
            if (turn_coordinate >= x){
                SetDirection();
            }
        }
        else if (direction == 2){
            y -= 3;
            if (turn_coordinate >= y){
                SetDirection();
            }
        }
        else{
            y += 3;
            if (turn_coordinate <= y){
                SetDirection();
            }
        }
    }

    public boolean TouchedPacMan(int pacman_x, int pacman_y, int pacman_direction){
        if (Math.abs(x - pacman_x) < 25 && Math.abs(y - pacman_y) < 25){ return true; }
        else { return false; }
    }


    public void SetDirection() {
        do {
            new_direction = (int) (Math.random() * 4);
        } while (!pc.TurnValidityCheck(direction, new_direction, x, y));

        direction = new_direction;
        x = pc.GetNewX();
        y = pc.GetNewY();
        animation_state[0] = direction;
        current_image = images[animation_state[0]][animation_state[1]];
        turn_coordinate = pc.DetermineNewPath(direction, x, y);
    }
}