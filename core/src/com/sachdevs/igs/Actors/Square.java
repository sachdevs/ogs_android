package com.sachdevs.igs.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sachdevs.igs.Utils.Coordinates;

/**
 * Created by sakshamsachdev on 3/23/16.
 */
public class Square extends Actor {
    Coordinates coordinates;

    Sprite square;
    Sprite topEdge;
    Sprite topLeftCorner;
    Sprite topRightCorner;
    Sprite rightEdge;
    Sprite leftEdge;
    Sprite bottomEdge;
    Sprite bottomLeftCorner;
    Sprite bottomRightCorner;
    Sprite starPoint;
    
    float sqsize;
    float boardWidthPx;
    int width;

    public Square(int x, int y, float sqsize, float boardWidthPx, int width) {
        this.coordinates = new Coordinates(x, y);

        // Init sprites
        square = new Sprite(new Texture("square.png"));
        topEdge = new Sprite(new Texture("top_edge_square.png"));
        topLeftCorner = new Sprite(new Texture("top_left_corner.png"));
        topRightCorner = new Sprite(new Texture("top_right_corner.png"));
        rightEdge = new Sprite(new Texture("right_edge_square.png"));
        leftEdge = new Sprite(new Texture("left_edge_square.png"));
        bottomEdge = new Sprite(new Texture("bottom_edge_square.png"));
        bottomLeftCorner = new Sprite(new Texture("bottom_left_corner.png"));
        bottomRightCorner = new Sprite(new Texture("bottom_right_corner.png"));
        starPoint = new Sprite(new Texture("star_square.png"));
        
        this.sqsize = sqsize;
        this.boardWidthPx = boardWidthPx;
        this.width = width;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float xloc = (coordinates.getX() * (boardWidthPx-Board.MARGIN)/width) + Board.MARGIN;
        float yloc = (coordinates.getY() * (boardWidthPx-Board.MARGIN)/width) + Gdx.graphics.getHeight()-boardWidthPx;
        if (coordinates.getX() == 0 && coordinates.getY() == 0) {
            batch.draw(bottomLeftCorner, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getX() == 0 && coordinates.getY() == width-1) {
            batch.draw(topLeftCorner, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getX() == width-1 && coordinates.getY() == 0) {
            batch.draw(bottomRightCorner, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getX() == width-1 && coordinates.getY() == width-1) {
            batch.draw(topRightCorner, xloc, yloc, sqsize, sqsize);
        } else if (isStarPoint(coordinates.getX(), coordinates.getY(), width)) {
            batch.draw(starPoint, xloc, yloc, sqsize, sqsize);
        }
        else if (coordinates.getX() == 0) {
            batch.draw(leftEdge, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getX() == width-1) {
            batch.draw(rightEdge, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getY() == 0) {
            batch.draw(bottomEdge, xloc, yloc, sqsize, sqsize);
        } else if (coordinates.getY() == width-1) {
            batch.draw(topEdge, xloc, yloc, sqsize, sqsize);
        } else {
            batch.draw(square, xloc, yloc, sqsize, sqsize);
        }
    }

    private boolean isStarPoint(int x, int y, int width) {
        int factor = 6;
        if (width == 9) {
            factor = 4;
            if (coordinates.getX() == 4 && coordinates.getY() == 4) {
                return true;
            }
        }
        int increment = (width-1)/factor;
        int twoinc = increment*2;
        if((coordinates.getX() == increment && coordinates.getY() == increment)
                || (coordinates.getX() == increment && coordinates.getY() == increment+twoinc)
                || (coordinates.getX() == increment && coordinates.getY() == increment+(twoinc*2))
                || (coordinates.getX() == increment+twoinc && coordinates.getY() == increment)
                || (coordinates.getX() == increment+twoinc && coordinates.getY() == increment+twoinc)
                || (coordinates.getX() == increment+twoinc && coordinates.getY() == increment+(twoinc*2))
                || (coordinates.getX() == increment+(twoinc*2) && coordinates.getY() == increment)
                || (coordinates.getX() == increment+(twoinc*2) && coordinates.getY() == increment+twoinc)
                || (coordinates.getX() == increment+(twoinc*2) && coordinates.getY() == increment+(twoinc*2))
                ) {
            return true;
        }
        return false;
    }
}
