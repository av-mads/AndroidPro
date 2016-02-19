package com.example.mads.androidpro;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mads on 19-02-2016.
 */
public class ButtonClass extends Button {

    public ButtonClass(Context context) {
        super(context);
        setText("Personal Button");
        setWidth(100);
        setHeight(100);
    }
}
