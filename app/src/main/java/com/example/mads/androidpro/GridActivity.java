package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
//        GridView grid = (GridView) findViewById(R.id.gridView);
        ArrayList<Button> btns = new ArrayList<>();
        Button b = new Button(this);
        Button b1 = new Button(this);
        btns.add(0, b);
        btns.add(1, b1);

        TableLayout layout = (TableLayout) findViewById(R.id.tablelayout);
        


//        ArrayAdapter<Button> adapt = new ArrayAdapter<Button>(this, R.layout.grid_layout, R.id.button, btns);
//        grid.setAdapter(adapt);

        for (int i = 0; i < btns.size(); i++) {
            btns.get(i).setText("Button " + i);

        }

    }
}