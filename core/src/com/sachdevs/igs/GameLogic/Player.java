package com.sachdevs.igs.GameLogic;

import com.sachdevs.igs.Utils.Color;

/**
 * Created by sakshamsachdev on 3/23/16.
 */
public class Player {
    private Color color;
    private boolean isTurn;

    public Player(Color color) {
        this.color = color;
        isTurn = false;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public boolean getTurn() {
        return isTurn;
    }

    public Color getColor() {
        return color;
    }
}
