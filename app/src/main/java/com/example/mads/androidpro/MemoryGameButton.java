package com.example.mads.androidpro;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Gamer on 23-02-2016.
 */
public class MemoryGameButton extends Button{
    int state;

    public MemoryGameButton(Context context){
        super(context);

    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public MemoryGameButton(Context context, int state){
        super(context);
        state = this.state;
        setText(""+state);
    }
}
