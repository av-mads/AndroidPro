package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Buttons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        ArrayList<Button> btns = new ArrayList<>();

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btns.add(0, btn1);
        btns.add(1, btn2);
        btns.add(2, btn3);

        for (int i = 0; i < btns.size(); i++) {
//            btns.get(i).setMinimumWidth(200);

            btns.get(i).setMinWidth(200);
            btns.get(i).setOnClickListener(clickListen(btns.get(i)));
        }

    }

    View.OnClickListener clickListen(final Button button){
        return new View.OnClickListener() {
            public void onClick(View v) {
                button.setText("BLA");
            }
        };

    }
}
