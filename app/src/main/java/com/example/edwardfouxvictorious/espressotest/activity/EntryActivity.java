package com.example.edwardfouxvictorious.espressotest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.edwardfouxvictorious.espressotest.R;

public class EntryActivity extends Activity {
    public static final String SOUTH = "south";
    public static final String WEST = "west";
    public static final String NORTH = "north";
    public static final String EAST = "east";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_layout);

        Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.edittext1);
        final EditText editText2 = (EditText) findViewById(R.id.edittext2);
        final EditText editText3 = (EditText) findViewById(R.id.edittext3);
        final EditText editText4 = (EditText) findViewById(R.id.edittext4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                intent.putExtra(SOUTH, editText.getText());
                intent.putExtra(EAST, editText2.getText());
                intent.putExtra(WEST, editText3.getText());
                intent.putExtra(NORTH, editText4.getText());
                startActivity(intent);
            }
        });
    }
}
