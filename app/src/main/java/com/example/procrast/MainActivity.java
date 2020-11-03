package com.example.procrast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private DataStruct data = new DataStruct();
    private ArrayList<String> names;
    ListView listView;
    FloatingActionButton nextActivity;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = new ArrayList<String>();
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list);
        if(getIntent().getExtras() != null){
            if(savedInstanceState != null) {
                names = savedInstanceState.getStringArrayList("names");
                System.out.print("YES!");
            }
            String name = getIntent().getExtras().getString("nameChange");
            data.activities.add(new Activity(name));
            names.add(name);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(arrayAdapter);
        nextActivity = (FloatingActionButton)findViewById(R.id.add);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, createactivities.class);
                startActivity(intent);
                data.activities.add(new Activity("Carlos"));
                //savedInstanceState.putStringArrayList("names", names);
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putStringArrayList("names", names);
        // etc.
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        names = savedInstanceState.getStringArrayList("names");
    }


//    public void addField(String tempName){
//        Button myButton = new Button(this);
//
//        final TextView textView = new TextView(this);
//        textView.setText(tempName);
//        textView.setId(names.size());
//        names.add(textView.getText().toString());
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, createactivities.class);
//                intent.putExtra("prename", textView.getText().toString());
//                intent.putExtra("customer", textView.getId());
//                startActivity(intent);
//            }
//        });
//        LinearLayout layout = new LinearLayout(this);
//        layout.addView(textView);
//        layout.addView(myButton);
//        layout.setOrientation(LinearLayout.HORIZONTAL);
//        LinearLayout ll = (LinearLayout)findViewById(R.id.fields);
//        ll.addView(layout);
//    }

//    public void checkIntents(){
//        Bundle extras = getIntent().getExtras();
//        if(getIntent().hasExtra("nameChange")){
//            int id = extras.getInt("id");
//            TextView view = (TextView)findViewById(id);
//            view.setText(extras.getString("nameChange"));
//        }
//    }
}
