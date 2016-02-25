package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Random;

public class MemoryGame extends AppCompatActivity {
    int totalBtns = 8;
    MemoryGameButton[] btns = new MemoryGameButton[totalBtns];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        TableLayout layout = (TableLayout) findViewById(R.id.table_layout);



        TableRow tr1 = new TableRow(this);
        tr1.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));


        TableRow tr2 = new TableRow(this);
        tr2.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        int random;

        for (int i = 0; i < totalBtns; i++) {

            Random r = new Random();
            random = r.nextInt(8);
            if(i < 4){
               btns[i] = new MemoryGameButton(this, i);
                tr1.addView(btns[i]);
            }
            if(i >= 4){
                btns[i] = new MemoryGameButton(this, i);
                tr2.addView(btns[i]);
            }

        }

        layout.addView(tr1, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        layout.addView(tr2, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
    }
}
