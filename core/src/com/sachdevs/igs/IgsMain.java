package com.sachdevs.igs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sachdevs.igs.Actors.Board;
import com.sachdevs.igs.GameLogic.State;

public class IgsMain extends ApplicationAdapter {
	SpriteBatch batch;
    static Board board;
    Camera camera;
    State state;

	@Override
	public void create () {
		batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth()-10, Gdx.graphics.getWidth()-10);
        board = new Board(19);
        state = new State(board);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        board.draw(batch, 0);
		batch.end();
	}
}
