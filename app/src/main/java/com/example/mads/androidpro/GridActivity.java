package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {
    final int totalBtns = 9;
    final int btnsRow = 3;
    Button[] btn = new Button[9];
    int turn = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grid);
//        GridView grid = (GridView) findViewById(R.id.gridView);
        ArrayList<Button> btns = new ArrayList<>();


        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        TableRow tr1 = new TableRow(this);
        tr1.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        TableRow tr2 = new TableRow(this);
        tr1.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));




        for (int i = 0; i < totalBtns ; i++) {
            btn[i] = new Button(this);
            if(i < btnsRow){
                tr.addView(btn[i]);
            }
            if(i >= btnsRow && i < btnsRow*2){
                tr1.addView(btn[i]);
            }

            if(i>= btnsRow*2 && i < btnsRow*3){
                tr2.addView(btn[i]);
            }
        }

        resetField();

        if(btn[0].getText().equals("O")){
            System.out.println("Test");
        }

        TableLayout layout = (TableLayout) findViewById(R.id.tablelayout);

        layout.addView(tr, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        layout.addView(tr1, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        layout.addView(tr2, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));


//        ArrayAdapter<Button> adapt = new ArrayAdapter<Button>(this, R.layout.grid_layout, R.id.button, btns);
//        grid.setAdapter(adapt);

    }

    View.OnClickListener clickListen(final Button button, final int id){
        return new View.OnClickListener() {
            public void onClick(View v) {
                turn++;
                if(turn%2 == 0) {
                    button.setText("X" + id);
                }
                else{
                    button.setText("O" + id);
                }
            }
        };

    }

    public void resetField(){
        for (int i = 0; i < totalBtns; i++) {
            btn[i].setMinimumWidth(200);
            btn[i].setText("Button " + (i+1));
            btn[i].setOnClickListener(clickListen(btn[i], i));
        }
    }
}
