package com.example.mads.androidpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> activities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        activities.add(0, "Buttons");

        for (int i = 1; i < 20; i++) {
            activities.add(i, "Empty Activity");
        }

        ListView list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_main, R.id.text_list_main, activities);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id == 0){
                    goToScene(Buttons.class);
                }
            }
        });

    }

    private void goToScene(Class<Buttons> c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
