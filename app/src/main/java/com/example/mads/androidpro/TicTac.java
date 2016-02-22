package com.example.mads.androidpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

public class TicTac extends AppCompatActivity {

    int amountOfButttons = 9;
    int btnsRow = 3, turn = 0;
    TicTacButton[] btns = new TicTacButton[amountOfButttons];
    TableRow tr1, tr2, tr3;
    ArrayList<Integer> winningRow = new ArrayList<>();
    int[] a = new int[3];


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
            btns[i].setOnClickListener(clickListen(btns[i]));

            if(i < btnsRow){
                tr1.addView(btns[i]);
                System.out.println("test");
            }
            if(i >= btnsRow && i < btnsRow*2){
                tr2.addView(btns[i]);
            }

            if(i>= btnsRow*2 && i < btnsRow*3) {
                tr3.addView(btns[i]);
            }
        }
    }

    View.OnClickListener clickListen(final TicTacButton button){
        return new View.OnClickListener() {
            public void onClick(View v) {
                turn++;
                if(turn%2 == 0) {
                    button.setState(1);
                    button.setText("X");
                    checkRows(1);
                }
                else{
                    button.setState(2);
                    button.setText("O");
                    checkRows(2);
                }
            }
        };

    }

    public void checkRows(int state){

        if(btns[0].getState() == state && btns[1].getState() == state && btns[2].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }
        if(btns[3].getState() == state && btns[4].getState() == state && btns[5].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }
        if(btns[6].getState() == state && btns[7].getState() == state && btns[8].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }


        if(btns[0].getState() == state && btns[3].getState() == state && btns[6].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }
        if(btns[1].getState() == state && btns[4].getState() == state && btns[7].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }
        if(btns[2].getState() == state && btns[5].getState() == state && btns[8].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }

        if(btns[0].getState() == state && btns[4].getState() == state && btns[8].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }
        if(btns[2].getState() == state && btns[4].getState() == state && btns[6].getState() == state){
            Toast.makeText(TicTac.this, "Spillet er slut", Toast.LENGTH_LONG).show();
        }

    }
}
