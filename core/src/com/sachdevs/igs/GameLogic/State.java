package com.sachdevs.igs.GameLogic;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.sachdevs.igs.Actors.Board;
import com.sachdevs.igs.Utils.Color;

/**
 * Created by sakshamsachdev on 3/23/16.
 */
public class State {
    Player player1;
    Player player2;
    Board board;

    public State(Board board) {
        player1 = new Player(Color.BLACK);
        player2 = new Player(Color.WHITE);
        player1.setTurn(true);
        this.board = board;

        init();
    }

    private void init() {
        board.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("down");
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("up");
            }
        });
    }
}
