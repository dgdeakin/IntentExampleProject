package com.application.intentexampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

//    TOdo STEP 1 TextView Variable
    TextView dTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Todo STEP 2: Link TextView with the ID
        dTextView = findViewById(R.id.textView);
        backButton = findViewById(R.id.buttonBackButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent();
                backIntent.putExtra("key", "Value from Second Activity");
                setResult(SecondActivity.RESULT_OK, backIntent);
                finish();
            }
        });



        //Todo STEP 3: ggetIntent()
        Intent sentIntent = getIntent();
        String sentValue = sentIntent.getStringExtra("key");


        //Todo STEP 4: setText()
        dTextView.setText(sentValue);

    }

}