package com.application.intentexampleproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    //Todo STEP 1: Add a button Variable
    Button myButton, openBrowserButton;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Todo STEP 2: Link the button with ID
        myButton = findViewById(R.id.button);
        openBrowserButton = findViewById(R.id.buttonOpenBrowser);
        myEditText = findViewById(R.id.editTextTextPersonName);

        openBrowserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.deakin.edu.au"));
//                startActivity(intent);

                Intent secondActivityIntent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(secondActivityIntent);


//                Uri number = Uri.parse("tel:5551234");
//                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
//                startActivity(callIntent);
//                startActivityForResult(callIntent, 1);
            }
        });


        //Todo STEP 3: Set on Click Listener.

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.v("Check Value", "Hello From Log");
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                myIntent.putExtra("key", "Answer Selected");
                myIntent.putExtra("total_mark", "Total Mark");
                //TODO STep 2 Start Activity For Result
                startActivityForResult(myIntent,1);
            }
        });
    }


    //Todo STep 3 onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String valueFromSecondActivity = data.getStringExtra("key");
                myEditText.setText(valueFromSecondActivity);
            }
        }
    }
}