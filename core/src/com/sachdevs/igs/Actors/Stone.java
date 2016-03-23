package com.sachdevs.igs.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sachdevs.igs.Utils.Color;
import com.sachdevs.igs.Utils.Coordinates;

/**
 * Created by sakshamsachdev on 3/23/16.
 */
public class Stone extends Actor {
    private Color color;
    private Sprite stone;
    private Coordinates loc;

    public Stone(Color color, int x, int y) {
        this.color = color;
        if(Color.WHITE == color) {
            stone = new Sprite(new Texture("white.png"));
        } else if (Color.BLACK == color) {
            stone = new Sprite(new Texture("black.png"));
        }
        this.loc = new Coordinates(x, y);
    }

    public Coordinates getCoordinates() {
        return loc;
    }

    public Color getStoneColor(){
        return color;
    }
}
