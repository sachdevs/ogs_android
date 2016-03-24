package com.sachdevs.igs.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by sakshamsachdev on 3/23/16.
 */
public class Square extends Sprite{

    private Coordinates coordinates;

    public Square(Texture texture) {
        super(texture);
        coordinates = new Coordinates(-1, -1);
    }

    public Square(Sprite sprite) {
        set(sprite);
        coordinates = new Coordinates(-1, -1);
    }

    public void setCoordinates(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


    public static float xTrans(float x)
    {
        return x*Gdx.graphics.getWidth()/480;
    }

    public static float yTrans(float y)
    {
        return y*Gdx.graphics.getHeight()/320;
    }

    private boolean isTouched;

    /**
     * Type: Input Listener function
     * listen if this sprite button was pressed (touched)
     * @param marge : the extra touchable space out of sprite
     * @param x     : x position touched by user
     * @param y     : y position touched by user
     *
     * return true  : Sprite touched
     * return false : Sprite not touched
     */
    public boolean isPressing(int marge,int x, int y) {
        if((x>getX() -xTrans(marge))&& x<getX() +getWidth()+xTrans(marge)) {
            if((y>getY() -yTrans(marge))&& y<getY()+getHeight()+yTrans(marge)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTouched() {
        return isTouched;
    }
}
