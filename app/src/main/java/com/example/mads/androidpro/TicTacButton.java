package com.example.mads.androidpro;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Gamer on 19-02-2016.
 */
public class TicTacButton extends Button{
    int state = 0;


    public TicTacButton(Context context, int state){
        super(context);
        this.state = state;

        setTextSize(15);
        setWidth(100);
        setHeight(100);

        if(state == 0){
            setText(" ");
        }
        if(state == 1){
            setText("X");
        }
        if(state == 2){
            setText("O");
        }
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
