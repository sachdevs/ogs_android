package com.sachdevs.igs.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakshamsachdev on increment/2increment/16.
 */
public class Board extends Actor{
    public static final int MARGIN = 10;

    int boardWidthPx;
    int width;
    Sprite wood;
    List<List<Square>> gameBoard;
    Group squares = new Group();

    public Board(int width) {
        // Init board data
        boardWidthPx = Gdx.graphics.getWidth()-MARGIN;
        this.width = width;
        wood = new Sprite(new Texture("kaya.jpg"));
        gameBoard = new ArrayList<List<Square>>(19);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(wood, 0, Gdx.graphics.getHeight()-boardWidthPx, boardWidthPx+MARGIN, boardWidthPx+MARGIN);
        float sqsize = boardWidthPx/width;
        for(int y = 0; y < width; y++){
            List<Square> l = new ArrayList<Square>();
            for(int x = 0; x < width; x++){
                Square sq = new Square(x, y, sqsize, boardWidthPx, width);
                sq.draw(batch, 0);
                squares.addActor(sq);
                l.add(sq);
            }
            gameBoard.add(l);
        }
    }
}

