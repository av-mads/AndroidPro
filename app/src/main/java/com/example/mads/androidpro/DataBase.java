package com.example.mads.androidpro;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataBase extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText editName;
    Button addDataBtn;
    Button viewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        myDB = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.input_name);
        viewAll = (Button) findViewById(R.id.button_view);
        addDataBtn = (Button) findViewById(R.id.button_add);
        addData();
        viewAll();
    }

    public void addData(){
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editName.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(DataBase.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DataBase.this, "Unsuccesful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll(){
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDB.getAllData();
                if(res.getCount() == 0){
                    // show message if database is empty
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("id : "+res.getString(0) + "\n");
                    buffer.append("name : "+res.getString(1) + "\n\n");

                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}
