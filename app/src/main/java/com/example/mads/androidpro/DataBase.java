package com.example.mads.androidpro;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        myDB = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.input_name);
        addDataBtn = (Button) findViewById(R.id.button_add);
        addData();


    }

    public void addData(){
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editName.getText().toString());
                if(isInserted == true){
                    Toast.makeText(DataBase.this, "Data Inserted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(DataBase.this, "Unsuccesful", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
