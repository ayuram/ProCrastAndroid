package com.example.procrast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView)findViewById(R.id.tv1);
        textView.setId(0);
        names.add(textView.getText().toString());
        if(getIntent().getExtras() != null){
            String name = getIntent().getExtras().getString("nameChange");
            textView.setText(name);
            names.set(0, name);
        }
        final FloatingActionButton addAct = (FloatingActionButton)findViewById(R.id.add);
        addAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addField("text");

            }
        });
        final String string = textView.getText().toString();

        final FloatingActionButton nextActivity = (FloatingActionButton)findViewById(R.id.edit);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, createactivities.class);
                intent.putExtra("prename",  string);
                intent.putExtra("customer", textView.getId());
                startActivity(intent);
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putStringArrayList("list", names);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        ArrayList<String> list = savedInstanceState.getStringArrayList("list");
        for(int i = 0; i < list.size(); i++){
            addField(list.get(i));
        }
    }


    public void addField(String tempName){
        Button myButton = new Button(this);

        final TextView textView = new TextView(this);
        textView.setText(tempName);
        textView.setId(names.size());
        names.add(textView.getText().toString());
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, createactivities.class);
                intent.putExtra("prename", textView.getText().toString());
                intent.putExtra("customer", textView.getId());
                startActivity(intent);
            }
        });
        LinearLayout layout = new LinearLayout(this);
        layout.addView(textView);
        layout.addView(myButton);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout ll = (LinearLayout)findViewById(R.id.fields);
        ll.addView(layout);
    }

    public void checkIntents(){
        Bundle extras = getIntent().getExtras();
        if(getIntent().hasExtra("nameChange")){
            int id = extras.getInt("id");
            TextView view = (TextView)findViewById(id);
            view.setText(extras.getString("nameChange"));
        }
    }
}
