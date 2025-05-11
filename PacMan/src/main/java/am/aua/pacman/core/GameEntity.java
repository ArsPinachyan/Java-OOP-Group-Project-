package am.aua.pacman.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public abstract class GameEntity {
    protected int x;
    protected int y;
    protected int direction;
    protected int new_direction;
    protected int animation_count;
    protected int[] animation_state;
    protected WritableImage[][] images;
    protected Image current_image;
    protected PathController pc;

    public GameEntity(WritableImage[][] images, int x, int y){
        this.x = x;
        this.y = y;
        this.images = images;
        current_image = images[direction][0];
        animation_state = new int[2];
        pc = new PathController();
    }

    public void Play(){
        Animation();
        Move();
    }

    public void Animation(){
        animation_count++;
        if (animation_count == 3){
            animation_count = 0;
            if (animation_state[1] == images[1].length - 1)
                animation_state[1] = 0;
            else
                animation_state[1]++;
            current_image = images[animation_state[0]][animation_state[1]];
        }
    }

    public void Move(){
        if (x < 25)
            x = 680;
        else if(x > 680)
            x = 25;

        if (direction == 0)
            x += 5;
        else if (direction == 1)
            x -= 5;
        else if (direction == 2)
            y -= 5;
        else
            y += 5;
    }

    public void Render(GraphicsContext gc){
        gc.drawImage(current_image, x, y);
    }

    public int GetX(){ return x; }
    public int GetY(){ return y; }
    public int GetDirection(){ return direction; }
}
