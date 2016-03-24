package com.sachdevs.igs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sachdevs.igs.Actors.Board;
import com.sachdevs.igs.GameLogic.State;

import java.util.HashMap;
import java.util.Map;

public class IgsMain extends ApplicationAdapter {
	SpriteBatch batch;
    static Board board;
    State state;
    AssetManager manager = new AssetManager();
    Map<String, Texture> textureMap;

	@Override
	public void create () {
        load();
        Gdx.graphics.setContinuousRendering(false);
		batch = new SpriteBatch();
        board = new Board(19, textureMap);
        state = new State(board);


        //Gdx.graphics.requestRendering();
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        board.draw(batch, 0);
        batch.draw(textureMap.get("bottomLeftCorner"), 2, 2, 100,100);
        batch.end();
	}

    public void load() {
        manager.load("black.png", Texture.class);
        manager.load("bottom_edge_square.png", Texture.class);
        manager.load("bottom_left_corner.png", Texture.class);
        manager.load("bottom_right_corner.png", Texture.class);
        manager.load("kaya.jpg", Texture.class);
        manager.load("left_edge_square.png", Texture.class);
        manager.load("right_edge_square.png", Texture.class);
        manager.load("square.png", Texture.class);
        manager.load("star_square.png", Texture.class);
        manager.load("top_edge_square.png", Texture.class);
        manager.load("top_left_corner.png", Texture.class);
        manager.load("top_right_corner.png", Texture.class);
        manager.load("white.png", Texture.class);
        manager.finishLoading();

        textureMap = new HashMap<String, Texture>();

        textureMap.put("square", manager.get("square.png", Texture.class));
        textureMap.put("topEdge", manager.get("top_edge_square.png", Texture.class));
        textureMap.put("topLeftCorner", manager.get("top_left_corner.png", Texture.class));
        textureMap.put("topRightCorner", manager.get("top_right_corner.png", Texture.class));
        textureMap.put("rightEdge", manager.get("right_edge_square.png", Texture.class));
        textureMap.put("leftEdge", manager.get("left_edge_square.png", Texture.class));
        textureMap.put("bottomEdge", manager.get("bottom_edge_square.png", Texture.class));
        textureMap.put("bottomLeftCorner", manager.get("bottom_left_corner.png", Texture.class));
        textureMap.put("bottomRightCorner", manager.get("bottom_right_corner.png", Texture.class));
        textureMap.put("starPoint", manager.get("star_square.png", Texture.class));
        textureMap.put("kaya", manager.get("kaya.jpg", Texture.class));
        textureMap.put("whiteStone", manager.get("white.png", Texture.class));
        textureMap.put("blackStone", manager.get("black.png", Texture.class));
    }
}
