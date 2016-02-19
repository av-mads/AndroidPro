package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class TicTac extends AppCompatActivity {

    int amountOfButttons = 9;
    int btnsRow = 3;
    TicTacButton[] btns = new TicTacButton[amountOfButttons];
    TableRow tr1, tr2, tr3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac);

        TableLayout board = (TableLayout)  findViewById(R.id.table_board);

        tr1 = new TableRow(this);
        tr1.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        board.addView(tr1, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        tr2 = new TableRow(this);
        tr2.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        board.addView(tr2, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        tr3 = new TableRow(this);
        tr3.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));
        board.addView(tr3, new TableLayout.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

        createButtons();


    }

    public void createButtons(){
        for (int i = 0; i < amountOfButttons; i++) {
            btns[i] = new TicTacButton(this, 0);
            if(i < btnsRow){
                tr1.addView(btns[i]);
            }
            if(i >= btnsRow && i < btnsRow*2){
                tr2.addView(btns[i]);
            }

            if(i>= btnsRow*2 && i < btnsRow*3){
                tr3.addView(btns[i]);
            }
        }
    }
}
