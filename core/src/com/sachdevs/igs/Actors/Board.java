package com.sachdevs.igs.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sachdevs.igs.Utils.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sakshamsachdev on increment/2increment/16.
 */
public class Board extends Actor implements InputProcessor{
    public static final int MARGIN = 10;

    int boardWidthPx;
    int width;
    List<Square> squares;
    Map<String, Texture> textureMap;

    public Board(int width, Map<String, Texture> textureMap) {
        // Init board data
        boardWidthPx = Gdx.graphics.getWidth()-MARGIN;
        this.width = width;
        this.textureMap = textureMap;
        squares = new ArrayList<Square>();
        InputMultiplexer im = new InputMultiplexer();

        for(int y = 0; y < width; y++) {
            for (int x = 0; x < width; x++) {
                final Square sq;
                float xloc = (x * (boardWidthPx - Board.MARGIN) / width) + Board.MARGIN;
                float yloc = (y * (boardWidthPx - Board.MARGIN) / width) + Gdx.graphics.getHeight() - boardWidthPx;
                if (x == 0 && y == 0) {
                    sq = new Square(textureMap.get("bottomLeftCorner"));
                } else if (x == 0 && y == width - 1) {
                    sq = new Square(textureMap.get("topLeftCorner"));
                } else if (x == width - 1 && y == 0) {
                    sq = new Square(textureMap.get("bottomRightCorner"));
                } else if (x == width - 1 && y == width - 1) {
                    sq = new Square(textureMap.get("topRightCorner"));
                } else if (isStarPoint(x, y)) {
                    sq = new Square(textureMap.get("starPoint"));
                } else if (x == 0) {
                    sq = new Square(textureMap.get("leftEdge"));
                } else if (x == width - 1) {
                    sq = new Square(textureMap.get("rightEdge"));
                } else if (y == 0) {
                    sq = new Square(textureMap.get("bottomEdge"));
                } else if (y == width - 1) {
                    sq = new Square(textureMap.get("topEdge"));
                } else {
                    sq = new Square(textureMap.get("square"));
                }
                sq.setX(xloc);
                sq.setY(yloc);
                sq.setCoordinates(x, 18-y);
                squares.add(sq);
                InputAdapter ia = new InputAdapter() {
                    @Override
                    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                        return false;
                    }

                    @Override
                    public boolean touchDown(int x, int yy, int pointer, int button) {
                        int y = Gdx.graphics.getHeight() - yy;
                        // if sprite is touched
                        if(sq.isPressing(0, x, y)) {
                            System.out.println("X Y");
                            System.out.println(sq.getCoordinates().getX());
                            System.out.println(sq.getCoordinates().getY());
                            System.out.println();
                        }
                        return false;
                    }
                };
                im.addProcessor(ia);
            }
        }
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureMap.get("kaya"), 0, Gdx.graphics.getHeight()-boardWidthPx, boardWidthPx+MARGIN, boardWidthPx+MARGIN);
        float sqsize = boardWidthPx/width;
        for (Square s : squares)
            batch.draw(s, s.getX(), s.getY(), sqsize, sqsize);
    }

    private boolean isStarPoint(int x, int y) {
        int factor = 6;
        if (width == 9) {
            factor = 4;
            if (x == 4 && y == 4) {
                return true;
            }
        }
        int increment = (width-1)/factor;
        int twoinc = increment*2;
        if((x == increment && y == increment)
                || (x == increment && y == increment+twoinc)
                || (x == increment && y == increment+(twoinc*2))
                || (x == increment+twoinc && y == increment)
                || (x == increment+twoinc && y == increment+twoinc)
                || (x == increment+twoinc && y == increment+(twoinc*2))
                || (x == increment+(twoinc*2) && y == increment)
                || (x == increment+(twoinc*2) && y == increment+twoinc)
                || (x == increment+(twoinc*2) && y == increment+(twoinc*2))
                ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

