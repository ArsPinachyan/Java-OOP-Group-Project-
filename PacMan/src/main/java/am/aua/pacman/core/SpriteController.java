package am.aua.pacman.core;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class SpriteController {
    Image characters = new Image(getClass().getResourceAsStream("/Sprites/characters.png"));

    public WritableImage[][] GetPacManIMG(){
        WritableImage[][] pacman_img = new WritableImage[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                pacman_img[i][j] = new WritableImage(characters.getPixelReader(), j * 48, i * 48, 48, 48);
            }
            pacman_img[i][2] = new WritableImage(characters.getPixelReader(), 96, 0, 48, 48);
            pacman_img[i][3] = new WritableImage(characters.getPixelReader(), 48, 48 * i, 48, 48);
        }
        return pacman_img;
    }

    public WritableImage[][] GetGhostIMG(int Y){
        WritableImage[][] ghost_img = new WritableImage[4][2];
        for (int i = 0; i < 4; i++) {
            ghost_img[i][0] = new WritableImage(characters.getPixelReader(), i * 2 * 48, Y, 48, 48);
            ghost_img[i][1] = new WritableImage(characters.getPixelReader(), (i * 2 + 1) * 48, Y, 48, 48);
        }
        return ghost_img;
    }

    public WritableImage[][] GetRedGhostIMG(){ return GetGhostIMG(192); }
    public WritableImage[][] GetPinkGhostIMG(){ return GetGhostIMG(240); }
    public WritableImage[][] GetBlueGhostIMG(){ return GetGhostIMG(288); }
    public WritableImage[][] GetOrangeGhostIMG(){ return GetGhostIMG(336); }

    public Image GetDotIMG(){
        return new WritableImage(characters.getPixelReader(), 48, 384, 48, 48);
    }
    public Image GetBigDotIMG(){
        return new WritableImage(characters.getPixelReader(), 0, 384, 48, 48);
    }
}
