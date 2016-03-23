package com.sachdevs.igs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IgsMain extends ApplicationAdapter {
	SpriteBatch batch;
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
    Sprite wood;
    Camera camera;
    float boardWidth;

	@Override
	public void create () {
        boardWidth = Gdx.graphics.getWidth()-10;
		batch = new SpriteBatch();

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
        wood = new Sprite(new Texture("kaya.jpg"));

        camera = new OrthographicCamera(Gdx.graphics.getWidth()-10, Gdx.graphics.getWidth()-10);
	}

	@Override
	public void render () {
        int offset = 10;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(wood, 0, Gdx.graphics.getHeight()-boardWidth, boardWidth+10, boardWidth+10);
        for(int y = 0; y < 19; y++){
            for(int x = 0; x < 19; x++){
                float xloc = (x * (boardWidth-offset)/19) + offset;
                float yloc = (y * (boardWidth-offset)/19) + Gdx.graphics.getHeight()-boardWidth;
                if (x == 0 && y == 0) {
                    batch.draw(bottomLeftCorner, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (x == 0 && y == 18) {
                    batch.draw(topLeftCorner, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (x == 18 && y == 0) {
                    batch.draw(bottomRightCorner, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (x == 18 && y == 18) {
                    batch.draw(topRightCorner, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if ((x == 3 && y == 3)
                        || (x == 3 && y == 9)
                        || (x == 3 && y == 15)
                        || (x == 9 && y == 3)
                        || (x == 9 && y == 9)
                        || (x == 9 && y == 15)
                        || (x == 15 && y == 3)
                        || (x == 15 && y == 9)
                        || (x == 15 && y == 15)
                        ) {
                    batch.draw(starPoint, xloc, yloc, boardWidth/19, boardWidth/19);
                }
                else if (x == 0) {
                    batch.draw(leftEdge, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (x == 18) {
                    batch.draw(rightEdge, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (y == 0) {
                    batch.draw(bottomEdge, xloc, yloc, boardWidth/19, boardWidth/19);
                } else if (y == 18) {
                    batch.draw(topEdge, xloc, yloc, boardWidth/19, boardWidth/19);
                } else {
                    batch.draw(square, xloc, yloc, boardWidth/19, boardWidth/19);
                }
            }
        }
		batch.end();
	}
}
