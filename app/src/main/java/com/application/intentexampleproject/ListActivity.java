package com.application.intentexampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView myListView;


    //Todo STEP 1:  Create an Array

    String list[] = {"Item 1", "Item 2", "Item 3" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myListView = findViewById(R.id.listView);

        //Todo STEP 2: Create Array Adapter , setAdapter
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
        myListView.setAdapter(arrayAdapter);


        //Todo STEP 3: setItemOnClickListener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = arrayAdapter.getItem(position);
                Toast.makeText(ListActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });




    }
}