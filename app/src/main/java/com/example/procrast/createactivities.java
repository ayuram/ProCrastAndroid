package com.example.procrast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class createactivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createactivities);
        final EditText pretext = (EditText)findViewById(R.id.editText);
        final String original = pretext.getText().toString();
        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createactivities.this, MainActivity.class);
                intent.putExtra("nameChange", pretext.getText().toString());
                startActivity(intent);
            }
        });
        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pretext.setText("");
            }
        });
    }
}
