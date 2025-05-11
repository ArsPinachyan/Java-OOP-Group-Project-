package am.aua.pacman.core;
import javafx.scene.image.WritableImage;

public class PacMan extends GameEntity {

    public PacMan(WritableImage[][] images, int x, int y){
        super(images, x, y);
    }

    @Override
    public void Play(){
        Animation();
        SetDirection();
        if (pc.MoveValidityCheck(direction, x, y)){
            Move();
        }
    }

    public void SetNewDirection(int new_direction){
        this.new_direction = new_direction;
    }

    public void SetDirection() {
        if (direction == new_direction) {
            return;
        }
        else if (direction + new_direction == 1 || direction + new_direction == 5) {
            direction = new_direction;
            animation_state[0] = direction;
            current_image = images[animation_state[0]][animation_state[1]];
            Move();
        }
        else if (pc.TurnValidityCheck(direction, new_direction, x, y)){
            direction = new_direction;
            animation_state[0] = direction;
            current_image = images[animation_state[0]][animation_state[1]];
            x = pc.GetNewX();
            y = pc.GetNewY();
            Move();
        }
    }
}