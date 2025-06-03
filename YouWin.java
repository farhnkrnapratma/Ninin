// SPDX-License-Identifier: MIT
import greenfoot.*;

/**
 * YouWin is a visual actor displayed when the player wins the game.
 * It shows a large "You Win" image on the screen.
 */
public class YouWin extends Actor {

    // Constructor: scale the default image to a larger size
    public YouWin() {
        GreenfootImage img = getImage();
        img.scale(280, 140); // Resize image to 280x140 pixels
        setImage(img);
    }
}
